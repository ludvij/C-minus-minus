package ast.types;

import ast.Type;
import visitor.Visitor;

import java.util.Objects;

public class RecordField extends AbstractType {

    private final String name;
    private final Type type;
    private int offset;

    public RecordField(String name, Type type, int line, int column) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getName() { return name; }
    public Type getType() { return type; }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }

    @Override
    public int numberOfBytes() {
        return type.numberOfBytes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordField that = (RecordField) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
