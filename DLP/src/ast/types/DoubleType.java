package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractASTNode implements Type {

    private static DoubleType instance;

    private DoubleType() {
        super(0, 0);
    }

    public static DoubleType get() {
        if (instance == null) {
            instance = new DoubleType();
        }
        return instance;
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
