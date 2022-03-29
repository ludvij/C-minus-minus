package ast.definitions;

import ast.Statement;
import ast.Type;
import visitor.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {


    public VariableDefinition(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + ";";
    }
}
