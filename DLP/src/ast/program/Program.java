package ast.program;

import ast.AbstractASTNode;
import ast.Definition;
import ast.definitions.FunctionDefinition;

import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> definitions;
    private FunctionDefinition main;

    public Program(List<Definition> definitions, FunctionDefinition main, int column, int line) {
        super(column, line);
        this.definitions = definitions;
        this.main = main;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public FunctionDefinition getMain() {
        return main;
    }
}
