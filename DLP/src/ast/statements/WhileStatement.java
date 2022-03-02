package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class WhileStatement extends AbstractASTNode implements Statement {

    private Expression expression;
    private List<Statement> body;

    public WhileStatement(Expression innerExpression, List<Statement> body, int column, int line) {
        super(column, line);
        this.expression = innerExpression;
        this.body = body;
    }

    public Expression getExpression() {
         return expression;
    }
    
    public List<Statement> getBody() {
        return body;
    }

}
