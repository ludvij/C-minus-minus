package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class ID extends AbstractASTNode implements Expression {

    private String name;

    public ID(String name, int column, int line) {
        super(column, line);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
