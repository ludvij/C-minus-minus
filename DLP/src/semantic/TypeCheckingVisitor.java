package semantic;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.program.Program;
import ast.statements.*;
import ast.types.*;

public class TypeCheckingVisitor implements Visitor<Void, Void>{
    @Override
    public Void visit(FunctionDefinition e, Void param) {
        return null;
    }

    @Override
    public Void visit(VariableDefinition e, Void param) {
        return null;
    }

    @Override
    public Void visit(ArithmeticOperation e, Void param) {
        return null;
    }

    @Override
    public Void visit(ComparisonOperation e, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionInvocation e, Void param) {
        return null;
    }

    @Override
    public Void visit(LogicalOperation e, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleLiteral e, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordAccesor e, Void param) {
        return null;
    }

    @Override
    public Void visit(CharLiteral e, Void param) {
        return null;
    }

    @Override
    public Void visit(UnaryMinus e, Void param) {
        return null;
    }

    @Override
    public Void visit(IntLiteral e, Void param) {
        return null;
    }

    @Override
    public Void visit(Indexing e, Void param) {
        return null;
    }

    @Override
    public Void visit(Negation e, Void param) {
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {
        return null;
    }

    @Override
    public Void visit(Program e, Void param) {
        return null;
    }

    @Override
    public Void visit(AssignmentStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(ReturnStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(WhileStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(WriteStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(ReadStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(IfStatement e, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionType e, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordField e, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType e, Void param) {
        return null;
    }

    @Override
    public Void visit(StructType e, Void param) {
        return null;
    }

    @Override
    public Void visit(ArrayType e, Void param) {
        return null;
    }

    @Override
    public Void visit(CharType e, Void param) {
        return null;
    }

    @Override
    public Void visit(VoidType e, Void param) {
        return null;
    }

    @Override
    public Void visit(IntType e, Void param) {
        return null;
    }
}
