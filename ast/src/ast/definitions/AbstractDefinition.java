package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private String name;

    public AbstractDefinition(String name, int column, int line) {
        super(column, line);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
