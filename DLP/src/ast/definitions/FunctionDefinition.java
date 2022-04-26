package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.types.FunctionType;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private final List<Statement> body;
    private int bytesLocals;
    private int bytesReturn;
    private int bytesParam;

    public FunctionDefinition(String name, FunctionType type, List<Statement> body, int line, int column) {
        super(name, type, line, column);
        this.body = body;

    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Function " + getName() + " type: " + getType();
    }

    @Override
    public FunctionType getType() {
        return (FunctionType) super.getType();
    }

    public int getBytesLocals() {
        return bytesLocals;
    }

    public void setBytesLocals(int bytesLocals) {
        this.bytesLocals = bytesLocals;
    }

    public int getBytesReturn() {
        return bytesReturn;
    }

    public void setBytesReturn(int bytesReturn) {
        this.bytesReturn = bytesReturn;
    }

    public int getBytesParam() {
        return bytesParam;
    }

    public void setBytesParam(int bytesParam) {
        this.bytesParam = bytesParam;
    }
}
