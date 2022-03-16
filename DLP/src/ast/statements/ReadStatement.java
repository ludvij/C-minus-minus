package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import semantic.Visitor;

import java.util.List;

public class ReadStatement extends AbstractASTNode implements Statement {

    private Expression expression;

    public ReadStatement(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Expression getExpression() { return expression; }

    @Override
    public String toString() {
        return "read " + expression +";";
    }
}
