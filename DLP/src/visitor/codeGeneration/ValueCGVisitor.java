package visitor.codeGeneration;

import ast.definitions.VariableDefinition;
import ast.expressions.*;
import visitor.codeGeneration.cg.CodeGenerator;

/**
 * Integer constant:
 *
 * value[[IntLiteral: expression -> INT_CONSTANT]] =
 *
 * <pushi > INT_CONSTANT
 * Character constant:
 *
 * value[[CharLiteral: expression -> CHAR_CONSTANT]] =
 *
 * <pushb > (int)CHAR_CONSTANT
 * Real constant:
 *
 * value[[DoubleLiteral: expression -> REAL_CONSTANT]] =
 *
 * <pushf > REAL_CONSTANT
 * Variables:
 *
 * value[[Variable: expression -> ID]] =
 * address[[expression]]
 * <load> var.definition.type.suffix
 * Arithmetic:
 *
 * value[[Arithmetic: expression1 -> expression2 ("+"|"-"|"*"|"/") expression3]] =
 *
 * value[[expression2]]
 * expression2.type.convert(expression1.type)
 * value[[expression3]]
 * expression3.type.convert(expression1.type)
 *
 * switch(expression1.operator) {
 * case "+": <add> expression1.type.suffix
 * 	break;
 * case "-": <sub> epxression1.type.suffix
 * 	break;
 * case "*": <mul> expression1.type.suffix
 * 	break;
 * case "/": <div> expression1.type.suffix
 * 	break;
 * case "%": <mod>
 * }
 * Unary Minus:
 *
 * value[[UnaryMinus: expression1 -> expression2]] =
 *
 * <push> expression1.type.suffix < > 0
 * value[[expression2]]
 *
 * <sub> expression1.type.suffix
 * Comparison:
 *
 * value[[Comparison: expression1 -> expression2 ("<"|">"|"<="|">="|"=="|"!=") expression2]] =
 *
 * value[[expression2]]
 * expression2.type.promotesTo(expression1.type)
 * value[[expression3]]
 * expression3.type.promotesTo(expression1.type)
 *
 * switch (expression1.operator) {
 * case "<" : <lt> expression2.type.comparisonSuffix()
 * 	break;
 * case ">" : <gt> expression2.type.comparisonSuffix()
 * 	break;
 * case "<=": <lte> expression2.type.comparisonSuffix()
 * 	break;
 * case ">=": <gte> expression2.type.comparisonSuffix()
 * 	break;
 * case "==": <eq> expression2.type.comparisonSuffix()
 * 	break;
 * case "!=": <ne> expression2.type.comparisonSuffix()
 * 	break;
 * }
 * Logical:
 *
 * value[[Logical: expression1 -> expression2 ('&&'|'||') expression3]] =
 *
 * value[[expression2]]
 * value[[expression3]]
 *
 * switch(expression1.operator) {
 * case "&&": <and>
 * 	break;
 * case '||': <or>
 * 	break;
 * }
 * Unary not:
 *
 * value[[UnaryNot: expression1 -> expression2]] =
 * value[[expression2]]
 * <not>
 * Casts:
 *
 * value[[Cast: expression1 -> type expression2]] =
 *
 * value[[expression2]]
 * expression2.type.convert(type)
 */
public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

	private CodeGenerator cg;

	private AddressCGVisitor acg;

	public ValueCGVisitor(CodeGenerator cg) {
		this.cg = cg;
	}

	public void setAcg(AddressCGVisitor acg) {
		this.acg = acg;
	}

	@Override
	public Void visit(IntLiteral e, Void param) {
		cg.pushInt(e);
		return null;
	}

	@Override
	public Void visit(CharLiteral e, Void param) {
		cg.pushChar(e);
		return null;
	}

	@Override
	public Void visit(DoubleLiteral e, Void param) {
		cg.pushDouble(e);
		return null;
	}


	public Void visit(ArithmeticOperation e, Void param) {
		e.getExpressionLeft().accept(this, param);
		cg.convert(e.getType(), e.getExpressionLeft().getType());
		e.getExpressionRight().accept(this, param);
		cg.convert(e.getType(), e.getExpressionRight().getType());

		cg.arithmetic(e);
		return null;
	}

	@Override
	public Void visit(UnaryMinus e, Void param) {
		cg.unaryMinus(e);
		e.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Void visit(ComparisonOperation e, Void param) {
		e.getExpressionLeft().accept(this, param);
		cg.promote(e.getType(), e.getExpressionLeft().getType());
		e.getExpressionRight().accept(this, param);
		cg.promote(e.getType(), e.getExpressionRight().getType());

		cg.comparison(e);
		return null;
	}

	@Override
	public Void visit(LogicalOperation e, Void param) {
		e.getExpressionLeft().accept(this, param);
		e.getExpressionRight().accept(this, param);

		cg.logical(e);
		return null;
	}

	@Override
	public Void visit(Negation e, Void param) {
		e.getExpression().accept(this, param);
		cg.not();
		return null;
	}

	@Override
	public Void visit(Cast e, Void param) {
		e.getExpression().accept(this, param);
		cg.convert(e.getType(), e.getExpression().getType());
		return null;
	}

	@Override
	public Void visit(Variable e, Void param) {
		if (e.getDefinition() instanceof VariableDefinition) {
			e.accept(acg, param);

			cg.load(e.getDefinition().getType());
		}
		return null;
	}

	@Override
	public Void visit(Indexing e, Void param) {
		e.accept(acg, null);
		cg.load(e.getType());
		return null;
	}

	@Override
	public Void visit(RecordAccesor e, Void param) {
		e.accept(acg, null);
		cg.load(e.getType());
		return null;
	}
}


