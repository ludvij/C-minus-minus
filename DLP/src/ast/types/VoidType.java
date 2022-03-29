package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class VoidType extends AbstractASTNode implements Type {

    private static VoidType instance;

    private VoidType() {
        super(0,0);
    }

    public static VoidType get() {
        if (instance == null) {
            instance = new VoidType();
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "void";
    }
}
