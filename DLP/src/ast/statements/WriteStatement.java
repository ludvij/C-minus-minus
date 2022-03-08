package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class WriteStatement extends AbstractASTNode implements Statement {

    private Expression expression;

    public WriteStatement(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "write " + expression + ";";
    }
}
