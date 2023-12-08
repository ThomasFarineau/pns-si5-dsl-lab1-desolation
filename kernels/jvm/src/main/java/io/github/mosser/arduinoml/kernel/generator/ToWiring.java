package io.github.mosser.arduinoml.kernel.generator;

import java.util.List;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.Action;
import io.github.mosser.arduinoml.kernel.behavioral.Delayer;
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.Condition;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.Brick;
import io.github.mosser.arduinoml.kernel.structural.Sensor;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
    enum PASS {ONE, TWO}


    public ToWiring() {
        this.result = new StringBuffer();
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    @Override
    public void visit(App app) {
        //first pass, create global vars
        context.put("pass", PASS.ONE);
        w("// Wiring code generated from an ArduinoML model\n");
        w(String.format("// Application name: %s\n", app.getName()) + "\n");

        w("long debounce = 200;\n");
        w("\nenum STATE {");
        String sep = "";
        for (State state : app.getStates()) {
            w(sep);
            state.accept(this);
            sep = ", ";
        }
        w("};\n");
        if (app.getInitial() != null) {
            w("STATE currentState = " + app.getInitial().getName() + ";\n");
        }

        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }

        //second pass, setup and loop
        context.put("pass", PASS.TWO);
        w("\nvoid setup(){\n");
        for (Brick brick : app.getBricks()) {
            brick.accept(this);
        }
        w("}\n");

        w("\nvoid loop() {\n" +
                "\tswitch(currentState){\n");
        for (State state : app.getStates()) {
            state.accept(this);
        }
        w("\t}\n" +
                "}");
    }

    @Override
    public void visit(Actuator actuator) {
        if (context.get("pass") == PASS.ONE) {
            return;
        }
        if (context.get("pass") == PASS.TWO) {
            w(String.format("  pinMode(%d, OUTPUT); // %s [Actuator]\n", actuator.getPin(), actuator.getName()));
            return;
        }
    }


    @Override
    public void visit(Sensor sensor) {
        if (context.get("pass") == PASS.ONE) {
            w(String.format("\nboolean %sBounceGuard = false;\n", sensor.getName()));
            w(String.format("long %sLastDebounceTime = 0;\n", sensor.getName()));
            return;
        }
        if (context.get("pass") == PASS.TWO) {
            w(String.format("  pinMode(%d, INPUT);  // %s [Sensor]\n", sensor.getPin(), sensor.getName()));
            return;
        }
    }

    @Override
    public void visit(State state) {
        if (context.get("pass") == PASS.ONE) {
            w(state.getName());
            return;
        }
        if (context.get("pass") == PASS.TWO) {
            w("\t\tcase " + state.getName() + ":\n");
            for (Action action : state.getActions()) {
                action.accept(this);
            }
            
            if (state.getDelayer() != null) {
                state.getDelayer().accept(this);
            }

            for (Transition s : state.getTransition()){
                s.accept(this);
                w("\t\t\t\tbreak;\n");
                w("\t\t\t}\n");
            }
        }
        return;
    }
	

	@Override
	public void visit(Condition condition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format(" digitalRead(%d) == %s && %sBounceGuard",condition.getSensor().getPin(),condition.getValue(),condition.getSensor().getName()));
			return;
		}
	}

	@Override
	public void visit(Transition transition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			List<Condition> conditions = transition.getCondition();
			for (Condition condition : conditions) {
				String sensorName = condition.getSensor().getName();
				w(String.format("\t\t\t%sBounceGuard = millis() - %sLastDebounceTime > debounce;\n", sensorName, sensorName));
			}
			w(String.format("\t\t\tif("));
			for (Condition condition : conditions) {
				if (conditions.indexOf(condition) != 0) {
					if(transition.getOpList().get(conditions.indexOf(condition)-1) == OPERATOR.and){
						w(" && ");
					}
					else{
						w(" || ");
					}
				}
				visit(condition);

			}

			w(" ){\n");
			for (Condition condition : conditions) {
				String sensorName = condition.getSensor().getName();
				w(String.format("\t\t\t\t%sLastDebounceTime = millis();\n", sensorName));
			}
			w("\t\t\t\tcurrentState = " + transition.getNext().getName() + ";\n");
			return;
		}
	}

    @Override
    public void visit(Action action) {
        if (context.get("pass") == PASS.ONE) {
            return;
        }
        if (context.get("pass") == PASS.TWO) {
            w(String.format("\t\t\tdigitalWrite(%d,%s);\n", action.getActuator().getPin(), action.getValue()));
            return;
        }
    }

    @Override
    public void visit(Delayer delayer) {
        if (context.get("pass") == PASS.ONE) {
            return;
        }
        if (context.get("pass") == PASS.TWO) {
            w(String.format("\t\t\tdelay(%d);\n", delayer.getDuration()));
            w(String.format("\t\t\tcurrentState = %s;\n", delayer.getNext().getName()));
            return;
        }
    }

}
