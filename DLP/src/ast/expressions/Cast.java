package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public class Cast extends AbstractASTNode implements Expression {

    private Type castType;
    private Expression expression;

    public Cast(Type castType, Expression expression, int column, int line) {
        super(column, line);
        this.castType = castType;
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getCastType() {
        return castType;
    }

    @Override
    public String toString() {
        return "("+castType+")" + expression +  " " +"["+getLine()+","+getColumn()+"]";
    }
}
