package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class IfStatement extends AbstractASTNode implements Statement {

    private final Expression expression;
    private final List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfStatement(Expression expression, List<Statement> ifBody, int line, int column)
    {
        super(line, column);
        this.expression = expression;
        this.ifBody = ifBody;
    }

    public IfStatement(Expression expression, List<Statement> ifBody, List<Statement> elseBody, int line, int column) {
        this(expression, ifBody, line, column);
        this.elseBody = elseBody;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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

    @Override
    public String toString() {
        StringBuilder ifStr = new StringBuilder("if(" + expression + ") {\n");
        for (Statement s : ifBody) {
            ifStr.append(s).append("\n");
        }
        if (!elseBody.isEmpty()) {
            ifStr.append("} else {\n");
            for (Statement s : elseBody) {
                ifStr.append(s).append("\n");
            }
        }
        ifStr.append("}");
        return  ifStr.toString();
    }
}
