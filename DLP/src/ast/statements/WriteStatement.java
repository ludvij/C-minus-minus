package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class WriteStatement extends AbstractASTNode implements Statement {

    private List<Expression> expressions;

    public WriteStatement(List<Expression> innerExpressions, int column, int line) {
        super(column, line);
        this.expressions = innerExpressions;
    }

    public List<Expression> getExpressions() { return expressions; }
}
