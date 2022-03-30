package ast.types;

import ast.Type;
import ast.types.error.ErrorType;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecordType extends AbstractType {

    private final List<RecordField> recordFields;

    public RecordType(List<RecordField> recordFields, int line, int column) {
        super(line, column);
        this.recordFields = recordFields;
    }

    @Override
    public Type dot(String field, int line, int column) {
        Type res = recordFields.stream()
                .filter(x -> x.getName().equals(field))
                .map(RecordField::getType)
                .findAny()
                .orElse(null);
        if (res == null) {
            new ErrorType("Field " + field + " is not defined for struct", getLine(), getColumn());
        }
        return res;
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
        return "struct [" + recordFields.stream().map(RecordField::toString).collect(Collectors.joining(", ")) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordType that = (RecordType) o;
        return Objects.equals(recordFields, that.recordFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordFields);
    }
}
