package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int line, int column) {
		super(line, column);
	}

	@Override
	public Type arithmetic(Type other) {
		new ErrorType("Invalid arithmetic operation", getColumn(), getLine());
		return this;
	}

	@Override
	public Type comparison(Type other) {
		new ErrorType("Invalid comparison operation", getColumn(), getLine());
		return this;
	}

	@Override
	public Type squareBrackets(Type other) {
		new ErrorType("Invalid indexing operation", getColumn(), getLine());
		return this;
	}

	@Override
	public Type parenthesis(List<Type> other) {
		new ErrorType("Invalid function call", getColumn(), getLine());
		return this;
	}

	@Override
	public Type dot(String field) {
		new ErrorType("Invalid record access", getColumn(), getLine());
		return this;
	}

	@Override
	public Type unaryMinus() {
		new ErrorType("Invalid minus operation", getColumn(), getLine());
		return this;
	}

	@Override
	public Type negation() {
		new ErrorType("Invalid negation operation", getColumn(), getLine());
		return this;
	}
}
