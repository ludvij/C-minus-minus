package ast;

public abstract class AbstractASTNode implements  ASTNode{

    private final int column;
    private final int line;

    public AbstractASTNode(int column, int line)
    {
        this.line = line;
        this.column = column;
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
