package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class RecordAccesor extends AbstractASTNode implements Expression {

    private Expression struct;
    private String record;

    public RecordAccesor(Expression struct, String record, int column, int line) {
        super(column, line);
        this.struct = struct;
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

    public Expression getStruct() {
        return struct;
    }
}
