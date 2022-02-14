package ast.program.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;
import ast.expressions.Variable;

public class VariableDefinition extends AbstractDefinition {

    private String name;
    private Type type;

    public VariableDefinition(String name, Type type, int column, int line) {
        super(name, type, column, line);
    }

}
