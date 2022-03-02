package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class ProcedureInvocation extends AbstractASTNode implements Statement {

    private String name;

    public ProcedureInvocation(String name, int column, int line) {
        super(column, line);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
