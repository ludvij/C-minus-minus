package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class Write extends AbstractASTNode implements Statement {

    private final List<Expression> innerExpressions;

    public Write(List<Expression> innerExpressions, int column, int line) {
        super(column, line);
        this.innerExpressions = innerExpressions;
    }

    public List<Expression> getInnerExpressions() { return innerExpressions; }
}
