package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class ArithmeticOperation extends AbstractExpression {

    private final String operator;
    private final Expression expressionLeft;
    private final Expression expressionRight;


    public ArithmeticOperation(String operator, Expression expressionLeft, Expression expressionRight, int line, int column) {
        super(line, column);
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
        this.operator = operator;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
