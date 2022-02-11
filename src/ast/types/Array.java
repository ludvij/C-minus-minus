package ast.types;

import ast.AbstractASTNode;

public class Array extends AbstractASTNode implements Type {

    private int size;
    private Type type;

    public Array(int size, Type type, int column, int line)
    {
        super(column, line);
        this.size = size;
        this.type = type;
    }
}
