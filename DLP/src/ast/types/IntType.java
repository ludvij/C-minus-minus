package ast.types;

import ast.Type;
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
        if (this.equals(other) || other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("int type expected, found: " + other, line, column);
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.equals(other)){
            return IntType.get();
        } else if (other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("int type expected, found: " + other, line, column);
    }

    @Override
    public Type logical(Type other, int line, int column) {
        if (this.equals(other)){
            return IntType.get();
        } else if (other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("int type expected, found: " + other, line, column);
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
