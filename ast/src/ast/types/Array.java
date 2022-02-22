package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class Array extends AbstractASTNode implements Type {

    private final int size;
    private final Type type;

    public Array(int size, Type type, int column, int line) {
        super(column, line);
        this.size = size;
        this.type = type;
    }


    public int getSize() { return size; }

    public Type getType() { return type; }
}
