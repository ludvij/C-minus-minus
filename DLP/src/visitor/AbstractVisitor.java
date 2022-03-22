package visitor;

import ast.Definition;
import ast.Expression;
import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.program.Program;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

	@Override
	public TR visit(Program e, TP param) {
		for (Definition def : e.getDefinitions()){
			def.accept(this, param);
		}
		return null;
	}

	@Override
	public TR visit(FunctionDefinition e, TP param) {
		e.getType().accept(this, param);

		for (Statement stmt : e.getBody()) {
			stmt.accept(this, param);
		}
		return null;
	}

	@Override
	public TR visit(VariableDefinition e, TP param) {
		return e.getType().accept(this, param);
	}


	@Override
	public TR visit(ReturnStatement e, TP param) {
		return e.getExpression().accept(this, param);
	}

	@Override
	public TR visit(WhileStatement e, TP param) {
		e.getExpression().accept(this, param);
		for (Statement stmt : e.getBody()) {
			stmt.accept(this, param);
		}
		return null;
	}

	@Override
	public TR visit(WriteStatement e, TP param) {
		return e.getExpression().accept(this, param);
	}

	@Override
	public TR visit(IfStatement e, TP param) {
		e.getExpression().accept(this, param);
		for (Statement stmt : e.getIfBody()) {
			stmt.accept(this, param);
		}
		for (Statement stmt : e.getElseBody()) {
			stmt.accept(this, param);
		}
		return null;
	}

	@Override
	public TR visit(FunctionType e, TP param) {
		e.getType().accept(this, param);

		for (VariableDefinition def : e.getParameters()) {
			def.accept(this, param);
		}

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
	public TR visit(StructType e, TP param) {
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

	@Override
	public TR visit(AssignmentStatement e, TP param) {
		e.getLeftExpression().accept(this, param);
		e.getRightExpression().accept(this, param);
		return null;
	}

	@Override
	public TR visit(ReadStatement e, TP param) {
		return e.getExpression().accept(this, param);
	}

	@Override
	public TR visit(ArithmeticOperation e, TP param) {
		e.getExpressionLeft().accept(this, param);
		e.getExpressionRight().accept(this, param);
		return null;
	}

	@Override
	public TR visit(ComparisonOperation e, TP param) {
		e.getExpressionLeft().accept(this, param);
		e.getExpressionRight().accept(this, param);
		return null;
	}


	@Override
	public TR visit(FunctionInvocation e, TP param) {
		e.getName().accept(this, param);
		for (Expression parameter : e.getParameters()) {
			parameter.accept(this, param);
		}
		return null;
	}

	@Override
	public TR visit(LogicalOperation e, TP param) {
		e.getExpressionLeft().accept(this, param);
		e.getExpressionRight().accept(this, param);
		return null;
	}

	@Override
	public TR visit(DoubleLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(RecordAccesor e, TP param) {
		e.getExpression().accept(this, param);
		return null;
	}

	@Override
	public TR visit(CharLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(UnaryMinus e, TP param) {
		e.getExpression().accept(this, null);
		return null;
	}

	@Override
	public TR visit(IntLiteral e, TP param) {
		return null;
	}

	@Override
	public TR visit(Indexing e, TP param) {
		e.getExpressionLeft().accept(this, param);
		e.getExpressionRight().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Cast e, TP param) {
		e.getExpression().accept(this, param);
		e.getCastType().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Negation e, TP param) {
		e.getExpression().accept(this, param);
		return null;
	}

}
