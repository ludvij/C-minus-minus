package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class RecordAccesor extends AbstractExpression {

    private Expression expression;
    private String record;


    public RecordAccesor(Expression expression, String record, int column, int line) {
        super(column, line);
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
