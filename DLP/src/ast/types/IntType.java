package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class IntType extends AbstractASTNode implements Type {

    private static IntType instance;

    private IntType() {
        super(0, 0);
    }

    public static IntType get() {
        if (instance == null) {
            instance = new IntType();
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    @Override
    public String toString() {
        return "int";
    }

}
