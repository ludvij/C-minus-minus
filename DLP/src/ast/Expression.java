package ast;

public interface Expression extends ASTNode
{
    boolean getLvalue();

    void setLvalue(boolean lValue);

    Type getType();
    void setType(Type type);
}
