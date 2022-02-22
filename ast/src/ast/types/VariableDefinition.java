package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class VariableDefinition extends AbstractASTNode {

    private final String name;
    private final Type type;

    public VariableDefinition(String name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
}
