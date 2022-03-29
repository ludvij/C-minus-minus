package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class CharType extends AbstractASTNode implements Type {

    private static CharType instance;

    private CharType() {
        super(0, 0);
    }

    public static CharType get() {
        if (instance == null) {
            instance = new CharType();
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "char";
    }
}
