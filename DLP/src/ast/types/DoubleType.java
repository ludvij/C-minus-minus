package ast.types;

import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {

    private static DoubleType instance;

    private DoubleType() {
        super(0, 0);
    }

    public static DoubleType get() {
        if (instance == null) {
            instance = new DoubleType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type other, int line, int column) {
        if (this.equals(other) || other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("double type expected, found: " + other, line, column);
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.equals(other)){
            return IntType.get();
        } else if (other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("double type expected, found: " + other, line, column);
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return this;
    }

    @Override
    public void read(int line, int column) {}

    @Override
    public void write(int line, int column) {}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    public String getSuffix() {
        return "f";
    }

    @Override
    public String convert(Type other) {
        if (other instanceof IntType) {
            return "\tf2i\n";
        } else if (other instanceof CharType) {
            return  "\tf2i\n\ti2b";
        } else {
            return "";
        }
    }

    @Override
    public String promote(Type other) {
        return "";
    }
}
