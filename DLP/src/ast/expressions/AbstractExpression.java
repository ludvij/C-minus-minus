package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lValue;

    public AbstractExpression(int column, int line) {
        super(column, line);
    }

    @Override
    public boolean getLvalue() {
        return lValue;
    }

    @Override
    public void setLvalue(boolean lValue) {
        this.lValue = lValue;
    }
}
