package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class Indexing extends AbstractASTNode implements Expression {

    private Expression expression;

    public Indexing(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
