package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class RecordField extends AbstractASTNode {

    private String name;
    private Type type;

    public RecordField(String name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return type + " " + name + ";";
    }
}
