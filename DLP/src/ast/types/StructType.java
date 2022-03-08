package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractASTNode implements Type {

    private List<RecordField> recordFields;

    public StructType(List<RecordField> recordFields, int column, int line) {
        super(column, line);
        this.recordFields = recordFields;
    }

    public List<RecordField> getRecordFields() { return new ArrayList<>(recordFields); }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("struct {\n");
        for (RecordField r : recordFields) {
            res.append("    ").append(r).append("\n");
        }
        return res.append("}").toString();
    }

}
