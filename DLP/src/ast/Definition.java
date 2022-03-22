package ast;

import ast.expressions.Variable;

public interface Definition extends ASTNode
{
    String getName();
    Type getType();
    int getScope();
    void setScope(int scope);
}
