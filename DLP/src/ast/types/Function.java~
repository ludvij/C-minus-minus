package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.VariableDefinition;

import java.util.List;

public class Function extends AbstractASTNode implements Type {

    private String name;
    private Type type;
    private List<VariableDefinition> parameters;

    public Function(String name, Type type, List<VariableDefinition> parameters, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
        this.parameters = parameters;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public List<VariableDefinition> getParameters() { return parameters; }
}
