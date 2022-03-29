package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class Indexing extends AbstractExpression {

    private final Expression expressionLeft;
    private final Expression expressionRight;


    public Indexing(Expression expressionLeft, Expression expressionRight, int line, int column) {
        super(line, column);
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    public Expression getExpressionLeft() {
        return expressionLeft;
    }

    public Expression getExpressionRight() {
        return expressionRight;
    }

    @Override
    public String toString() {
        return expressionLeft + "[" + expressionRight + "]";
    }
}
