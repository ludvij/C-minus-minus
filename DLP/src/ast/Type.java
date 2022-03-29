package ast;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode
{
	Type arithmetic(Type other);
	Type comparison(Type other);
	Type squareBrackets(Type other);
	Type parenthesis(List<Type> other);
	Type dot(String field);
	Type unaryMinus();
	Type negation();

}
