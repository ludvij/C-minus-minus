package ast.types;

import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {

    public DoubleType(int column, int line) {
        super(column, line);
    }

    @Override
    public Type arithmetic(Type other) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("[arithmetic]: required: DoubleType, provided: " + other.getClass().getSimpleName(),
                getColumn(), getLine());
        }
        return this;
    }

    @Override
    public Type comparison(Type other) {
        if (this.getClass() != other.getClass()) {
            new ErrorType("[comparison]: required: DoubleType, provided: " + other.getClass().getSimpleName(),
                getColumn(), getLine());
        }
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
