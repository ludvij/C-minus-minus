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
	public void assign(Type other, int line, int column) {
		if (!(this instanceof ErrorType || other instanceof ErrorType || this.equals( other ))) {
			new ErrorType(this + " type expected, found: " + other, line, column);
		}
	}

	@Override
	public void read(int line, int column) {
		if (!(this instanceof ErrorType)) {
			new ErrorType(this + " type cannot be read", line, column);
		}
	}

	@Override
	public void write(int line, int column) {
		if (!(this instanceof ErrorType)) {
			new ErrorType(this + " type cannot be written", line, column);
		}
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

	@Override
	public String getSuffix() {
		return "?";
	}

	@Override
	public String convert(Type other) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public String promote(Type other) {
		throw new RuntimeException("Not implemented");
	}
}
