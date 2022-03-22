package visitor.semantic;

import visitor.AbstractVisitor;

import ast.Expression;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(ArithmeticOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ComparisonOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation e, Void param) {
        e.getName().accept(this, null);
        for (Expression expr : e.getParameters()) {
            expr.accept(this, null);
        }
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(LogicalOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RecordAccesor e, Void param) {
        e.getExpression().accept(this, null);
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(CharLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus e, Void param) {
        e.getExpression().accept(this, null);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral e, Void param) {
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Negation e, Void param) {
        e.getExpression().accept(this, null);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {
        e.getCastType().accept(this, null);
        e.getExpression().accept(this, null);
        e.setLvalue(false);
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
    public Void visit(ReadStatement e, Void param) {
        e.getExpression().accept(this, null);
        if (!e.getExpression().getLvalue()) {
            new ErrorType("expression in read must have an l-value", e.getColumn(), e.getLine());
        }
        return null;
    }
}
