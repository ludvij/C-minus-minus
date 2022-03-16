package ast.program;

import ast.AbstractASTNode;
import ast.Definition;
import visitor.Visitor;

import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> definitions;

    public Program(List<Definition> definitions, int column, int line) {
        super(column, line);
        this.definitions = definitions;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}
