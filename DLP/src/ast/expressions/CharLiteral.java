package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import semantic.Visitor;

public class CharLiteral extends AbstractExpression {

    private char value;


    public CharLiteral(char value, int column, int line) {
        super(column, line);
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
}
