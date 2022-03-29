package ast.types;

import visitor.Visitor;

import java.util.List;
import java.util.stream.Collectors;

public class StructType extends AbstractType {

    private final List<RecordField> recordFields;

    public StructType(List<RecordField> recordFields, int line, int column) {
        super(line, column);
        checkDuplicates(recordFields);
        this.recordFields = recordFields;
    }

    public void checkDuplicates(List<RecordField> fields) {
        if (fields.stream().map(x -> x.getName()).collect(Collectors.toSet()).size() != fields.size()) {
            new ErrorType("Duplicate record name in struct", getColumn(), getLine());
        }
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
