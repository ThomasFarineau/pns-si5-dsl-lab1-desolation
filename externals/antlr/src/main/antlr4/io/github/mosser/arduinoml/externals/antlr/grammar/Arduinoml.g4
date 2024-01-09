grammar Arduinoml;


/******************
 ** Parser rules **
 ******************/

root            :   declaration bricks states EOF;

declaration     :   'application' name=IDENTIFIER;

bricks          :   (sensor|actuator)+;
    sensor      :   'sensor'   location ;
    actuator    :   'actuator' location ;
    location    :   id=IDENTIFIER ':' port=PORT_NUMBER;

states          :   state+;
    state       :   initial? name=IDENTIFIER '{'  action+ transition* delay? '}';
    action      :   receiver=IDENTIFIER '<=' value=SIGNAL;
    transition  :   condition (type=CONDITION_TYPE condition)* '=>' next=IDENTIFIER ;
    condition   :   trigger=IDENTIFIER 'is' value=SIGNAL ;
    delay       :   'delay' time=INT 'ms' '=>' next=IDENTIFIER;
    initial     :   '->';
      

/*****************
 ** Lexer rules **
 *****************/

CONDITION_TYPE  :   'or'|'and';
PORT_NUMBER     :   [1-9] | '11' | '12';
IDENTIFIER      :   LOWERCASE (LOWERCASE|UPPERCASE)+;
SIGNAL          :   'HIGH' | 'LOW';
INT             :   NUMBER+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
fragment NUMBER     : [0-9];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
