package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class VoidType extends AbstractASTNode implements Type {

    public VoidType(int column, int line) {
        super(column, line);
    }
}
