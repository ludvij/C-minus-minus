package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class ReturnStatement extends AbstractASTNode implements Statement {

    private Expression expression;

    public ReturnStatement(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() { return expression; }
}
