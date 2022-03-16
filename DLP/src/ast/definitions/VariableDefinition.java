package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.expressions.Variable;
import semantic.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {


    public VariableDefinition(Variable name, Type type, int column, int line) {
        super(name, type, column, line);
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
