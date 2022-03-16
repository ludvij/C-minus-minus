package ast;

import semantic.Visitor;

public abstract class AbstractASTNode implements  ASTNode{

    private final int column;
    private final int line;

    public AbstractASTNode(int column, int line)
    {
        this.line = line;
        this.column = column;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        System.out.println("Not yet implemented: " + this.getClass());
        return null;
    }

    @Override
    public int getLine()
    {
        return line;
    }

    @Override
    public int getColumn()
    {
        return column;
    }
}
