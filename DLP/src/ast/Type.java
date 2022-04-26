package ast;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode
{
	Type arithmetic(Type other, int line, int column);
	Type comparison(Type other, int line, int column);
	Type squareBrackets(Type other, int line, int column);
	Type parenthesis(List<Type> params, int line, int column);
	Type logical(Type other, int line, int column);
	Type dot(String field, int line, int column);
	Type unaryMinus(int line, int column);
	Type negation(int line, int column);
	Type castTo(Type other, int line, int column);
	Type asBoolean(int line, int column);
	void assign(Type other, int line, int column);
	void read(int line, int column);
	void write(int line, int column);



	boolean isBuiltin();

	int numberOfBytes();
	String getSuffix();
	String convert(Type other);
	String promote(Type other);
}
