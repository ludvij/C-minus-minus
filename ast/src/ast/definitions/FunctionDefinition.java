package ast.definitions;

import ast.AbstractASTNode;
import ast.Statement;
import ast.Type;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private List<Statement> body;
    private Type returnType;

    public FunctionDefinition(String name, Type returnType, List<Statement> body, int column, int line) {
        super(name, column, line);
        this.returnType = returnType;
        this.body = body;
    }

    public List<Statement> getBody() {
        return body;
    }
    public Type getReturnType() {
        return returnType;
    }
}
