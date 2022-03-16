package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import semantic.Visitor;

public class RecordAccesor extends AbstractExpression {

    private Expression struct;
    private String record;


    public RecordAccesor(Expression struct, String record, int column, int line) {
        super(column, line);
        this.struct = struct;
        this.record = record;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getRecord() {
        return record;
    }

    public Expression getStruct() {
        return struct;
    }

    @Override
    public String toString() {
        return struct + "." + record;
    }
}
