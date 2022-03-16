package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class WhileStatement extends AbstractASTNode implements Statement {

    private Expression expression;
    private List<Statement> body;

    public WhileStatement(Expression innerExpression, List<Statement> body, int column, int line) {
        super(column, line);
        this.expression = innerExpression;
        this.body = body;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Expression getExpression() {
         return expression;
    }
    
    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("while (" + expression + ") {\n");

        for (Statement s : body) {
            res.append(s).append("\n");
        }
        return res.append("}").toString();
    }

}
