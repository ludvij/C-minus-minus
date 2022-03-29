package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class WriteStatement extends AbstractASTNode implements Statement {

    private final Expression expression;

    public WriteStatement(Expression expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "write " + expression + ";";
    }
}
