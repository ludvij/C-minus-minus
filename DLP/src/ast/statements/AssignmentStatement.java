package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class AssignmentStatement extends AbstractASTNode implements Statement {

    private final Expression rightExpression;
    private final Expression leftExpression;

    public AssignmentStatement(Expression leftExpression, Expression rightExpression, int line, int column) {
        super(line, column);
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
