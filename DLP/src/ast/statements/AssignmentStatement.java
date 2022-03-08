package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class AssignmentStatement extends AbstractASTNode implements Statement {

    private Expression rightExpression;
    private Expression leftExpression;

    public AssignmentStatement(Expression rightExpression, Expression leftExpression, int column, int line) {
        super(column, line);
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() { return rightExpression; }
    public Expression getLeftExpression() { return leftExpression; }

    @Override
    public String toString() {
        return rightExpression + " = " + leftExpression + ";";
    }
}
