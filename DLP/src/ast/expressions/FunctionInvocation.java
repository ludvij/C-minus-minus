package ast.expressions;

import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    private final Variable name;
    private final List<Expression> parameters;


    public FunctionInvocation(Variable name, List<Expression> parameters, int line, int column) {
        super(line, column);
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
