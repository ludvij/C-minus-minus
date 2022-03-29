package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lValue;

    private Type Type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean getLvalue() {
        return lValue;
    }

    @Override
    public void setLvalue(boolean lValue) {
        this.lValue = lValue;
    }

    @Override
    public Type getType() {
        return Type;
    }

    @Override
    public void setType(Type type) {
        Type = type;
    }
}
