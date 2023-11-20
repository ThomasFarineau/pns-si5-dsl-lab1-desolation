// Wiring code generated from an ArduinoML model
// Application name: dual_check_alarm

long debounce = 200;

enum STATE {on, buttonOnePressed, buttonTwoPressed, off};
STATE currentState = off;

boolean buttonOneBounceGuard = false;
long buttonOneLastDebounceTime = 0;

boolean buttonTwoBounceGuard = false;
long buttonTwoLastDebounceTime = 0;

void setup(){
  pinMode(9, INPUT);  // buttonOne [Sensor]
  pinMode(10, INPUT);  // buttonTwo [Sensor]
  pinMode(11, OUTPUT); // buzzer [Actuator]
}

void loop() {
        switch(currentState){
                case on:
                        digitalWrite(11,HIGH);
                        buttonTwoBounceGuard = millis() - buttonTwoLastDebounceTime > debounce;
                        if( digitalRead(10) == LOW && buttonTwoBounceGuard) {
                                buttonTwoLastDebounceTime = millis();
                                currentState = buttonOnePressed;
                        }
                break;
                case buttonOnePressed:
                        digitalWrite(11,LOW);
                        buttonTwoBounceGuard = millis() - buttonTwoLastDebounceTime > debounce;
                        if( digitalRead(10) == HIGH && buttonTwoBounceGuard) {
                                buttonTwoLastDebounceTime = millis();
                                currentState = on;
                        }
                break;
                case buttonTwoPressed:
                        digitalWrite(11,LOW);
                        buttonOneBounceGuard = millis() - buttonOneLastDebounceTime > debounce;
                        if( digitalRead(9) == HIGH && buttonOneBounceGuard) {
                                buttonOneLastDebounceTime = millis();
                                currentState = on;
                        }
                break;
                case off:
                        digitalWrite(11,LOW);
                        buttonTwoBounceGuard = millis() - buttonTwoLastDebounceTime > debounce;
                        if( digitalRead(10) == HIGH && buttonTwoBounceGuard) {
                                buttonTwoLastDebounceTime = millis();
                                currentState = buttonTwoPressed;
                        }
                break;
        }
}