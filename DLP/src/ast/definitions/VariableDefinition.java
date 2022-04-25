package ast.definitions;

import ast.Statement;
import ast.Type;
import visitor.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {

    private int offset;
    private int scope;

    public VariableDefinition(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return getType() + " " + getName();
    }

}
