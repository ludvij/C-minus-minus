package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class LogicalOperation extends AbstractASTNode implements Expression {

    private Expression expressionLeft;
    private Expression expressionRight;

    public LogicalOperation(Expression expressionLeft, Expression expressionRight, int column, int line) {
        super(column, line);
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    public Expression getExpressionRight() {
        return expressionRight;
    }

    public Expression getExpressionLeft() {
        return expressionLeft;
    }
}
