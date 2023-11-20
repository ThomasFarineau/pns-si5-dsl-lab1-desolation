// Wiring code generated from an ArduinoML model
// Application name: multi_state_alarm

long debounce = 200;

enum STATE {buzzer_on, led_on, off};
STATE currentState = off;

boolean buttonBounceGuard = false;
long buttonLastDebounceTime = 0;

void setup(){
  pinMode(9, INPUT);  // button [Sensor]
  pinMode(11, OUTPUT); // buzzer [Actuator]
  pinMode(12, OUTPUT); // led [Actuator]
}

void loop() {
        switch(currentState){
                case buzzer_on:
                        digitalWrite(11,HIGH);
                        buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
                        if( digitalRead(9) == HIGH && buttonBounceGuard) {
                                buttonLastDebounceTime = millis();
                                currentState = led_on;
                        }
                break;
                case led_on:
                        digitalWrite(12,HIGH);
                        digitalWrite(11,LOW);
                        buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
                        if( digitalRead(9) == HIGH && buttonBounceGuard) {
                                buttonLastDebounceTime = millis();
                                currentState = off;
                        }
                break;
                case off:
                        digitalWrite(12,LOW);
                        buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
                        if( digitalRead(9) == HIGH && buttonBounceGuard) {
                                buttonLastDebounceTime = millis();
                                currentState = buzzer_on;
                        }
                break;
        }
}