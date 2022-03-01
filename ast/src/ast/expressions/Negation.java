package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class Negation extends AbstractASTNode implements Expression {

    private Expression expression;

    public Negation(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
