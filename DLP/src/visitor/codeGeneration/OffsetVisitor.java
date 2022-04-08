package visitor.codeGeneration;

import ast.Definition;
import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.program.Program;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import visitor.AbstractVisitor;
/*
AG
	// globals
	P: Program: program -> definition*
	R:
	int globalBytesSum = 0;
	for (Definition def : definition*) {
		if (def instanceOf VariableDefinition vd) {
			vd.offset = globalBytesSum;
			globalBytesSum += vd.getType().getNumberOfBytes();
		}
	}

	// locals
	P: FunctionDefinition: definition -> type ID statement*
	R:
	int localBytesSum = 0;
	for(Statement stmt : statement*) {
		if (stmt instanceOf VariableDefinition vd) {
			localBytesSum += vd.getType().getNumberOfBytes();
			vd.offset = -localBytesSum;
		}
	}

	P: VariableDefinition: definition -> type ID
	R:

	// parameters
	P: FunctionType: type -> type vardefinition*
	R:
	int paramsBytesSum = 0;
	for(int i = vardefinition*.size() -1; i >= 0; i--){
		VarDefinition vd = vardefinition*.get(i);
		vd.offset = 4 + paramsBytesSum;
		paramsBytesSum += vd.type.getNumberOfBytes();
	}

	// recordFields
	P: RecordType: type -> recordfield*
	R:
	int recordFieldsBytesSum = 0;
	for (RecordField rf : recordfield*) {
		rf.offset = recordFieldsBytesSum;
		recordFieldsBytesSum += rf.getType().getNumberOFBytes();
	}

 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

	// globals
	@Override
	public Void visit(Program e, Void param) {
		int globalBytesSum = 0;
		for (Definition def : e.getDefinitions()) {
			if (def instanceof VariableDefinition vd) {
				vd.setOffset(globalBytesSum);
				globalBytesSum += vd.getType().numberOfBytes();
			}
		}
		return super.visit(e, param);
	}

	// locals
	@Override
	public Void visit(FunctionDefinition e, Void param) {
		int localBytesSum = 0;
		for(Statement stmt : e.getBody()) {
			if (stmt instanceof VariableDefinition vd) {
				localBytesSum += vd.getType().numberOfBytes();
				vd.setOffset(-localBytesSum);
			}
		}
		return super.visit(e, param);
	}
	// params
	@Override
	public Void visit(FunctionType e, Void param) {
		int paramsBytesSum = 0;
		for(int i = e.getParameters().size() -1; i >= 0; i--){
			VariableDefinition vd = e.getParameters().get(i);
			vd.setOffset(4 + paramsBytesSum);
			paramsBytesSum += vd.getType().numberOfBytes();
		}
		return super.visit(e, param);
	}

	// recordFields
	@Override
	public Void visit(RecordType e, Void param) {
		int recordFieldsBytesSum = 0;
		for (RecordField rf : e.getRecordFields()) {
			rf.setOffset(recordFieldsBytesSum);
			recordFieldsBytesSum += rf.getType().numberOfBytes();
		}
		return super.visit(e, param);
	}
}
