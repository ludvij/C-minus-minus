package visitor.codeGeneration;

import ast.definitions.VariableDefinition;
import ast.expressions.Indexing;
import ast.expressions.RecordAccesor;
import ast.expressions.Variable;
import visitor.codeGeneration.cg.CodeGenerator;

/**
 * Address
 * Variables:
 *
 * address[[Variable: expression -> ID]] =
 *
 * if (expression.definition.scope == 0) {
 * 	<pusha> expression.definition.offset
 * } else {
 * 	<push bp>
 * 	<pushi> expression.definition.offset
 * 	<addi>
 * }
 */
public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

	private final CodeGenerator cg;

	private ValueCGVisitor vcg;

	public AddressCGVisitor(CodeGenerator cg) {
		this.cg = cg;
	}

	public void setVcg(ValueCGVisitor vcg) {
		this.vcg = vcg;
	}

	@Override
	public Void visit(Variable e, Void param) {
		if (e.getDefinition() instanceof VariableDefinition vd)
			cg.pushAddress(vd);

		return null;
	}

	@Override
	public Void visit(RecordAccesor e, Void param) {
		e.getExpression().accept(this, null);
		cg.recordAccessorAddress(e);
		return null;
	}

	@Override
	public Void visit(Indexing e, Void param) {
		e.getExpressionLeft().accept(this, null);
		e.getExpressionRight().accept(vcg, null);
		cg.indexingAddress(e);
		return null;
	}
}
