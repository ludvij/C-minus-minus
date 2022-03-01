package ast.definitions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public class VariableDefinition extends AbstractDefinition implements Expression {

    private Type type;

    public VariableDefinition(String name, Type type, int column, int line) {
        super(name, column, line);
        this.type = type;
    }

    public Type getType() { return type; }
}
