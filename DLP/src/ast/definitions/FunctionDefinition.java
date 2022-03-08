package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.expressions.Variable;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private List<Statement> body;

    public FunctionDefinition(Variable name, Type type, List<Statement> body, int column, int line) {
        super(name, type, column, line);
        this.body = body;
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
