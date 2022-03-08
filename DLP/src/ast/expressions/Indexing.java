package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class Indexing extends AbstractASTNode implements Expression {

    private Expression expression;
    private Expression index;

    public Indexing(Expression expression, Expression index, int column, int line) {
        super(column, line);
        this.expression = expression;
        this.index = index;
    }

    public Expression getExpression() {
        return expression;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return expression + "[" + index + "]";
    }
}
