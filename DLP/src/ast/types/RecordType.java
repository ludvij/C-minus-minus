package ast.types;

import ast.Type;
import visitor.Visitor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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

}
