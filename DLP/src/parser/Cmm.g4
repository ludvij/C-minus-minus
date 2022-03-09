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
    : d=definitions mf=main
        {
            $d.ast.add($mf.ast);
            $ast = new Program($d.ast, 0, 0);
        }
    ;

definitions returns [List<Definition> ast = new ArrayList<>()]
    : ( fd=function_definition { $ast.add($fd.ast); }
      | vd=variable_definition { $ast.addAll($vd.ast); }
      )*
    ;

main returns [FunctionDefinition ast]
    : vt=void_type m='main' '(' ')' '{' fb=function_body '}'
        { $ast = new FunctionDefinition(
            new Variable($m.text, $m.getCharPositionInLine()+1, $m.getLine()),
            new FunctionType($vt.ast, new ArrayList<VariableDefinition>(), $vt.ast.getColumn(), $vt.ast.getLine()),
            $fb.ast,
            $vt.ast.getColumn(),
            $vt.ast.getLine()
        ); }
    ;

function_definition returns [Definition ast]
    : rt=return_type ID '(' tp=parameters ')' '{' fb=function_body '}'
         { $ast = new FunctionDefinition(
             new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()),
             new FunctionType($rt.ast, $tp.ast, $rt.ast.getColumn(), $rt.ast.getLine()),
             $fb.ast,
             $rt.ast.getColumn(), $rt.ast.getLine()
         ); }
    ;

function_body returns [List<Statement> ast = new ArrayList<>()]
    : (vd=variable_definition { $ast.addAll($vd.ast); })*
      (s=statement { $ast.addAll($s.ast); })*
    ;

variable_definition returns [List<VariableDefinition> ast = new ArrayList<>()]
    : t=type i1=ID
        { $ast.add(new VariableDefinition(
            new Variable($i1.text, $i1.getCharPositionInLine()+1, $i1.getLine()),
            $t.ast,
            $t.ast.getColumn(), $t.ast.getLine())); }
      (',' i2=ID
        { $ast.add(new VariableDefinition(
            new Variable($i2.text, $i2.getCharPositionInLine()+1, $i2.getLine()),
            $t.ast,
            $t.ast.getColumn(), $t.ast.getLine())); }
      )* ';'
    ;

parameters returns [List<VariableDefinition> ast = new ArrayList<>()]
    : tp1=typed_param {$ast.add($tp1.ast);} (',' tp2=typed_param {$ast.add($tp2.ast); })*
    |
    ;

typed_param returns [VariableDefinition ast]
    : t=type ID
        { $ast = new VariableDefinition(
            new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()),
            $t.ast, $t.ast.getColumn(),
            $t.ast.getLine());
        }
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
        { $ast = new FunctionInvocation(
            new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()),
            $a.ast,
            $ID.getCharPositionInLine()+1, $ID.getLine());
        }
    | ID                                                            // 12 - ID
        { $ast = new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine());}
    | il=INT_CONSTANT                                               // 13 - Constants
        { $ast = new IntLiteral(LexerHelper.lexemeToInt($il.text), $il.getCharPositionInLine()+1, $il.getLine());}
    | cl=CHAR_CONSTANT                                              // 14
        { $ast = new CharLiteral(LexerHelper.lexemeToChar($cl.text), $cl.getCharPositionInLine()+1, $cl.getLine());}
    | dl=REAL_CONSTANT                                              // 15
        { $ast = new DoubleLiteral(LexerHelper.lexemeToReal($dl.text), $dl.getCharPositionInLine()+1, $dl.getLine());}
    ;

arguments returns [List<Expression> ast = new ArrayList<Expression>()]
    : e1=expression { $ast.add($e1.ast);} (',' e2=expression { $ast.add($e2.ast);})*
    |
    ;

statement returns [List<Statement> ast = new ArrayList<>()]
    : r='read' el=expression_list ';'                             // 1 - Read
        {
            for (Expression i : $el.ast) {
                $ast.add(new ReadStatement(i, $r.getCharPositionInLine()+1, $r.getLine()));
            }
        }
    | w='write' el=expression_list ';'                            // 2 - Write
        {
            for (Expression i : $el.ast) {
                $ast.add(new WriteStatement(i, $w.getCharPositionInLine()+1, $w.getLine()));
            }
        }
    | 'while' '(' e1=expression ')' cb=code_block               // 3 - While
        { $ast.add(new WhileStatement($e1.ast, $cb.ast, $e1.ast.getColumn(), $e1.ast.getLine())); }
    | 'if' '(' e1=expression ')' cb=code_block                  // 4 - If
        { $ast.add(new IfStatement($e1.ast, $cb.ast, $e1.ast.getColumn(), $e1.ast.getLine())); }
    | 'if' '(' e1=expression ')' cb1=code_block 'else' cb2=code_block      // 5 - If Else
        { $ast.add(new IfStatement($e1.ast, $cb1.ast, $cb2.ast, $e1.ast.getColumn(), $e1.ast.getLine())); }
    | e1=expression '=' e2=expression ';'                       // 6 - Assignment
        { $ast.add(new AssignmentStatement($e1.ast, $e2.ast, $e1.ast.getColumn(), $e1.ast.getLine())); }
    | 'return' e1=expression ';'                                // 7 - Return
        { $ast.add(new ReturnStatement($e1.ast, $e1.ast.getColumn(), $e1.ast.getLine())); }
    | ID '(' el=expression_list ')' ';'                         // 8 - Function Invocation
        {
            $ast.add(new FunctionInvocation(
                new Variable($ID.text, $ID.getCharPositionInLine()+1, $ID.getLine()),
                $el.ast,
                $ID.getCharPositionInLine()+1, $ID.getLine())
            );
        }
    ;

expression_list returns [List<Expression> ast = new ArrayList<>()]
    :  e1=expression { $ast.add($e1.ast); } (',' e2=expression { $ast.add( $e2.ast); })*
    |
    ;

code_block returns [List<Statement> ast = new ArrayList<Statement>()]
    : e1=statement {$ast.addAll($e1.ast); }
    |'{' (e1=statement { $ast.addAll($e1.ast); })* '}'
    ;


type returns [Type ast]
    : rt=return_type                                    // 1 - return types
        { $ast = $rt.ast; }
    | t=type '[' il=INT_CONSTANT ']'                    // 2 - array type
        { $ast = ArrayType.Factory.create($t.ast, LexerHelper.lexemeToInt($il.text), $t.ast.getColumn(), $t.ast.getLine());}
    | s='struct' '{' rf=record_fields '}'                 // 3 - struct type
        { $ast = new StructType($rf.ast, $s.getCharPositionInLine()+1, $s.getLine()); }
    ;

record_fields returns [List<RecordField> ast = new ArrayList<RecordField>()]
    : (t=record_field { $ast.addAll($t.ast); })+
    ;

record_field returns [List<RecordField> ast = new ArrayList<RecordField>()]
    : t=type i1=ID
        { $ast.add(new RecordField(
            new Variable($i1.text, $i1.getCharPositionInLine()+1, $i1.getLine()),
            $t.ast,
            $t.ast.getColumn(), $t.ast.getLine()));
        }
      (',' i2=ID
        { $ast.add(new RecordField(
            new Variable($i2.text, $i2.getCharPositionInLine()+1, $i2.getLine()),
            $t.ast,
            $t.ast.getColumn(), $t.ast.getLine()));
        })* ';'
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
