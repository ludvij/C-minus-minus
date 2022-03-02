package ast.definitions;

import ast.Statement;
import ast.Type;

public class VariableDefinition extends AbstractDefinition implements Statement {


    public VariableDefinition(String name, Type type, int column, int line) {
        super(name, type, column, line);
    }
}
