package ast.expressions;

import visitor.Visitor;

public class CharLiteral extends AbstractExpression {

    private final char value;


    public CharLiteral(char value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "'"+value+"'";
    }

    public char getValue() {
        return value;
    }
}
