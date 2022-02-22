package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class If extends AbstractASTNode implements Statement {

    private final List<Statement> ifBody;
    private final List<Statement> elseBody;
    private final Expression expression;

    public If(Expression expression, List<Statement> ifBody, List<Statement> elseBody, int column, int line) {
        super(column, line);

        this.expression = expression;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }
}
