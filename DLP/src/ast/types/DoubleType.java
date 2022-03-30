package ast.types;

import ast.Type;
import ast.types.error.ErrorType;
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
        if (this.getClass() != other.getClass()) {
            new ErrorType("Expected: double, Given: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Expected: double, Given: " + other,
                line, column);
        }
        return IntType.get();
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
        return "double";
    }
}
