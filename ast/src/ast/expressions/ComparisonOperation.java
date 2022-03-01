package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class ComparisonOperation extends AbstractASTNode implements Expression {

    private String operator;
    private Expression expressionLeft;
    private Expression expressionRight;

    public ComparisonOperation(int column, int line, String operator, Expression expressionLeft, Expression expressionRight) {
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

}
