package ast.expressions;

import visitor.Visitor;

public class Variable extends AbstractExpression {

    private String name;

    public Variable(String name, int column, int line) {
        super(column, line);
        this.name = name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
