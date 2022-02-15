package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class While extends AbstractASTNode implements Statement {

    private final Expression innerExpression;
    private final List<Statement> body;

    public While(Expression innerExpression, List<Statement> body, int column, int line) {
        super(column, line);
        this.innerExpression = innerExpression;
        this.body = body;
    }

    public Expression getInnerExpression() {
         return innerExpression; 
    }
    
    public List<Statement> getBody() {
        return body;
    }

}
