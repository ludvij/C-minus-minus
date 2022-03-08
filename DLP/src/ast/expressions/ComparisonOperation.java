package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class ComparisonOperation extends AbstractASTNode implements Expression {

    private String operator;
    private Expression expressionLeft;
    private Expression expressionRight;

    public ComparisonOperation(String operator, Expression expressionLeft, Expression expressionRight, int column, int line) {
        super(column, line);
        this.operator = operator;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getExpressionLeft() {
        return expressionLeft;
    }

    public Expression getExpressionRight() {
        return expressionRight;
    }

    @Override
    public String toString() {
        return expressionLeft + " " + operator + " " + expressionRight;
    }

}
