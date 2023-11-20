
import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import static io.github.mosser.arduinoml.embedded.java.dsl.AppBuilder.*;

public class DualCheckAlarm{
    public static void main (String[] args) {

        App myApp =
                application("dual_check_alarm")
                        .uses(sensor("buttonOne", 9))
                        .uses(sensor("buttonTwo", 10))
                        .uses(actuator("buzzer", 11))
                        .hasForState("on")
                            .setting("buzzer").toHigh()
                        .endState()
                        .hasForState("buttonOnePressed").initial()
                            .setting("buzzer").toLow()
                        .endState()
                        .hasForState("buttonTwoPressed").initial()
                            .setting("buzzer").toLow()
                        .endState()
                        .hasForState("off").initial()
                            .setting("buzzer").toLow()
                        .endState()
                        .beginTransitionTable()
                            .from("off").when("buttonOne").isHigh().goTo("buttonOnePressed")
                            .from("off").when("buttonTwo").isHigh().goTo("buttonTwoPressed")
                            .from("buttonOnePressed").when("buttonOne").isLow().goTo("off")
                            .from("buttonOnePressed").when("buttonTwo").isHigh().goTo("on")
                            .from("buttonTwoPressed").when("buttonTwo").isLow().goTo("off")
                            .from("buttonTwoPressed").when("buttonOne").isHigh().goTo("on")
                            .from("on").when("buttonOne").isLow().goTo("buttonTwoPressed")
                            .from("on").when("buttonTwo").isLow().goTo("buttonOnePressed")
                        .endTransitionTable()
                .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }
}