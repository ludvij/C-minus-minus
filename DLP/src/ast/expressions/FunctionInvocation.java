package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Statement, Expression {

    private Variable name;
    private List<Expression> parameters;

    public FunctionInvocation(Variable name, List<Expression> parameters, int column, int line) {
        super(column, line);
        this.name = name;
        this.parameters = parameters;
    }

    public Variable getName() { return name; }
    public List<Expression> getParameters() { return parameters; }

    @Override
    public String toString() {
        StringBuilder params = new StringBuilder();
        for (Expression p : parameters) {
            params.append(p).append(", ");
        }
        if (!parameters.isEmpty())
            params.setLength(params.length() - 1);
        return name + "(" + params + ")";
    }
}
