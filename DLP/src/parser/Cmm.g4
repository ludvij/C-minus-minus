grammar Cmm;

@header {
    import ast.*;
    import ast.types.*;
    import ast.program.*;
    import ast.statements.*;
    import ast.definitions.*;
    import ast.expressions.*;
}


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


expression returns [Expression ast]
    : '(' e1=expression ')'                                         // 1  - Parenthesis
        { $ast = $e1.ast; }
    | e1=expression '[' e2=expression ']'                           // 2  - Indexing
        { $ast = new Indexing($e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression '.' ID                                          // 3  - Record accessor
        { $ast = new RecordAccesor($e1.ast, $ID.text, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | '(' t1=builtin_type ')' e1=expression                         // 4  - Cast
        { $ast = new Cast($t1.ast, $e1.ast, $t1.ast.getColumn(), $t1.ast.getLine()); }
    | '-' e1=expression                                             // 5  - Unary minus
        { $ast = new UnaryMinus($e1.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | '!' e1=expression                                             // 6  - Negation
        { $ast = new Negation($e1.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression op=( '*' | '/' | '%' ) e2=expression            // 7  - Multiplication division and modulus
        { $ast = new ArithmeticOperation($op.text,  $e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression op=( '+' | '-' ) e2=expression                  // 8  - Addition and sbustraction
        { $ast = new ArithmeticOperation($op.text,  $e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression op=('<' | '>' | '>=' | '<=' | '==' | '!=') e2=expression  // 9  - Comparison
        { $ast = new ComparisonOperation($op.text,  $e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression op=('&&' | '||') e2=expression                  // 10 - Logic operations
        { $ast = new LogicalOperation($op.text,  $e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | ID '(' a=arguments ')'                                        // 11 - Function
        { $ast = new FunctionInvocation($ID.text, $a.args, $ID.getCharPositionInLine()+1, $ID.getLine()); }
    | ID                                                            // 12 - ID
        { $ast = new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine());}
    | il=INT_CONSTANT                                               // 13 - Constants
        { $ast = new IntLiteral(LexerHelper.lexemeToInt($il.text), $il.getCharPositionInLine()+1, $il.getLine());}
    | cl=CHAR_CONSTANT                                              // 14
        { $ast = new CharLiteral(LexerHelper.lexemeToChar($cl.text), $cl.getCharPositionInLine()+1, $cl.getLine());}
    | dl=REAL_CONSTANT                                              // 15
        { $ast = new DoubleLiteral(LexerHelper.lexemeToReal($dl.text), $dl.getCharPositionInLine()+1, $dl.getLine());}
    ;

arguments returns [List<Expression> args]
    : e1=expression {$args = new ArrayList<Expression>(); $args.add($e1.ast);} (',' e2=expression { $args.add($e2.ast);})*
    | { $args = new ArrayList<Expression>(); }
    ;

definition returns [Definition ast]
    : rt=return_type ID '(' tp=typed_params ')' '{' fb=function_body'}'
        {$ast = new FunctionDefinition(
            $ID.text,
            new FunctionType($rt.ast, $fb.body, $rt.ast.getColumn(), $rt.ast.getLine()),
            $fb.body
            $rt.ast.getColumn(), $rt.ast.getLine()
        );}
    | vd=variable_def
      { $ast = $vd.ast; }
    ;

function_body returns [List<Statement> body]
    : {$body = new ArrayList<Statement>(); }(vd=variable_def {$body.add($vd.ast);})* (s=statement { $body.add($s.ast);})*
    ;

typed_params returns [List<VariableDefinition> args]
    : tp1=typed_param { $args = new ArrayList<VariableDefinition>(); $args.add($tp1.ast);} (',' tp2=typed_param {$args.add($tp2.ast);})*
    | { $args = new ArrayList<VariableDefinition>(); }
    ;

typed_param returns [VariableDefinition ast]
    : t=type ID
        { $ast = new VariableDefinition($t.ast, $ID.text, $t.ast.getColumn(), $t.ast.getLine()); }
    ;

variable_def returns [Definition ast]
    : type ID (',' ID)* ';'
    ;

statement returns [Statement ast]
    : 'read' el=expression_list ';'                             // 1 - Read
        { $ast = new ReadStatement($el.args, $el.args.get(0).getColumn(), $el.args.get(0).getLine()); }
    | 'write' el=expression_list ';'                            // 2 - Write
        { $ast = new WriteStatement($el.args, $el.args.get(0).getColumn(), $el.args.get(0).getLine()); }
    | 'while' '(' e1=expression ')' cb=code_block               // 3 - While
        { $ast = new WhileStatement($e1.ast, $cb.args, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'if' '(' e1=expression ')' cb=code_block                  // 4 - If
        { $ast = new IfStatement($e1.ast, $cb.args, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'if' '(' e1=expression ')' cb1=code_block 'else' cb2=code_block      // 5 - If Else
        { $ast = new IfStatement($e1.ast, $cb1.args, $cb2.args, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression '=' e2=expression ';'                       // 6 - Assignment
        { $ast = new AssignmentStatement($e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'return' e1=expression ';'                                // 7 - Return
        { $ast = new ReturnStatement($e1.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | ID '(' el=expression_list ')' ';'                         // 8 - Function Invocation
        { $ast = new FunctionInvocation($ID.text, $el.args, $ID.getCharPositionInLine()+1, $ID.getLine());}
    | ID ('()' | '(' ')') ';'                                   // 9 - Procedure invocation
        { $ast = new ProcedureInvocation($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()); }
    ;

expression_list returns [List<Expression> args]
    : { $args = new ArrayList(); }
        e1=expression { $args.add($e1.ast); } (',' e2=expression { $args.add( $e2.ast); })*
    ;

code_block returns [List<Statement> args]
    : { $args = new ArrayList<Statement>(); } e1=statement {$args.add($e1.ast); }
    | { $args = new ArrayList<Statement>(); }'{' (e1=statement { $args.add($e1.ast); })* '}'
    ;


type returns [Type ast]
    : rt=return_type                    // 1 - return types
        { $ast = $rt.ast; }
    | t=type '[' il=INT_CONSTANT ']'    // 2 - array type
        { $ast = new ArrayType($t.ast, LexerHelper.lexemeToInt($il.text), $t.ast.getColumn(), $t.ast.getLine());}
    | 'struct' '{' rf=record_fields '}' // 3 - struct type
        { $ast = new StructType($rf.args, $rf.args.get(0).getColumn(), $rf.args.get(0).getLine()); }
    ;

record_fields returns [List<RecordField> args]
    : { $args = new ArrayList<RecordField>(); }
    (t=type ID ';' { $args.add(new RecordField($t.ast, $ID.text, $t.ast.getColumn(), $t.ast.getLine())); })+
    ;

return_type returns [Type ast]
    : t='void'         // 1 - void type
        { $ast = new VoidType($t.getCharPositionInLine()+1, $t.getLine()); }
    | bt=builtin_type  // 2 - builtin types
        { $ast = $bt.ast; }
    ;

builtin_type returns [Type ast]
    : t='int'     // 1 - int type
        { $ast = new IntType($t.getCharPositionInLine()+1, $t.getLine()); }
    | t='char'    // 2 - char type
        { $ast = new CharType($t.getCharPositionInLine()+1, $t.getLine()); }
    | t='double'  // 3 - double type
        { $ast = new DoubleType($t.getCharPositionInLine()+1, $t.getLine()); }
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
