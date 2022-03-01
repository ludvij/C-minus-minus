package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class DoubleType extends AbstractASTNode implements Type {

    public DoubleType(int column, int line) {
        super(column, line);
    }
}
