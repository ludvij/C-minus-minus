package ast.program.definitions;

import ast.AbstractASTNode;
import ast.Type;
import ast.program.Definition;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private final String name;
    private final Type type;

    public AbstractDefinition(String name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
