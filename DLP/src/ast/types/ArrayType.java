package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class ArrayType extends AbstractASTNode implements Type {

    private int size;
    private Type type;

    public ArrayType(Type type, int size, int column, int line) {
        super(column, line);
        this.type = type;
        this.size = size;
    }



    public Type getType() { return type; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return type + "[" + size + "]";
    }
}
