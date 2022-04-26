package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class RecordAccesor extends AbstractExpression {

    private final Expression expression;
    private final String id;


    public RecordAccesor(Expression expression, String id, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.id = id;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getId() {
        return id;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression + "." + id;
    }
}
