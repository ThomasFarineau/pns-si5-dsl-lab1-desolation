package groovuinoml.dsl

import io.github.mosser.arduinoml.kernel.behavioral.Action
import io.github.mosser.arduinoml.kernel.behavioral.State
import io.github.mosser.arduinoml.kernel.structural.Actuator
import io.github.mosser.arduinoml.kernel.structural.OPERATOR
import io.github.mosser.arduinoml.kernel.structural.SIGNAL
import io.github.mosser.arduinoml.kernel.structural.Sensor

abstract class GroovuinoMLBasescript extends Script {
    // sensor "name" pin n
    def sensor(String name) {
        [pin  : { n -> ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createSensor(name, n) },
         onPin: { n -> ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createSensor(name, n) }]
    }

    // actuator "name" pin n
    def actuator(String name) {
        [pin: { n -> ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createActuator(name, n) }]
    }

    // state "name" means actuator becomes signal [and actuator becomes signal]*n
    def state(String name) {
        List<Action> actions = new ArrayList<Action>()
        ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createState(name, actions)
        // recursive closure to allow multiple and statements
        def closure
        closure = { actuator ->
            [becomes: { signal ->
                Action action = new Action()
                action.setActuator(actuator instanceof String ? (Actuator) ((GroovuinoMLBinding) this.getBinding()).getVariable(actuator) : (Actuator) actuator)
                action.setValue(signal instanceof String ? (SIGNAL) ((GroovuinoMLBinding) this.getBinding()).getVariable(signal) : (SIGNAL) signal)
                actions.add(action)
                [and: closure]
            }]
        }
        [means: closure]
    }

    // initial state
    def initial(state) {
        ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().setInitialState(state instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state) : (State) state)
    }

    // from state1 to state2 when sensor becomes signal
    def from(state1) {
        [to: { state2 ->
            [when: { sensor ->
                [becomes: { signal ->
                    ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createTransition(
                            state1 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state1) : (State) state1,
                            state2 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state2) : (State) state2,
                            sensor instanceof String ? (Sensor) ((GroovuinoMLBinding) this.getBinding()).getVariable(sensor) : (Sensor) sensor,
                            signal instanceof String ? (SIGNAL) ((GroovuinoMLBinding) this.getBinding()).getVariable(signal) : (SIGNAL) signal,
                            null
                    )
                    def andCondition
                    def orCondition
                    andCondition = { sensor2 ->
                        [becomes: { signal2 ->
                            ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createTransition(
                                state1 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state1) : (State) state1,
                                state2 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state2) : (State) state2,
                                sensor2 instanceof String ? (Sensor) ((GroovuinoMLBinding) this.getBinding()).getVariable(sensor2) : (Sensor) sensor2,
                                signal2 instanceof String ? (SIGNAL) ((GroovuinoMLBinding) this.getBinding()).getVariable(signal2) : (SIGNAL) signal2,
                                OPERATOR.and
                            )
                            [and: andCondition]
                            [or: orCondition]
                        }]
                    }
                    orCondition = { sensor3 ->
                        [becomes: { signal3 ->
                            ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createTransition(
                                state1 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state1) : (State) state1,
                                state2 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state2) : (State) state2,
                                sensor3 instanceof String ? (Sensor) ((GroovuinoMLBinding) this.getBinding()).getVariable(sensor3) : (Sensor) sensor3,
                                signal3 instanceof String ? (SIGNAL) ((GroovuinoMLBinding) this.getBinding()).getVariable(signal3) : (SIGNAL) signal3,
                                OPERATOR.or
                            )
                            [and: andCondition]
                            [or: orCondition]
                        }]
                    }

                    [or: orCondition,
                    and: andCondition]
                }]
            }]
        }]
    }

    // delay n from state1 to state2
    def delay(n) {
        [from: { state1 ->
            [to: { state2 ->
                ((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createDelayer(
                        state1 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state1) : (State) state1,
                        state2 instanceof String ? (State) ((GroovuinoMLBinding) this.getBinding()).getVariable(state2) : (State) state2,
                        n instanceof String ? (Integer) ((GroovuinoMLBinding) this.getBinding()).getVariable(n) : (Integer) n
                )
            }]
        }]
    }

    // export name
    def export(String name) {
        println(((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().generateCode(name).toString())
    }

    // disable run method while running
    int count = 0

    abstract void scriptBody()

    def run() {
        if (count == 0) {
            count++
            scriptBody()
        } else {
            println "Run method is disabled"
        }
    }
}
