package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class ReadStatement extends AbstractASTNode implements Statement {

    private List<Expression> expressions;

    public ReadStatement(List<Expression> expressions, int column, int line) {
        super(column, line);
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() { return expressions; }
}
