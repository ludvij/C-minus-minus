package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

    private Type castType;
    private Expression expression;


    public Cast(Type castType, Expression expression, int column, int line) {
        super(column, line);
        this.castType = castType;
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Type getCastType() {
        return castType;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "("+castType+")" + expression +  " " +"["+getLine()+","+getColumn()+"]";
    }
}
