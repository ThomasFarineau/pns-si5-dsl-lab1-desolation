package io.github.mosser.arduinoml.externals.antlr;

import io.github.mosser.arduinoml.externals.antlr.grammar.*;
import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.Action;
import io.github.mosser.arduinoml.kernel.behavioral.Condition;
import io.github.mosser.arduinoml.kernel.behavioral.Delayer;
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class ModelBuilder extends ArduinomlBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp = null;
    private boolean built = false;

    public App retrieve() {
        if (built) {
            return theApp;
        }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/

    private Map<String, Sensor> sensors = new HashMap<>();
    private Map<String, Actuator> actuators = new HashMap<>();
    private Map<String, State>    states  = new HashMap<>();
    private Map<String, List<Binding>>  bindings  = new HashMap<>(); //Transitions
    private Map<Binding, List<Condition>> conditionsMap = new HashMap<>();

    private int bindingNumber = 0;

    private class Binding {
        public String to;
        public List<Condition> trigger;       
        public List<OPERATOR> opList;
    }
    
    private class BindingDelayer { // used to support state resolution for transitions
        String to; // name of the next state, as its instance might not have been compiled yet
        int duration;
    }

    private class Identifier { // used to support state resolution for transitions
        String name;
        SIGNAL value;

        Identifier(String name, SIGNAL value) {
            this.name = name;
            this.value = value;
        }

    }

    private State currentState = null;

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(ArduinomlParser.RootContext ctx) {
        built = false;
        theApp = new App();
    }

    @Override
    public void exitRoot(ArduinomlParser.RootContext ctx) {
        // Resolving states in transitions
        bindings.forEach((key, binding) ->  {

            binding.forEach((b) -> {
                
                Transition t = new Transition();
                t.setCondition(b.trigger);
                t.setNext(states.get(b.to));
                t.setOpList(b.opList);
                states.get(key).setTransition(t);
            });
        });
        delayers.forEach((key, delayer) -> {
            Delayer d = new Delayer();
            d.setDuration(delayer.duration);
            d.setNext(states.get(delayer.to));
            states.get(key).setDelayer(d);
        });
        this.built = true;
    }

    @Override
    public void enterDeclaration(ArduinomlParser.DeclarationContext ctx) {
        theApp.setName(ctx.name.getText());
    }

    @Override
    public void enterSensor(ArduinomlParser.SensorContext ctx) {
        Sensor sensor = new Sensor();
        sensor.setName(ctx.location().id.getText());
        sensor.setPin(Integer.parseInt(ctx.location().port.getText()));
        this.theApp.getBricks().add(sensor);
        sensors.put(sensor.getName(), sensor);
    }

    @Override
    public void enterActuator(ArduinomlParser.ActuatorContext ctx) {
        Actuator actuator = new Actuator();
        actuator.setName(ctx.location().id.getText());
        actuator.setPin(Integer.parseInt(ctx.location().port.getText()));
        this.theApp.getBricks().add(actuator);
        actuators.put(actuator.getName(), actuator);
    }

    @Override
    public void enterState(ArduinomlParser.StateContext ctx) {
        State local = new State();
        local.setName(ctx.name.getText());
        this.currentState = local;
        this.states.put(local.getName(), local);
    }

    @Override
    public void exitState(ArduinomlParser.StateContext ctx) {
        this.theApp.getStates().add(this.currentState);
        this.currentState = null;
    }

    @Override
    public void enterAction(ArduinomlParser.ActionContext ctx) {
        Action action = new Action();
        action.setActuator(actuators.get(ctx.receiver.getText()));
        action.setValue(SIGNAL.valueOf(ctx.value.getText()));
        currentState.getActions().add(action);
    }

    @Override
    public void exitTransition(ArduinomlParser.TransitionContext ctx) {
        bindingNumber++;
    }

    public void enterTransition(ArduinomlParser.TransitionContext ctx) {
        
        List<Binding> bindingsList = bindings.get(currentState.getName());
        if (bindingsList == null) {
            bindingsList = new ArrayList<>();
            bindingNumber = 0;
        }
        Binding binding = new Binding();
        binding.to = ctx.next.getText();
        binding.trigger = null; 
        binding.opList = new ArrayList<>();

        List<TerminalNode> test = ctx.CONDITION_TYPE();
        for (TerminalNode t : test) {
            binding.opList.add(OPERATOR.valueOf(t.getText()));
        }
        
        bindingsList.add(binding);
        bindings.put(currentState.getName(), bindingsList);
    }

    @Override
    public void enterCondition(ArduinomlParser.ConditionContext ctx) {
        Condition condition = new Condition();

        List<Binding> bindingsList = bindings.get(currentState.getName());
        Binding binding = bindingsList.get(bindingNumber);

        List<Condition> conditions = conditionsMap.get(binding);
        if (conditions == null) {
            conditions = new ArrayList<>();
        }
        condition.setSensor(sensors.get(ctx.trigger.getText()));
        condition.setValue(SIGNAL.valueOf(ctx.value.getText()));
        conditions.add(condition);

        binding.trigger = conditions;
        bindingsList.set(bindingNumber, binding);
        bindings.put(currentState.getName(), bindingsList);

        conditionsMap.put(binding, conditions);
    }

    @Override
    public void enterDelay(ArduinomlParser.DelayContext ctx) {
        BindingDelayer toBeResolvedLater = new BindingDelayer();
        toBeResolvedLater.to = ctx.next.getText();
        toBeResolvedLater.duration = Integer.parseInt(ctx.duration.getText());

        this.delayers.put(currentState.getName(), toBeResolvedLater);
    }

    @Override
    public void enterInitial(ArduinomlParser.InitialContext ctx) {
        this.theApp.setInitial(this.currentState);
    }

}

