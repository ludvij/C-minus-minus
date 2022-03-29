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
        if (this.getClass() != other.getClass()) {
            new ErrorType("[arithmetic]: required: DoubleType, provided: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type comparison(Type other, int line, int column) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("[comparison]: required: DoubleType, provided: " + other,
                line, column);
        }
        return get();
    }

    @Override
    public Type castTo(Type other, int line, int column) {
        if (!(other == IntType.get() || other == CharType.get() || other == DoubleType.get())) {
            new ErrorType("[cast]: Invalid cast: for " + this + " and " + other , line, column);
        }
        return other;
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
