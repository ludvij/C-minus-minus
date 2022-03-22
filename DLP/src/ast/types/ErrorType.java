package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import errorHandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractASTNode implements Type {

    private String message;

    public ErrorType(String message, int column, int line) {
        super(column, line);
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
