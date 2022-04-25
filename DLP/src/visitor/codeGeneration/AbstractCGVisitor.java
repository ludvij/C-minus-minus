package visitor.codeGeneration;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.program.Program;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {
	@Override
	public TR visit(Program e, TP param) {
		return null;
	}

	@Override
	public TR visit(FunctionDefinition e, TP param) {
		return null;
	}

	@Override
	public TR visit(VariableDefinition e, TP param) {
		return null;
	}

	@Override
	public TR visit(AssignmentStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(ReturnStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(WhileStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(WriteStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(ReadStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(IfStatement e, TP param) {
		return null;
	}

	@Override
	public TR visit(ArithmeticOperation e, TP param) {
		return null;
	}

	@Override
	public TR visit(ComparisonOperation e, TP param) {
		return null;
	}

	@Override
	public TR visit(FunctionInvocation e, TP param) {
		return null;
	}

	@Override
	public TR visit(LogicalOperation e, TP param) {
		return null;
	}

	@Override
	public TR visit(DoubleLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(RecordAccesor e, TP param) {
		return null;
	}

	@Override
	public TR visit(CharLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(UnaryMinus e, TP param) {
		return null;
	}

	@Override
	public TR visit(IntLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(Indexing e, TP param) {
		return null;
	}

	@Override
	public TR visit(Negation e, TP param) {
		return null;
	}

	@Override
	public TR visit(Variable e, TP param) {
		return null;
	}

	@Override
	public TR visit(Cast e, TP param) {
		return null;
	}

	@Override
	public TR visit(FunctionType e, TP param) {
		return null;
	}

	@Override
	public TR visit(RecordField e, TP param) {
		return null;
	}

	@Override
	public TR visit(DoubleType e, TP param) {
		return null;
	}

	@Override
	public TR visit(RecordType e, TP param) {
		return null;
	}

	@Override
	public TR visit(ArrayType e, TP param) {
		return null;
	}

	@Override
	public TR visit(CharType e, TP param) {
		return null;
	}

	@Override
	public TR visit(VoidType e, TP param) {
		return null;
	}

	@Override
	public TR visit(IntType e, TP param) {
		return null;
	}

	@Override
	public TR visit(ErrorType e, TP param) {
		return null;
	}
}
