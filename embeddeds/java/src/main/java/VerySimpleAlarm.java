
import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import static io.github.mosser.arduinoml.embedded.java.dsl.AppBuilder.*;

public class VerySimpleAlarm {
    public static void main (String[] args) {

        App myApp =
                application("very_simple_alarm")
                    .uses(sensor("button", 9))
                    .uses(actuator("buzzer", 11))
                    .uses(actuator("led", 12))
                    .hasForState("on")
                        .setting("led").toHigh()
                        .setting("buzzer").toHigh()
                    .endState()
                    .hasForState("off").initial()
                        .setting("led").toLow()
                        .setting("buzzer").toLow()
                    .endState()
                    .beginTransitionTable()
                        .from("on").when("button").isLow().goTo("off")
                        .from("off").when("button").isHigh().goTo("on")
                    .endTransitionTable()
                .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }
}
