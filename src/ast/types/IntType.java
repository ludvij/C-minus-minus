package ast.types;

import ast.AbstractASTNode;

public class IntType extends AbstractASTNode implements Type {


    public IntType(int column, int line)
    {
        super(column, line);
    }

}
