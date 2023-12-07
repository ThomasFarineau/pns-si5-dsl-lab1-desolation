sensor "button" onPin 8
actuator "led" pin 11


state "on" means "led" becomes "high"
state "off" means "led" becomes "low"

from "off" to "on" when "button" becomes "high"
delay 1000 from "on" to "off"

export "Temporal transition!"