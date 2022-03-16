package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.expressions.Variable;
import semantic.Visitor;

public class RecordField extends AbstractASTNode {

    private Variable name;
    private Type type;

    public RecordField(Variable name, Type type, int column, int line) {
        super(column, line);
        this.name = name;
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Variable getName() { return name; }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return type + " " + name + ";";
    }
}
