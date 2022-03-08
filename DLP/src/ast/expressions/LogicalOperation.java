package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class LogicalOperation extends AbstractASTNode implements Expression {

    private Expression expressionLeft;
    private Expression expressionRight;
    private String operator;

    public LogicalOperation(String operator, Expression expressionLeft, Expression expressionRight, int column, int line) {
        super(column, line);
        this.operator = operator;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getExpressionRight() {
        return expressionRight;
    }

    public Expression getExpressionLeft() {
        return expressionLeft;
    }

    @Override
    public String toString() {
        return expressionLeft + " " + operator + " " + expressionRight;
    }
}
