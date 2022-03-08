package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;
import ast.expressions.Variable;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private Variable name;
    private Type type;

    public AbstractDefinition(Variable name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    @Override
    public Variable getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }
}
