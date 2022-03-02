package ast.definitions;

import ast.AbstractASTNode;
import ast.Statement;
import ast.Type;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private List<Statement> body;

    public FunctionDefinition(String name, Type type, List<Statement> body, int column, int line) {
        super(name, type, column, line);
        this.body = body;
    }

    public List<Statement> getBody() {
        return body;
    }
}
