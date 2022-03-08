package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.util.List;
import java.util.stream.Collectors;

public class StructType extends AbstractASTNode implements Type {

    private List<RecordField> recordFields;

    public StructType(List<RecordField> recordFields, int column, int line) {
        super(column, line);
        checkDuplicates(recordFields);
        this.recordFields = recordFields;
    }

    public void checkDuplicates(List<RecordField> fields) {
        if (fields.stream().map(x -> x.getName().getName()).collect(Collectors.toSet()).size() != fields.size()) {
            new ErrorType("Duplicate record name in struct", getColumn(), getLine());
        }
    }

    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("struct {\n");
        for (RecordField r : recordFields) {
            res.append(r).append("\n");
        }
        return res.append("}").toString();
    }

}
