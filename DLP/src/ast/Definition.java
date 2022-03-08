package ast;

import ast.expressions.Variable;

public interface Definition extends ASTNode
{
    Variable getName();
    Type getType();
}
