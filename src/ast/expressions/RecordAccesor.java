package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class RecordAccesor extends AbstractASTNode implements Expression {

    private final Expression struct;
    private final Expression record;

    public RecordAccesor(Expression struct, Expression record, int column, int line) {
        super(column, line);
        this.struct = struct;
        this.record = record;
    }

    public Expression getRecord() {
        return record;
    }

    public Expression getStruct() {
        return struct;
    }
}
