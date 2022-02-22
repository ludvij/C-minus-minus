package ast.program.definitions;

import ast.Type;

public class FunctionDefinition extends AbstractDefinition {

    public FunctionDefinition(String name, Type type, int column, int line) {
        super(name, type, column, line);
    }
}
