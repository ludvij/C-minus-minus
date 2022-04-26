package ast.expressions;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

    private final Type castType;
    private final Expression expression;


    public Cast(Type castType, Expression expression, int line, int column) {
        super(line, column);
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
        return "("+castType+")" + expression;
    }
}
