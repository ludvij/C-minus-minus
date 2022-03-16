package visitor.semantic;

import ast.Definition;
import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.program.Program;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class TypeCheckingVisitor implements Visitor<Void, Void> {

    @Override
    public Void visit(FunctionDefinition e, Void param) {
        e.getType().accept(this, null);
        e.getName().accept(this, null);

        for (Statement stmt : e.getBody()) {
            stmt.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(VariableDefinition e, Void param) {
        e.getType().accept(this, null);
        e.getName().accept(this, null);
        return null;
    }

    @Override
    public Void visit(ArithmeticOperation e, Void param) {
        e.setLvalue(false);
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        return null;
    }

    @Override
    public Void visit(ComparisonOperation e, Void param) {
        e.setLvalue(false);
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation e, Void param) {
        e.setLvalue(false);
        e.getName().accept(this, null);
        return null;
    }

    @Override
    public Void visit(LogicalOperation e, Void param) {
        e.setLvalue(false);
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RecordAccesor e, Void param) {
        e.setLvalue(true);
        e.getStruct().accept(this, null);
        return null;
    }

    @Override
    public Void visit(CharLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus e, Void param) {
        e.setLvalue(false);
        e.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(IntLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing e, Void param) {
        e.setLvalue(true);
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Negation e, Void param) {
        e.setLvalue(false);
        e.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {
        e.setLvalue(false);
        e.getCastType().accept(this, null);
        e.getExpression().accept(this, null);
        return null;
    }


    @Override
    public Void visit(Program e, Void param) {
        for (Definition def : e.getDefinitions()){
            def.accept(this, null);
        }

        return null;
    }

    @Override
    public Void visit(AssignmentStatement e, Void param) {
        e.getLeftExpression().accept(this, null);
        e.getRightExpression().accept(this, null);
        if (!e.getLeftExpression().getLvalue()) {
            new ErrorType("Left expression in assignment must have l-value", e.getColumn(), e.getLine());
        }
        return null;
    }

    @Override
    public Void visit(ReturnStatement e, Void param) {
        e.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(WhileStatement e, Void param) {
        e.getExpression().accept(this, null);
        for (Statement stmt : e.getBody()) {
            stmt.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(WriteStatement e, Void param) {
        e.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(ReadStatement e, Void param) {
        e.getExpression().accept(this, null);
        if (!e.getExpression().getLvalue()) {
            new ErrorType("expression in read must have an l-value", e.getColumn(), e.getLine());
        }
        return null;
    }

    @Override
    public Void visit(IfStatement e, Void param) {
        e.getExpression().accept(this, null);
        for (Statement stmt : e.getIfBody()) {
            stmt.accept(this, null);
        }
        for (Statement stmt : e.getElseBody()) {
            stmt.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(FunctionType e, Void param) {
        e.getType().accept(this, null);

        for (VariableDefinition def : e.getParameters()) {
            def.accept(this, null);
        }

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
