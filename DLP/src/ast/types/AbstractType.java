package ast.types;

import ast.AbstractASTNode;
import ast.Type;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int line, int column) {
		super(line, column);
	}

	@Override
	public Type arithmetic(Type other, int line, int column) {
		new ErrorType("Invalid arithmetic operation for: " + this + " and " + other, line, column);
		return this;
	}

	@Override
	public Type comparison(Type other, int line, int column) {
		new ErrorType("Invalid comparison operation for: " + this + " and " + other, line, column);
		return IntType.get();
	}

	@Override
	public Type squareBrackets(Type other, int line, int column) {
		new ErrorType("Invalid indexing operation for: "  + this + " and " + other, line, column);
		return this;
	}

	@Override
	public Type parenthesis(List<Type> params, int line, int column) {
		new ErrorType("Invalid function call", line, column);
		return this;
	}

	@Override
	public Type dot(String field, int line, int column) {
		new ErrorType("Invalid record access", line, column);
		return this;
	}

	@Override
	public Type unaryMinus(int line, int column) {
		new ErrorType("Invalid minus operation", line, column);
		return this;
	}

	@Override
	public Type negation(int line, int column) {
		new ErrorType("Invalid negation operation", line, column);
		return IntType.get();
	}

	@Override
	public Type logical(Type other, int line, int column) {
		new ErrorType("Invalid logical operation for: " + this + " and " + other, line, column);
		return IntType.get();
	}

	@Override
	public Type castTo(Type other, int line, int column) {
		new ErrorType("Invalid cast for type: " + other, line, column);
		return this;
	}

	@Override
	public Type asBoolean(int line, int column) {
		new ErrorType("Invalid conversion to boolean for type " + this, line, column);
		return IntType.get();
	}

	@Override
	public boolean isBuiltin() {
		return false;
	}
}
