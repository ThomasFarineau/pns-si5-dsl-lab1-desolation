package groovuinoml.dsl;

import java.util.*;

import groovy.lang.Binding;
import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.*;

public class GroovuinoMLModel {
	private List<Brick> bricks;
	private List<State> states;

	private HashMap<String, HashMap<String, Transition>> transitions;

	private State initialState;
	
	private Binding binding;
	
	public GroovuinoMLModel(Binding binding) {
		this.bricks = new ArrayList<>();
		this.states = new ArrayList<>();
		this.transitions = new HashMap<>(new HashMap<>());
		this.binding = binding;
	}
	
	public void createSensor(String name, Integer pinNumber) {
		Sensor sensor = new Sensor();
		sensor.setName(name);
		sensor.setPin(pinNumber);
		this.bricks.add(sensor);
		this.binding.setVariable(name, sensor);
//		System.out.println("> sensor " + name + " on pin " + pinNumber);
	}
	
	public void createActuator(String name, Integer pinNumber) {
		Actuator actuator = new Actuator();
		actuator.setName(name);
		actuator.setPin(pinNumber);
		this.bricks.add(actuator);
		this.binding.setVariable(name, actuator);
	}
	
	public void createState(String name, List<Action> actions) {
		State state = new State();
		state.setName(name);
		state.setActions(actions);
		this.states.add(state);
		this.binding.setVariable(name, state);
	}

	void createTransition(State from, State to, Sensor sensor, SIGNAL value, OPERATOR operator) {
		this.transitions.computeIfAbsent(from.getName(), k -> new HashMap<>());
		this.transitions.get(from.getName()).computeIfAbsent(to.getName(), k -> new Transition());
		Transition init = transitions.get(from.getName()).get(to.getName());
		Transition transition = transitions.get(from.getName()).get(to.getName());
		Condition condition = new Condition();
		transition.setNext(to);
		condition.setSensor(sensor);
		condition.setValue(value);
		transition.addCondition(condition);
		if (operator != null) {
			transition.addOp(operator);
		}
	}

	public void createDelayer(State from, State to, Integer delay){
		Delayer delayer = new Delayer();
		delayer.setDuration(delay);
		delayer.setNext(to);
		from.setDelayer(delayer);
	}
	
	public void setInitialState(State state) {
		this.initialState = state;
	}
	
	@SuppressWarnings("rawtypes")
	public Object generateCode(String appName) {
		App app = new App();
		app.setName(appName);
		app.setBricks(this.bricks);
		app.setStates(this.states);
		app.setInitial(this.initialState);

		transitions.forEach((from, to) -> to.forEach((toState, transition) -> this.states.forEach(state -> {
			if (state.getName().equals(from)) {
				state.addTransition(transition);
			}
		})));

		Visitor codeGenerator = new ToWiring();
		app.accept(codeGenerator);

		return codeGenerator.getResult();
	}


}
