package ast.expressions;

import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression {

    private double value;


    public DoubleLiteral(double value, int column, int line) {
        super(column, line);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "f";
    }
}
