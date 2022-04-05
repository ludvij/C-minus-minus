package ast.types;

import ast.Type;
import ast.definitions.VariableDefinition;
import visitor.Visitor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FunctionType extends AbstractType {

    private final Type type;
    private final List<VariableDefinition> parameters;

    public FunctionType(Type type, List<VariableDefinition> parameters, int line, int column) {
        super(line, column);
        this.type = type;
        this.parameters = parameters;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> params, int line, int column) {
        if (parameters.size() != params.size()) {
            return new ErrorType("Expected " + parameters.size() + " arguments, Given: " + params.size(), line, column);
        }
        if (params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) != parameters.get(i).getType()){
                    return new ErrorType(parameters.get(i).getType() +" type expected, found: " + params.get(i), line, column);
                }
            }
        }
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionType that = (FunctionType) o;
        return Objects.equals(type, that.type) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, parameters);
    }

    public Type getType() { return type; }
    public List<VariableDefinition> getParameters() { return parameters; }

    @Override
    public String toString() {
        return type + " ("+parameters.stream().map(VariableDefinition::toString).collect(Collectors.joining(", "))+")";
    }
}
