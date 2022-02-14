package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;

import java.util.List;

public class If extends AbstractASTNode implements Expression {

    private final List<Expression> ifBody;
    private final List<Expression> elseBody;

    public If(List<Expression> ifBody, List<Expression> elseBody, int column, int line) {
        super(column, line);
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public List<Expression> getIfBody() {
        return ifBody;
    }

    public List<Expression> getElseBody() {
        return elseBody;
    }
}
