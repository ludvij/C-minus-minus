package ast.expressions;

import visitor.Visitor;

public class IntLiteral extends AbstractExpression {

    private final int value;


    public IntLiteral(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
