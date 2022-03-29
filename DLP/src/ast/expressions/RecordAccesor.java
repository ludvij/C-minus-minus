package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class RecordAccesor extends AbstractExpression {

    private final Expression expression;
    private final String record;


    public RecordAccesor(Expression expression, String record, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.record = record;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getRecord() {
        return record;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression + "." + record;
    }
}
