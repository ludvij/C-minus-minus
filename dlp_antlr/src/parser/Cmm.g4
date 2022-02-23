grammar Cmm;

// lab 4
program
    : definition* main
    ;



// Some weird shenanigans here, if I write '(' ')' in the production
// then void main() {} it is not valid
// But if I write '()' then void main( ) is not valid
// I don't understand
// So I did this fix to be able to have the two of them
// in procedure is the same
main
    : 'void' 'main' ('(' ')' | '()' ) '{' variable_def* statement* '}'
    ;
expression
    : '(' expression ')'                                            // 1  - Parenthesis
    | expression '[' expression ']'                                 // 2  - Indexing
    | expression '.' ID                                             // 3  - Record accessor
    | '(' builtin_type ')' expression                               // 4  - Cast
    | '-' expression                                                // 5  - Unary minus
    | '!' expression                                                // 6  - Negation
    | expression ( '*' | '/' | '%' ) expression                     // 7  - Multiplication division and modulus
    | expression ( '+' | '-' ) expression                           // 8  - Addition and sbustraction
    | expression ('<' | '>' | '>=' | '<=' | '==' | '!=') expression // 9  - Comparison
    | expression ('&&' | '||') expression                           // 10 - Logic operations
    | ID '(' expression  (',' expression)* ')'                      // 11 - Function
    | ID                                                            // 12 - ID
    | INT_CONSTANT                                                  // 13 - Constants
    | CHAR_CONSTANT                                                 // 14
    | REAL_CONSTANT                                                 // 15
    ;

definition
    : return_type ID ('(' type ID (',' type ID)* ')' | '()' | '(' ')' ) '{' variable_def* statement*'}'
    | variable_def
    ;

variable_def
    : type ID (',' ID)* ';'
    ;

statement
    : 'read' expression (',' expression)* ';'                   // 1 - Read
    | 'write' expression (',' expression)* ';'                  // 2 - Write
    | 'while' '(' expression ')' code_block                     // 3 - While
    | 'if' '(' expression ')' code_block                        // 4 - If
    | 'if' '(' expression ')' code_block 'else' code_block      // 5 - If Else
    | expression '=' expression ';'                             // 6 - Assignment
    | 'return' expression ';'                                   // 7 - Return
    | ID '(' expression (',' expression)* ')' ';'               // 8 - Function Invocation
    | ID ('()' | '(' ')') ';'                                   // 9 - Procedure invocation
    ;

code_block
    : statement
    | '{' statement* '}'
    ;


type
    : return_type                       // 1 - return types
    | type '[' INT_CONSTANT ']'         // 2 - array type
    | 'struct' '{' (type ID ';')+ '}'   // 3 - struct type
    ;

return_type
    : 'void'        // 1 - void type
    | builtin_type  // 2 - builtin types
    ;

builtin_type
    : 'int'     // 1 - int type
    | 'char'    // 2 - char type
    | 'double'  // 3 - double type
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
