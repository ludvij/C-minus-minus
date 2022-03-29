package visitor.semantic;

import ast.Type;
import visitor.AbstractVisitor;

import ast.Expression;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.List;

/*

    // Definitions

    P: FuncDefinition: definition -> type ID statement*
    R: for (Statement st: statement*) {
           st.returnType = type.returnType;
       }

    // Expression

	P: Arithmetic: expression1 -> expression2 expression3
	R: expression1.type = expression2.type.squareBrackets(expression3.type);

	P: Indexing: expression1 -> expression2 expression3
	R: expression1.type = expression.type.squareBrackets(expression3.type)

	P: FuncInvocation: expression1 -> expression2 expression3*
	R: List<Type> argTypes = expression3*.stream()
		.map(x -> x.type).toList()
	expression1.type = expression2.type.parenthesis(argTypes)


	P: Cast: expression1 -> type expression2
	R: expression1.type = expression2.type.castTo(type)

	P: Comparison: expression1 -> expression2 expression3
	R: expression1.type = expression2.type.squareBrackets(expression3.type)

	P: Logical: expression1 -> expression2 expression2
	R: expression1.type = expression2.type.squareBrackets(expression2.type)

	P: RecordAccessor: expression1 -> expression2
	R: expression1.type = expression2.type

	P: Negation: expression1 -> expression2
	R: expression1.type = expression2.type.negation()

	P: UnaryMinus: expression1 -> expression2
	R: expression1.type = expression2.type.minus()

	P: CharLitera: expression -> CHAR_CONSTANT
	R: expression.type = new CharType()

	P: intLiteral: expression -> INT_CONSTANT
	R: expression.type = new IntType()

	P: DoubleLiteral: expression -> REAL_CONSTANT
	R: expression.type = new RealType()

	P: Variable: expression -> ID
	R: expression.isDefined()
	   expression.type = expression.definition.type

    // Statements

	P: WhileStmt: statement1 -> expression statement2*
	R: expression.type.asBoolean()
	   for(Statement st: statement2*) {
	       st.returnType = statement1.returnType
	   }

	P: Assignment: statement -> expression1 expression2
	R: expression1.squareBrackets(expression2)

	P: IfStmt: statement1 -> expression1 statement2*
	R: expression1.asBoolean()
	   for (Statement st : statement2*) {
	       st.returnType = statement1.returnType;
	   }

	P: IfElseStmt: statement1 -> expression1 statement2* statement3*
	R: expression2.asBoolean()
	   for (Statement st : statement2*) {
	       st.returnType = statement1.returnType;
	   }
	   for (Statement st : statement3*) {
	       st.returnType = statement1.returnType;
	   }

	P: ReadStmt: statement -> expression
	R: expression1.type.isBuiltIn()

	P: WriteStmt: statement -> expression
	R: expression.type.isBuiltin()

	P: Return: statement -> expression
	R: statement.returnType.squareBrackets(expression.type)
	 */

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(ArithmeticOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().arithmetic(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(ComparisonOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().comparison(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(FunctionInvocation e, Void param) {
        e.getName().accept(this, null);
        for (Expression expr : e.getParameters()) {
            expr.accept(this, null);
        }
        List<Type> params = e.getParameters().stream().map(Expression::getType).toList();

        e.setLvalue(false);

        e.setType(e.getName().getDefinition().getType().parenthesis(params, e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(LogicalOperation e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().logical(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }


    @Override
    public Void visit(RecordAccesor e, Void param) {
        e.getExpression().accept(this, null);

        e.setLvalue(true);

        e.setType(e.getType().dot(e.getRecord(), e.getLine(), e.getColumn()));
        return null;
    }


    @Override
    public Void visit(UnaryMinus e, Void param) {
        e.getExpression().accept(this, null);

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral e, Void param) {
        e.setLvalue(false);

        e.setType(DoubleType.get());
        return null;
    }
    @Override
    public Void visit(CharLiteral e, Void param) {
        e.setLvalue(false);

        e.setType(CharType.get());
        return null;
    }
    @Override
    public Void visit(IntLiteral e, Void param) {
        e.setLvalue(false);

        e.setType(IntType.get());
        return null;
    }

    @Override
    public Void visit(Indexing e, Void param) {
        e.getExpressionLeft().accept(this, null);
        e.getExpressionRight().accept(this, null);

        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Negation e, Void param) {
        e.getExpression().accept(this, null);

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {
        e.setLvalue(true);
        e.setType(e.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {
        e.getCastType().accept(this, null);
        e.getExpression().accept(this, null);

        e.setLvalue(false);

        e.setType(e.getType().castTo(e.getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(AssignmentStatement e, Void param) {
        e.getLeftExpression().accept(this, null);
        e.getRightExpression().accept(this, null);
        if (!e.getLeftExpression().getLvalue()) {
            new ErrorType("Left expression in assignment must have l-value", e.getLine(), e.getColumn());
        }
        else if (e.getLeftExpression().getType() != e.getRightExpression().getType()) {
            new ErrorType("[Assignment]: Expected: "+e.getLeftExpression().getType()
                    +", Given: " + e.getRightExpression().getType(), e.getLine(), e.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(ReadStatement e, Void param) {
        e.getExpression().accept(this, null);
        if (!e.getExpression().getLvalue()) {
            new ErrorType("expression in read must have an l-value", e.getLine(), e.getColumn());
        }
        return null;
    }
}
