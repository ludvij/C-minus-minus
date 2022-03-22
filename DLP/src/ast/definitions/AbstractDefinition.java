package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;
import ast.expressions.Variable;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private String name;
    private Type type;
    private int scope;

    public AbstractDefinition(String name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
