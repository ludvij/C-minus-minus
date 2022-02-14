package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.time.temporal.ValueRange;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Function extends AbstractASTNode implements Type {

    private final String name;
    private final Type type;
    private final List<VariableDefinition> parameters;

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
