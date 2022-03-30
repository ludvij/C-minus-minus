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
            new ErrorType("Required: IntType, provided: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Required: IntType, provided: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type logical(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("Required: IntType, provided: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type negation(int line, int column) {
        return asBoolean(line, column);
    }

    @Override
    public Type castTo(Type other, int line, int column) {
        if (!(other.isBuiltin())) {
            new ErrorType("Invalid cast: for " + this + " and " + other , line, column);
        }
        return other;
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


    @Override
    public String toString() {
        return "int";
    }

}
