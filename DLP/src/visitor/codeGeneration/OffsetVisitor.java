package visitor.codeGeneration;

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

}
