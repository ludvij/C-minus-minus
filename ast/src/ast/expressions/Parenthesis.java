package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

class Parenthesis extends AbstractASTNode implements Expression {

    private Expression expression;

    public Parenthesis(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
