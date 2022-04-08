package visitor.semantic;

import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.types.ErrorType;
import visitor.AbstractVisitor;
import visitor.semantic.symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

	private final SymbolTable st = new SymbolTable();

	@Override
	public Void visit(FunctionDefinition e, Void param) {
		if (!st.insert(e)) {
			new ErrorType("Function <"+e.getName()+"> already defined",e.getLine(), e.getColumn());
		}
		st.set();
		e.getType().accept(this, param);
		for (Statement stmt : e.getBody()) {
			stmt.accept(this, param);
		}
		st.reset();
		return null;
	}

	@Override
	public Void visit(VariableDefinition e, Void param) {
		if (!st.insert(e)) {
			new ErrorType("Variable <"+e.getName()+"> already defined" ,e.getLine(), e.getColumn());
		}
		e.getType().accept(this, param);
		return null;
	}

	@Override
	public Void visit(Variable e, Void param) {
		e.setDefinition(st.find(e.getName()));
		if (e.getDefinition() == null) {
			new ErrorType("Variable <"+e.getName()+"> not found", e.getLine(), e.getColumn());
		}
		return null;
	}

}
