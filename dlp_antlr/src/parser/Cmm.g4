grammar Cmm;

// lab 4
program
    : definition* main
    ;


main
    : 'void' 'main' '(' ')' '{' variable_def* statement* '}'
    ;
expression
    : '(' expression ')'                                            // Parenthesis
    | expression '[' expression ']'                                 // Indexing
    | expression '.' ID                                             // Record accessor
    | '(' builtin_type ')' expression                                       // Cast
    | '-' expression                                                // Unary minus
    | '!' expression                                                // Negation
    | expression ( '*' | '/' | '%' ) expression                     // Multiplication division and modulus
    | expression ( '+' | '-' ) expression                           // Addition and sbustraction
    | expression ('<' | '>' | '>=' | '<=' | '==' | '!=') expression // Comparison
    | expression ('&&' | '||') expression                           // Logic operations
    | ID '(' expression  (',' expression)* ')'                      // Function
    | ID                                                            // ID
    | INT_CONSTANT                                                  // Constants
    | CHAR_CONSTANT
    | REAL_CONSTANT
    ;

definition
    : variable_def
    | return_type ID '(' (type ID (',' type ID)*)? ')' '{' variable_def* statement*'}'
    ;

variable_def
    : type ID (',' ID)* ';'
    ;

statement
    : ('read' | 'write') expression (',' expression)* ';'       // Read and write
    | 'while' '(' expression ')' code_block                     // While
    | 'if' '(' expression ')' code_block                        // If
    | 'if' '(' expression ')' code_block 'else' code_block      // If Else
    | expression '=' expression ';'                             // Assignment
    | 'return' expression                                       // Return
    | ID '(' ID (',' ID)* ')' ';'                               // Function Invocation
    | ID '()' ';'                                               // Procedure invocation
    ;

code_block
    : expression
    | '{' expression* '}'
    ;


type
    : return_type
    | type '[' INT_CONSTANT ']'
    | 'struct' '{' (type ID ';')+ '}'
    ;

return_type
    : 'void'
    | builtin_type
    ;

builtin_type
    : 'int'
    | 'char'
    | 'double'
    ;

// lab 3
COMMENT
    : '//' ~'\n'* -> skip
    ;

MULTI_LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;

ID
    : [A-Za-z_][A-Za-z0-9_]*
    ;

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

CHAR_CONSTANT
    : '\'' ( '\\'[nt] | '\\'INT_CONSTANT | . ) '\''
    ;
