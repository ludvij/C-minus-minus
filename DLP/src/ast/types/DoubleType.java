package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractASTNode implements Type {

    public DoubleType(int column, int line) {
        super(column, line);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "double";
    }
}
