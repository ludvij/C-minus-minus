package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class UnaryMinus extends AbstractASTNode implements Expression {

    private Expression expression;

    public UnaryMinus(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "-" + expression;
    }
}
