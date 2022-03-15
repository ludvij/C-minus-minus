package semantic;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.program.Program;
import ast.statements.*;
import ast.types.*;
import introspector.test.ast.Read;

import java.util.ArrayList;

public interface Visitor<TP, TR> {

    TR visit(FunctionDefinition e, TP param);
    TR visit(VariableDefinition e, TP param);

    TR visit(ArithmeticOperation e, TP param);
    TR visit(ComparisonOperation e, TP param);
    TR visit(FunctionInvocation e, TP param);
    TR visit(LogicalOperation e, TP param);
    TR visit(DoubleLiteral e, TP param);
    TR visit(RecordAccesor e, TP param);
    TR visit(CharLiteral e, TP param);
    TR visit(UnaryMinus e, TP param);
    TR visit(IntLiteral e, TP param);
    TR visit(Indexing e, TP param);
    TR visit(Negation e, TP param);
    TR visit(Variable e, TP param);
    TR visit(Cast e, TP param);

    TR visit(Program e, TP param);

    TR visit(AssignmentStatement e, TP param);
    TR visit(ReturnStatement e, TP param);
    TR visit(WhileStatement e, TP param);
    TR visit(WriteStatement e, TP param);
    TR visit(ReadStatement e, TP param);
    TR visit(IfStatement e, TP param);

    TR visit(FunctionType e, TP param);
    TR visit(RecordField e, TP param);
    TR visit(DoubleType e, TP param);
    TR visit(StructType e, TP param);
    TR visit(ArrayType e, TP param);
    TR visit(CharType e, TP param);
    TR visit(VoidType e, TP param);
    TR visit(IntType e, TP param);
//    TR visit(ErrorType e, TP param);

}
