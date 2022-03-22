package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.expressions.Variable;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private List<Statement> body;

    public FunctionDefinition(String name, Type type, List<Statement> body, int column, int line) {
        super(name, type, column, line);
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
        StringBuilder res = new StringBuilder(String.format(getType().toString(), getName()) + "{\n");
        for (Statement s : body) {
            res.append(s).append("\n");
        }
        return  res.append("}").toString();
    }
}
