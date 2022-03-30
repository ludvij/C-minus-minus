package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.types.FunctionType;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private final List<Statement> body;

    public FunctionDefinition(String name, FunctionType type, List<Statement> body, int line, int column) {
        super(name, type, line, column);
        this.body = body;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getType() + " " + getName();
    }

    @Override
    public FunctionType getType() {
        return (FunctionType) super.getType();
    }
}
