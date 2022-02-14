package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Assignment extends AbstractASTNode implements Statement {

    private final Expression rightExpression;
    private final Expression leftExpression;

    public Assignment(Expression rightExpression, Expression leftExpression, int column, int line) {
        super(column, line);
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() { return rightExpression; }
    public Expression getLeftExpression() { return leftExpression; }
}
