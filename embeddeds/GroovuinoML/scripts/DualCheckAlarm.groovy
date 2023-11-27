sensor "buttonOne" onPin 8
sensor "buttonTwo" onPin 9
actuator "led" pin 11

state "on" means "led" becomes "high"
state "off" means "led" becomes "low"
state "buttonOneOn" means "led" becomes "low"
state "buttonTwoOn" means "led" becomes "low"

initial "off"

from "off" to "buttonOneOn" when "buttonOne" becomes "high"
from "off" to "buttonTwoOn" when "buttonTwo" becomes "high"
from "buttonOneOn" to "on" when "buttonTwo" becomes "high"
from "buttonOneOn" to "off" when "buttonOne" becomes "low"
from "buttonTwoOn" to "on" when "buttonOne" becomes "high"
from "buttonTwoOn" to "off" when "buttonTwo" becomes "low"
from "on" to "buttonTwoOn" when "buttonOne" becomes "low"
from "on" to "buttonOneOn" when "buttonTwo" becomes "low"