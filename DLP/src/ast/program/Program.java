package ast.program;

import ast.AbstractASTNode;
import ast.Definition;

import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> definitions;

    public Program(List<Definition> definitions, int column, int line) {
        super(column, line);
        this.definitions = definitions;
    }
}
