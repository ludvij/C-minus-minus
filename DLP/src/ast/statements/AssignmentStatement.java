package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import semantic.Visitor;

public class AssignmentStatement extends AbstractASTNode implements Statement {

    private Expression rightExpression;
    private Expression leftExpression;

    public AssignmentStatement(Expression leftExpression, Expression rightExpression, int column, int line) {
        super(column, line);
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public Expression getRightExpression() { return rightExpression; }
    public Expression getLeftExpression() { return leftExpression; }

    @Override
    public String toString() {
        return rightExpression + " = " + leftExpression + ";";
    }
}
