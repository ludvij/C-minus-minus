package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.expressions.Variable;

public class VariableDefinition extends AbstractDefinition implements Statement {


    public VariableDefinition(Variable name, Type type, int column, int line) {
        super(name, type, column, line);
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + ";";
    }
}
