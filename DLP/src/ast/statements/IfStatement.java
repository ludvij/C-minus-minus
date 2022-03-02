package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class IfStatement extends AbstractASTNode implements Statement {

    private Expression expression;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfStatement(Expression expression, List<Statement> ifBody, int column, int line)
    {
        super(column, line);
        this.expression = expression;
        this.ifBody = ifBody;
    }

    public IfStatement(Expression expression, List<Statement> ifBody, List<Statement> elseBody, int column, int line) {
        this(expression, ifBody, column, line);
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
