package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class ArithmeticOperation extends AbstractASTNode implements Expression {

    private final String operator;
    private final Expression expressionLeft;
    private final Expression expressionRight;

    public ArithmeticOperation(String operator, Expression expressionLeft, Expression expressionRight, int column, int line) {
        super(column, line);
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
        this.operator = operator;
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
