package ast.types;

import ast.Type;
import visitor.Visitor;

public class ArrayType extends AbstractType {

    private final int size;
    private Type type;

    public ArrayType(Type type, int size, int line, int column) {
        super(line, column);
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


        public static ArrayType create(Type type, int size, int line, int column) {
            if (type instanceof ArrayType) {
                return arrayOfArray(type, size, line, column);
            } else {
                return normalArray(type, size, line, column);
            }
        }

        private static ArrayType normalArray(Type type, int size, int line, int column) {
            return new ArrayType(type, size, line, column);
        }

        private static ArrayType arrayOfArray(Type type, int size, int line, int column) {

            // we have to swap the arrayTypes
            Type swap = ((ArrayType)type).getType();
            ((ArrayType) type).setType(create(swap, size, line, column));

            return (ArrayType) type;
        }
    }
}
