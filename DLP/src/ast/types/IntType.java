package ast.types;

import ast.Type;
import ast.types.error.ErrorType;
import visitor.Visitor;

public class IntType extends AbstractType {

    private static IntType instance;

    private IntType() {
        super(0, 0);
    }

    public static IntType get() {
        if (instance == null) {
            instance = new IntType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Expected: int, Given: " + other,
                line, column);
        }
        return IntType.get();
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Expected: int, Given: " + other,
                line, column);
        }
        return IntType.get();
    }

    @Override
    public Type logical(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Expected: int, Given: " + other,
                line, column);
        }
        return IntType.get();
    }

    @Override
    public Type asBoolean(int line, int column) {
        return IntType.get();
    }

    @Override
    public Type negation(int line, int column) {
        return asBoolean(line, column);
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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    @Override
    public String toString() {
        return "int";
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }
}
