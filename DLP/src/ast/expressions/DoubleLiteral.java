package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class DoubleLiteral extends AbstractASTNode implements Expression {

    private double value;

    public DoubleLiteral(double value, int column, int line) {
        super(column, line);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
