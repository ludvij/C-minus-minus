package visitor.codeGeneration;

import ast.definitions.VariableDefinition;
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

	public AddressCGVisitor(CodeGenerator cg) {
		this.cg = cg;
	}

	@Override
	public Void visit(Variable e, Void param) {
		if (e.getDefinition() instanceof VariableDefinition vd)
			cg.pushAddress(vd);

		return null;
	}
}
