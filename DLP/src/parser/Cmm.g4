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
program returns [Program ast]
    : d=definition mf=main
        { $ast = new Program($d.ast, $mf.ast, 0, 0); }
    ;

definition returns [List<Definition> ast]
    : { $ast = new ArrayList<Definition>(); } (fd=function_definition { $ast.add($fd.ast); })*
    | { $ast = new ArrayList<Definition>(); } (vd=variable_definition { $ast.addAll($vd.ast); })*
    ;


// Some weird shenanigans here, if I write '(' ')' in the production
// then void main() {} it is not valid
// But if I write '()' then void main( ) is not valid
// I don't understand
// So I did this fix to be able to have the two of them
// in procedure is the same
main returns [FunctionDefinition ast]
    : vt=void_type 'main' ('(' ')' | '()' ) '{' fb=function_body '}'
        { $ast = new FunctionDefinition(
            "main",
            new FunctionType($vt.ast, new ArrayList<VariableDefinition>(), $vt.ast.getColumn(), $vt.ast.getLine()),
            $fb.ast,
            $vt.ast.getColumn(),
            $vt.ast.getLine()
        ); }
    ;


function_definition returns [Definition ast]
    : rt=return_type ID '(' tp=parameters ')' '{' fb=function_body'}'
         { $ast = new FunctionDefinition(
             $ID.text,
             new FunctionType($rt.ast, $tp.ast, $rt.ast.getColumn(), $rt.ast.getLine()),
             $fb.ast,
             $rt.ast.getColumn(), $rt.ast.getLine()
         ); }
    ;

function_body returns [List<Statement> ast]
    : { $ast = new ArrayList<Statement>(); }
        (vd=variable_definition { $ast.addAll($vd.ast); })*
        (s=statement { $ast.add($s.ast); })*
    ;

variable_definition returns [List<VariableDefinition> ast]
    : { $ast = new ArrayList<VariableDefinition>(); }
        t=type i1=ID { $ast.add(new VariableDefinition($i1.text, $t.ast, $t.ast.getColumn(), $t.ast.getLine())); }
        (',' i2=ID { $ast.add( new VariableDefinition($i2.text, $t.ast, $t.ast.getColumn(), $t.ast.getLine())); })* ';'
    ;

parameters returns [List<VariableDefinition> ast]
    : tp1=typed_param { $ast = new ArrayList<VariableDefinition>(); $ast.add($tp1.ast);} (',' tp2=typed_param {$ast.add($tp2.ast); })*
    | { $ast = new ArrayList<VariableDefinition>(); }
    ;

typed_param returns [VariableDefinition ast]
    : t=type ID
        { $ast = new VariableDefinition($ID.text, $t.ast, $t.ast.getColumn(), $t.ast.getLine()); }
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
        { $ast = new FunctionInvocation($ID.text, $a.ast, $ID.getCharPositionInLine()+1, $ID.getLine()); }
    | ID                                                            // 12 - ID
        { $ast = new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine());}
    | il=INT_CONSTANT                                               // 13 - Constants
        { $ast = new IntLiteral(LexerHelper.lexemeToInt($il.text), $il.getCharPositionInLine()+1, $il.getLine());}
    | cl=CHAR_CONSTANT                                              // 14
        { $ast = new CharLiteral(LexerHelper.lexemeToChar($cl.text), $cl.getCharPositionInLine()+1, $cl.getLine());}
    | dl=REAL_CONSTANT                                              // 15
        { $ast = new DoubleLiteral(LexerHelper.lexemeToReal($dl.text), $dl.getCharPositionInLine()+1, $dl.getLine());}
    ;

arguments returns [List<Expression> ast]
    : e1=expression {$ast = new ArrayList<Expression>(); $ast.add($e1.ast);} (',' e2=expression { $ast.add($e2.ast);})*
    | { $ast = new ArrayList<Expression>(); }
    ;

statement returns [Statement ast]
    : 'read' el=expression_list ';'                             // 1 - Read
        { $ast = new ReadStatement($el.ast, $el.ast.get(0).getColumn(), $el.ast.get(0).getLine()); }
    | 'write' el=expression_list ';'                            // 2 - Write
        { $ast = new WriteStatement($el.ast, $el.ast.get(0).getColumn(), $el.ast.get(0).getLine()); }
    | 'while' '(' e1=expression ')' cb=code_block               // 3 - While
        { $ast = new WhileStatement($e1.ast, $cb.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'if' '(' e1=expression ')' cb=code_block                  // 4 - If
        { $ast = new IfStatement($e1.ast, $cb.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'if' '(' e1=expression ')' cb1=code_block 'else' cb2=code_block      // 5 - If Else
        { $ast = new IfStatement($e1.ast, $cb1.ast, $cb2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | e1=expression '=' e2=expression ';'                       // 6 - Assignment
        { $ast = new AssignmentStatement($e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | 'return' e1=expression ';'                                // 7 - Return
        { $ast = new ReturnStatement($e1.ast, $e1.ast.getColumn(), $e1.ast.getLine()); }
    | ID '(' el=expression_list ')' ';'                         // 8 - Function Invocation
        { $ast = new FunctionInvocation($ID.text, $el.ast, $ID.getCharPositionInLine()+1, $ID.getLine());}
    | ID ('()' | '(' ')') ';'                                   // 9 - Procedure invocation
        { $ast = new ProcedureInvocation($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()); }
    ;

expression_list returns [List<Expression> ast]
    : { $ast = new ArrayList(); }
        e1=expression { $ast.add($e1.ast); } (',' e2=expression { $ast.add( $e2.ast); })*
    ;

code_block returns [List<Statement> ast]
    : { $ast = new ArrayList<Statement>(); } e1=statement {$ast.add($e1.ast); }
    | { $ast = new ArrayList<Statement>(); }'{' (e1=statement { $ast.add($e1.ast); })* '}'
    ;


type returns [Type ast]
    : rt=return_type                    // 1 - return types
        { $ast = $rt.ast; }
    | t=type '[' il=INT_CONSTANT ']'    // 2 - array type
        { $ast = new ArrayType($t.ast, LexerHelper.lexemeToInt($il.text), $t.ast.getColumn(), $t.ast.getLine());}
    | 'struct' '{' rf=record_fields '}' // 3 - struct type
        { $ast = new StructType($rf.ast, $rf.ast.get(0).getColumn(), $rf.ast.get(0).getLine()); }
    ;

record_fields returns [List<RecordField> ast]
    : { $ast = new ArrayList<RecordField>(); }
    (t=type ID ';' { $ast.add(new RecordField($t.ast, $ID.text, $t.ast.getColumn(), $t.ast.getLine())); })+
    ;

return_type returns [Type ast]
    : t=void_type         // 1 - void type
        { $ast = $t.ast; }
    | bt=builtin_type     // 2 - builtin types
        { $ast = $bt.ast; }
    ;

void_type returns [Type ast]
    : t='void'
        { $ast = new VoidType($t.getCharPositionInLine()+1, $t.getLine()); }
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
