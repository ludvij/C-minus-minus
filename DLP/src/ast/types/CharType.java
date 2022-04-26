package ast.types;

import ast.Type;
import visitor.Visitor;

public class CharType extends AbstractType {

    private static CharType instance;

    private CharType() {
        super(0, 0);
    }

    public static CharType get() {
        if (instance == null) {
            instance = new CharType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type other, int line, int column) {
        if (other instanceof ErrorType) {
            return other;
        } else if (this.equals(other)) {
            return IntType.get();
        }
        return new ErrorType("char type expected, found: " + other, line, column);
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (other instanceof ErrorType) {
            return other;
        } else if (this.equals(other)){
            return IntType.get();
        }
        return new ErrorType("char type expected, found: " + other, line, column);
    }

    @Override
    public boolean isBuiltin() {
        return true;
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
        return "char";
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public String getSuffix() {
        return "b";
    }

    @Override
    public String convert(Type other) {
        if (other instanceof IntType) {
            return "\tb2i\n";
        } else if (other instanceof DoubleType) {
            return "\tb2i\n\ti2f\n";
        } else {
            return "";
        }
    }

    @Override
    public String promote(Type other) {
        return convert(other);
    }
}
