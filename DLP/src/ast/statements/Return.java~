package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Return extends AbstractASTNode implements Statement {

    private Expression expression;

    public Return(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() { return expression; }
}
