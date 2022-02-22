grammar Cmm;	

program:
       ;

  		 
COMMENT: '//' ~'\n'* -> skip ;

MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip ;

ID: [A-Za-z_][A-Za-z0-9_]* ;

fragment
DIGIT
    : [0-9]
    ;

INT_CONSTANT
    : [1-9]DIGIT*
    | '0'
    ;

WHITE_SPACES
    : ( ' ' | '\t' | '\n' | '\r' ) -> skip
    ;

fragment
EXPONENT
    : [eE][+-]?INT_CONSTANT
    ;

REAL_CONSTANT
    : INT_CONSTANT '.' DIGIT* EXPONENT?
    | INT_CONSTANT? '.' DIGIT+ EXPONENT?
    | INT_CONSTANT EXPONENT
    ;

fragment
VALID_CHAR
    : '\\'[nt]
    | '\\'INT_CONSTANT
    | .
    ;

CHAR_CONSTANT
    : '\'' VALID_CHAR '\''
    ;
