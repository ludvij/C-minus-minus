package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class IntLiteral extends AbstractASTNode implements Expression {

    private int value;

    public IntLiteral(int value, int column, int line) {
        super(column, line);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
