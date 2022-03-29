package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class ArrayType extends AbstractASTNode implements Type {

    private final int size;
    private Type type;

    public ArrayType(Type type, int size, int column, int line) {
        super(column, line);
        this.type = type;
        this.size = size;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }



    public Type getType() { return type; }
    public int getSize() { return size; }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + "[" + size + "]";
    }

    public static class Factory {


        public static ArrayType create(Type type, int size, int column, int line) {
            if (type instanceof ArrayType) {
                return arrayOfArray(type, size, column, line);
            } else {
                return normalArray(type, size, column, line);
            }
        }

        private static ArrayType normalArray(Type type, int size, int column, int line) {
            return new ArrayType(type, size, column, line);
        }

        private static ArrayType arrayOfArray(Type type, int size, int column, int line) {

            // we have to swap the arrayTypes
            Type swap = ((ArrayType)type).getType();
            ((ArrayType) type).setType(create(swap, size, column, line));

            return (ArrayType) type;
        }
    }
}
