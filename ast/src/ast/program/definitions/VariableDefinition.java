package ast.program.definitions;

import ast.Type;

public class VariableDefinition extends AbstractDefinition {

    public VariableDefinition(String name, Type type, int column, int line) {
        super(name, type, column, line);
    }
    

}
