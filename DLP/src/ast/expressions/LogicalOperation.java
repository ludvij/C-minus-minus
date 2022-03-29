package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class LogicalOperation extends AbstractExpression {

    private final Expression expressionLeft;
    private final Expression expressionRight;
    private final String operator;


    public LogicalOperation(String operator, Expression expressionLeft, Expression expressionRight, int line, int column) {
        super(line, column);
        this.operator = operator;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
