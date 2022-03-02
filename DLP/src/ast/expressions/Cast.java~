package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public class Cast extends AbstractASTNode implements Expression {

    private Type type;
    private Expression expression;

    public Cast(Type type, Expression expression, int column, int line) {
        super(column, line);
        this.type = type;
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getType() {
        return type;
    }
}
