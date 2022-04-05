package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.FunctionDefinition;
import ast.expressions.Variable;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int line, int column) {
		super(line, column);
	}

	@Override
	public Type arithmetic(Type other, int line, int column) {
		if (other instanceof ErrorType) return other;
		return new ErrorType("Invalid arithmetic operation for: " + this + " and " + other, line, column);
	}

	@Override
	public Type comparison(Type other, int line, int column) {
		if (other instanceof ErrorType) return other;
		return new ErrorType("Invalid comparison operation for: " + this + " and " + other, line, column);
	}

	@Override
	public Type squareBrackets(Type other, int line, int column) {
		if (other instanceof ErrorType) return other;
		return new ErrorType("Array type expected, Found: " + this , line, column);
	}

	@Override
	public Type parenthesis(List<Type> params, int line, int column) {
		if (this instanceof ErrorType) return this;
		return new ErrorType(this + " cannot be called", line, column);
	}

	@Override
	public Type dot(String field, int line, int column) {
		if (this instanceof ErrorType) return this;
		return new ErrorType("Struct type expected, Found: " + this, line, column);
	}

	@Override
	public Type unaryMinus(int line, int column) {
		if (this instanceof ErrorType) return this;
		return new ErrorType("- cannot be applied to " + this, line, column);
	}

	@Override
	public Type negation(int line, int column) {
		if (this instanceof ErrorType) return this;
		return new ErrorType("! cannot be applied to " + this, line, column);
	}

	@Override
	public Type logical(Type other, int line, int column) {
		if (other instanceof ErrorType) return other;
		return new ErrorType("Invalid logical operation for: " + this + " and " + other, line, column);
	}

	@Override
	public Type castTo(Type other, int line, int column) {
		if (other instanceof ErrorType) return other;
		if (!other.isBuiltin())
			return new ErrorType(this + " cannot be casted" , line, column);
		return other;
	}

	@Override
	public Type asBoolean(int line, int column) {
		if (this instanceof ErrorType) return this;
		return new ErrorType(this + " cannot be converted to boolean", line, column);
	}

	@Override
	public boolean isBuiltin() {
		return false;
	}

	@Override
	public int numberOfBytes() {
		return 0;
	}
}
