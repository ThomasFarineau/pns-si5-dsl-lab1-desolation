sensor "button" onPin 8
actuator "led" pin 11
actuator "buzz" pin 12

state "off" means "led" becomes "low" and "buzz" becomes "low"

state "buzzOn" means "buzz" becomes "high" and "led" becomes "low"

state "ledOn" means "led" becomes "high" and "buzz" becomes "low"

initial "off"

from "off" to "buzzOn" when "button" becomes "high"
from "buzzOn" to "ledOn" when "button" becomes "high"
from "ledOn" to "off" when "button" becomes "high"

export "Multi state alarm!"