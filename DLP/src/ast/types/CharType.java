package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

public class CharType extends AbstractASTNode implements Type {

    public CharType(int column, int line) {
        super(column, line);
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
