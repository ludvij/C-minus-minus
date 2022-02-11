package ast.types;

import ast.AbstractASTNode;

public class CharType extends AbstractASTNode implements Type {

    public CharType(int column, int line)
    {
        super(column, line);
    }
}
