package ast.types;

import ast.Type;
import ast.expressions.Variable;
import visitor.Visitor;

public class RecordField extends AbstractType {

    private final Variable name;
    private final Type type;

    public RecordField(Variable name, Type type, int line, int column) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Variable getName() { return name; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return type + " " + name + ";";
    }
}
