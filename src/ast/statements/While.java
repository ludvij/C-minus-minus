package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class While extends AbstractASTNode implements Statement {

    private final Expression innerExpression;

    public While(Expression innerExpression, int column, int line) {
        super(column, line);
        this.innerExpression = innerExpression;
    }

    public Expression getInnerExpression() { return innerExpression; }

}
