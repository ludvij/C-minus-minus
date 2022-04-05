package errorHandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class ErrorHandler {

    private ErrorHandler() {}

    private static ErrorHandler instance;

    private final List<ErrorType> errors = new LinkedList<>();

    public static ErrorHandler get() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public boolean anyErrors() {
        // if there is no error returns true
        return !errors.isEmpty();
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }

    public void showErrors(PrintStream out) {
        for (ErrorType error : errors) {
            out.println(error);
        }
    }
}
