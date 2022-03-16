package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.VariableDefinition;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    private Type type;
    private List<VariableDefinition> parameters;

    public FunctionType(Type type, List<VariableDefinition> parameters, int column, int line) {
        super(column, line);
        this.type = type;
        this.parameters = parameters;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Type getType() { return type; }
    public List<VariableDefinition> getParameters() { return parameters; }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(type + " %s(");
        for (VariableDefinition p : parameters) {
            res.append(p).setLength(res.length()-1);
            res.append(", ");
        }
        if (!parameters.isEmpty())
            res.setLength(res.length()-2);
        return res.append(")").toString();
    }
}
