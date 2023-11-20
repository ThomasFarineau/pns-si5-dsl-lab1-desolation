
import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import static io.github.mosser.arduinoml.embedded.java.dsl.AppBuilder.*;

public class MultiStateAlarm{
    public static void main (String[] args) {

        App myApp =
                application("multi_state_alarm")
                        .uses(sensor("button", 9))
                        .uses(actuator("buzzer", 11))
                        .uses(actuator("led", 12))
                        .hasForState("buzzer_on")
                            .setting("buzzer").toHigh()
                        .endState()
                        .hasForState("led_on").initial()
                            .setting("led").toHigh()
                            .setting("buzzer").toLow()
                        .endState()
                        .hasForState("off").initial()
                            .setting("led").toLow()
                        .endState()
                        .beginTransitionTable()
                            .from("buzzer_on").when("button").isHigh().goTo("led_on")
                            .from("led_on").when("button").isHigh().goTo("off")
                            .from("off").when("button").isHigh().goTo("buzzer_on")
                        .endTransitionTable()
                .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }
}