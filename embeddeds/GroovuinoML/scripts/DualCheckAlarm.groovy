sensor "buttonOne" onPin 8
sensor "buttonTwo" onPin 9
actuator "led" pin 11

state "on" means "led" becomes "high"
state "off" means "led" becomes "low"
state "buttonOneOn" means "led" becomes "low"
state "buttonTwoOn" means "led" becomes "low"

initial "off"

from "on" to "off" when "buttonOne" becomes "low" and "buttonTwo" becomes "low"
from "off" to "on" when "buttonOne" becomes "high" or "buttonTwo" becomes "high"

export "Dual check alarm!"