package ast.types.error;

import ast.types.AbstractType;
import errorHandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType {

    private final String message;

    public ErrorType(String message, int line, int column) {
        super(line, column);
        this.message = message;

        ErrorHandler.get().addError(this);
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "["+getLine()+"," +getColumn()+"]: " + message;
    }


    public String getMessage() {
        return message;
    }
}
