package ast.types.error;

import ast.Definition;

public class RepeatedDefinitionErrorType extends ErrorType {

	public RepeatedDefinitionErrorType(String message, Definition def, int line, int column) {
		super(message + " already defined in [" + def.getLine() + ", " + def.getColumn() + "]", line, column);
	}



}
