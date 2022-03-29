import ast.program.Program;
import errorHandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import parser.*;

import org.antlr.v4.runtime.*;
import visitor.semantic.IdentificationVisitor;
import visitor.semantic.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);	
//		parser.program();
		Program ast = parser.program().ast;
		new IdentificationVisitor().visit(ast, null);
		new TypeCheckingVisitor().visit(ast, null);
//		ast.accept(new IdentificationVisitor(), null);
//		ast.accept(new TypeCheckingVisitor(), null);


		if (ErrorHandler.get().anyErrors()) {
			ErrorHandler.get().showErrors(System.err);
		} else {
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
		}
	}

	/*
	P: Arithmetic: expression1 -> expression2 expression3
	R: expression1.type = expression2.type.squareBrackets(expression3.type);

	P: Indexing: expression1 -> expression2 expression3
	R: expression1.type = expression.type.squareBrackets(expression3.type)

	P: FuncInvocation: expression1 -> expression2 expression3*
	R: List<Type> argTypes = expression3*.stream()
		.map(x -> x.type).toList()
	expression1.type = expression2.type.parenthesis(argTypes)

	P: WhileStmt: statement1 -> expression statement2*
	R: expression.type.asBoolean()

	P: Cast: expression1 -> type expression2
	R: expression1.type = expression2.type.castTo(type)

	P: Comparison: expression1 -> expression2 expression3
	R: expression1.type = expression2.type.squareBrackets(expression3.type)

	P: Logical: expression1 -> expression2 expression2
	R: expression1.type = expression2.type.squareBrackets(expression2.type)

	P: Negation: expression1 -> expression2
	R: expression1.type = expression2.type

	P: UnaryMinus: expression1 -> expression2
	R: expression1.type = expression2.type

	P: CharLitera: expression -> char
	R: expression.type = char

	P: intLiteral: expression -> int
	R: expression.type = int

	P: DoubleLiteral: expression -> double
	R: expression.type = double

	 */

}
