package visitor.semantic;

import ast.Statement;
import ast.Type;
import ast.definitions.FunctionDefinition;
import ast.types.error.ErrorType;
import visitor.AbstractVisitor;

import ast.Expression;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    @Override
    public Void visit(FunctionDefinition e, Type param) {
        e.getType().accept(this, param);

        for (Statement stmt : e.getBody()) {
            stmt.accept(this, e.getType().getType());
        }
        return null;
    }

    @Override
    public Void visit(ArithmeticOperation e, Type param) {
        e.getExpressionLeft().accept(this, param);
        e.getExpressionRight().accept(this, param);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().arithmetic(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(ComparisonOperation e, Type param) {
        e.getExpressionLeft().accept(this, param);
        e.getExpressionRight().accept(this, param);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().comparison(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(FunctionInvocation e, Type param) {
        e.getName().accept(this, param);
        for (Expression expr : e.getParameters()) {
            expr.accept(this, param);
        }
        List<Type> params = e.getParameters().stream().map(Expression::getType).toList();

        e.setLvalue(false);

        e.setType(e.getName().getDefinition().getType().parenthesis(params, e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(LogicalOperation e, Type param) {
        e.getExpressionLeft().accept(this, param);
        e.getExpressionRight().accept(this, param);

        e.setLvalue(false);

        e.setType(e.getExpressionLeft().getType().logical(e.getExpressionRight().getType(), e.getLine(), e.getColumn()));
        return null;
    }


    @Override
    public Void visit(RecordAccesor e, Type param) {
        e.getExpression().accept(this, param);

        e.setLvalue(true);

        e.setType(e.getExpression().getType().dot(e.getRecord(), e.getLine(), e.getColumn()));
        return null;
    }


    @Override
    public Void visit(UnaryMinus e, Type param) {
        e.getExpression().accept(this, param);

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral e, Type param) {
        e.setLvalue(false);

        e.setType(DoubleType.get());
        return null;
    }
    @Override
    public Void visit(CharLiteral e, Type param) {
        e.setLvalue(false);

        e.setType(CharType.get());
        return null;
    }
    @Override
    public Void visit(IntLiteral e, Type param) {
        e.setLvalue(false);

        e.setType(IntType.get());
        return null;
    }

    @Override
    public Void visit(Indexing e, Type param) {
        e.getExpressionLeft().accept(this, param);
        e.getExpressionRight().accept(this, param);

        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Negation e, Type param) {
        e.getExpression().accept(this, param);

        e.setLvalue(false);

        e.setType(e.getExpression().getType().negation(e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(Variable e, Type param) {
        e.setLvalue(true);
        e.setType(e.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(Cast e, Type param) {
        e.getCastType().accept(this, param);
        e.getExpression().accept(this, param);

        e.setLvalue(false);

        e.setType(e.getType().castTo(e.getType(), e.getLine(), e.getColumn()));
        return null;
    }

    @Override
    public Void visit(AssignmentStatement e, Type param) {
        e.getLeftExpression().accept(this, param);
        e.getRightExpression().accept(this, param);
        if (!e.getLeftExpression().getLvalue()) {
            new ErrorType("Left expression in assignment must have l-value", e.getLine(), e.getColumn());
        }
        else if (e.getLeftExpression().getType() != e.getRightExpression().getType()) {
            new ErrorType("Expected: "+e.getLeftExpression().getType()
                    +", Given: " + e.getRightExpression().getType(), e.getLine(), e.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(ReadStatement e, Type param) {
        e.getExpression().accept(this, param);
        if (!e.getExpression().getLvalue()) {
            new ErrorType("expression must have an l-value", e.getLine(), e.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(WriteStatement e, Type param) {
        e.getExpression().accept(this, param);
        if (!e.getExpression().getType().isBuiltin()) {
            new ErrorType("Expected built-in type, Given: " + e.getExpression().getType() + " type", e.getLine(), e.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(RecordType e, Type param) {
        Set<String> duplicateChecker = new HashSet<>();
        for (RecordField rf : e.getRecordFields()) {
            if (!duplicateChecker.add(rf.getName())) {
                new ErrorType("Field <" + rf.getName() + "> is already defined in Record", rf.getLine(), rf.getColumn());
            }
        }
        return null;
    }

    @Override
    public Void visit(WhileStatement e, Type param) {
        e.getExpression().accept(this, param);
        e.getExpression().getType().asBoolean(e.getLine(), e.getColumn());
        for (Statement stmt : e.getBody()) {
            stmt.accept(this, param);
        }
        return null;
    }

    @Override
    public Void visit(IfStatement e, Type param) {
        e.getExpression().accept(this, param);
        e.getExpression().getType().asBoolean(e.getLine(), e.getColumn());

        e.getIfBody().forEach(stmt -> stmt.accept(this, param));
        if (e.getElseBody() != null) {
            e.getElseBody().forEach(stmt -> stmt.accept(this, param));
        }
        return null;
    }
    public Void visit(ReturnStatement e, Type param) {
        e.getExpression().accept(this, param);
        if (!e.getExpression().getType().isBuiltin()) {
            new ErrorType("Can't return type " + e.getExpression().getType(), e.getLine(), e.getColumn());
        }
        else if (param == VoidType.get()) {
            new ErrorType("Can't return type " + e.getExpression().getType() + " in void function", e.getLine(), e.getColumn());
        }
        else if (e.getExpression().getType() != param) {
            new ErrorType("Expected return type: " + param + ", Given: " + e.getExpression().getType(), e.getLine(), e.getColumn());
        }
        return null;
    }



}
