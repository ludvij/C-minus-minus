package ast.program;

import ast.AbstractASTNode;
import ast.Definition;
import ast.definitions.FunctionDefinition;

import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> definitions;

    public Program(List<Definition> definitions, int column, int line) {
        super(column, line);
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}
