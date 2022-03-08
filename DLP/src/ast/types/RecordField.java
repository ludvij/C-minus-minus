package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.expressions.Variable;

public class RecordField extends AbstractASTNode {

    private Variable name;
    private Type type;

    public RecordField(Variable name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    public Variable getName() { return name; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return type + " " + name + ";";
    }
}
