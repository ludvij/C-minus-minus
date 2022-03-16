package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class Negation extends AbstractExpression {

    private Expression expression;


    public Negation(Expression expression, int column, int line) {
        super(column, line);
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "!" + expression;
    }
}
