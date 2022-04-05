package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.types.error.ErrorType;

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
		new ErrorType("Array type expected, Found: " + this , line, column);
		return this;
	}

	@Override
	public Type parenthesis(List<Type> params, int line, int column) {
		new ErrorType(this + " cannot be called", line, column);
		return this;
	}

	@Override
	public Type dot(String field, int line, int column) {
		new ErrorType("Struct type expected, Found: " + this, line, column);
		return this;
	}

	@Override
	public Type unaryMinus(int line, int column) {
		new ErrorType("- cannot be applied to " + this, line, column);
		return IntType.get();
	}

	@Override
	public Type negation(int line, int column) {
		new ErrorType("! cannot be applied to " + this, line, column);
		return IntType.get();
	}

	@Override
	public Type logical(Type other, int line, int column) {
		new ErrorType("Invalid logical operation for: " + this + " and " + other, line, column);
		return IntType.get();
	}

	@Override
	public Type castTo(Type other, int line, int column) {
		if (!other.isBuiltin())
			new ErrorType(this + " cannot be casted" , line, column);
		return other;
	}

	@Override
	public Type asBoolean(int line, int column) {
		new ErrorType(this + " cannot be converted to boolean", line, column);
		return IntType.get();
	}

	@Override
	public void read(int line, int column) {
		if (!this.isBuiltin()) {
			new ErrorType(this + "type cannot be read", line, column);
		}
	}

	@Override
	public void write(int line, int column) {
		if (!this.isBuiltin()) {
			new ErrorType(this + " type cannot be written", line, column);
		}
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
