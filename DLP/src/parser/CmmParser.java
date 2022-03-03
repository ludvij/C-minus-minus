// Generated from E:/clase/TERCERO/DLP/DLP-2122/DLP/src/parser\Cmm.g4 by ANTLR 4.9.2
package parser;

    import ast.*;
    import ast.types.*;
    import ast.program.*;
    import ast.statements.*;
    import ast.definitions.*;
    import ast.expressions.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, COMMENT=38, 
		MULTI_LINE_COMMENT=39, ID=40, INT_CONSTANT=41, WHITE_SPACES=42, REAL_CONSTANT=43, 
		CHAR_CONSTANT=44;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_main = 2, RULE_procedure_definition = 3, 
		RULE_function_definition = 4, RULE_function_body = 5, RULE_variable_definition = 6, 
		RULE_parameters = 7, RULE_typed_param = 8, RULE_expression = 9, RULE_arguments = 10, 
		RULE_statement = 11, RULE_expression_list = 12, RULE_code_block = 13, 
		RULE_type = 14, RULE_record_fields = 15, RULE_return_type = 16, RULE_void_type = 17, 
		RULE_builtin_type = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "main", "procedure_definition", "function_definition", 
			"function_body", "variable_definition", "parameters", "typed_param", 
			"expression", "arguments", "statement", "expression_list", "code_block", 
			"type", "record_fields", "return_type", "void_type", "builtin_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'()'", "'{'", "'}'", "'('", "')'", "','", "';'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'>'", 
			"'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'read'", "'write'", 
			"'while'", "'if'", "'else'", "'='", "'return'", "'struct'", "'void'", 
			"'int'", "'char'", "'double'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "COMMENT", "MULTI_LINE_COMMENT", "ID", "INT_CONSTANT", "WHITE_SPACES", 
			"REAL_CONSTANT", "CHAR_CONSTANT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext d;
		public MainContext mf;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ProgramContext)_localctx).d = definitions();
			setState(39);
			((ProgramContext)_localctx).mf = main();
			 ((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).d.ast, ((ProgramContext)_localctx).mf.ast, 0, 0); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast;
		public Function_definitionContext fd;
		public Procedure_definitionContext pd;
		public Variable_definitionContext vd;
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public List<Procedure_definitionContext> procedure_definition() {
			return getRuleContexts(Procedure_definitionContext.class);
		}
		public Procedure_definitionContext procedure_definition(int i) {
			return getRuleContext(Procedure_definitionContext.class,i);
		}
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((DefinitionsContext)_localctx).ast =  new ArrayList<Definition>(); 
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(52);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(43);
						((DefinitionsContext)_localctx).fd = function_definition();
						 _localctx.ast.add(((DefinitionsContext)_localctx).fd.ast); 
						}
						break;
					case 2:
						{
						setState(46);
						((DefinitionsContext)_localctx).pd = procedure_definition();
						 _localctx.ast.add(((DefinitionsContext)_localctx).pd.ast); 
						}
						break;
					case 3:
						{
						setState(49);
						((DefinitionsContext)_localctx).vd = variable_definition();
						 _localctx.ast.addAll(((DefinitionsContext)_localctx).vd.ast); 
						}
						break;
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Void_typeContext vt;
		public Function_bodyContext fb;
		public Void_typeContext void_type() {
			return getRuleContext(Void_typeContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((MainContext)_localctx).vt = void_type();
			setState(58);
			match(T__0);
			setState(59);
			match(T__1);
			setState(60);
			match(T__2);
			setState(61);
			((MainContext)_localctx).fb = function_body();
			setState(62);
			match(T__3);
			 ((MainContext)_localctx).ast =  new FunctionDefinition(
			            "main",
			            new FunctionType(((MainContext)_localctx).vt.ast, new ArrayList<VariableDefinition>(), ((MainContext)_localctx).vt.ast.getColumn(), ((MainContext)_localctx).vt.ast.getLine()),
			            ((MainContext)_localctx).fb.ast,
			            ((MainContext)_localctx).vt.ast.getColumn(),
			            ((MainContext)_localctx).vt.ast.getLine()
			        ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Procedure_definitionContext extends ParserRuleContext {
		public Definition ast;
		public Return_typeContext rt;
		public Token ID;
		public Function_bodyContext fb;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Procedure_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_definition; }
	}

	public final Procedure_definitionContext procedure_definition() throws RecognitionException {
		Procedure_definitionContext _localctx = new Procedure_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_procedure_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((Procedure_definitionContext)_localctx).rt = return_type();
			setState(66);
			((Procedure_definitionContext)_localctx).ID = match(ID);
			setState(67);
			match(T__1);
			setState(68);
			match(T__2);
			setState(69);
			((Procedure_definitionContext)_localctx).fb = function_body();
			setState(70);
			match(T__3);
			 ((Procedure_definitionContext)_localctx).ast =  new FunctionDefinition(
			             (((Procedure_definitionContext)_localctx).ID!=null?((Procedure_definitionContext)_localctx).ID.getText():null),
			             new FunctionType(((Procedure_definitionContext)_localctx).rt.ast, new ArrayList<VariableDefinition>(), ((Procedure_definitionContext)_localctx).rt.ast.getColumn(), ((Procedure_definitionContext)_localctx).rt.ast.getLine()),
			             ((Procedure_definitionContext)_localctx).fb.ast,
			             ((Procedure_definitionContext)_localctx).rt.ast.getColumn(), ((Procedure_definitionContext)_localctx).rt.ast.getLine()
			         ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public Definition ast;
		public Return_typeContext rt;
		public Token ID;
		public ParametersContext tp;
		public Function_bodyContext fb;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((Function_definitionContext)_localctx).rt = return_type();
			setState(74);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(75);
			match(T__4);
			setState(76);
			((Function_definitionContext)_localctx).tp = parameters();
			setState(77);
			match(T__5);
			setState(78);
			match(T__2);
			setState(79);
			((Function_definitionContext)_localctx).fb = function_body();
			setState(80);
			match(T__3);
			 ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(
			             (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null),
			             new FunctionType(((Function_definitionContext)_localctx).rt.ast, ((Function_definitionContext)_localctx).tp.ast, ((Function_definitionContext)_localctx).rt.ast.getColumn(), ((Function_definitionContext)_localctx).rt.ast.getLine()),
			             ((Function_definitionContext)_localctx).fb.ast,
			             ((Function_definitionContext)_localctx).rt.ast.getColumn(), ((Function_definitionContext)_localctx).rt.ast.getLine()
			         ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_bodyContext extends ParserRuleContext {
		public List<Statement> ast;
		public Variable_definitionContext vd;
		public StatementContext s;
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Function_bodyContext)_localctx).ast =  new ArrayList<Statement>(); 
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) {
				{
				{
				setState(84);
				((Function_bodyContext)_localctx).vd = variable_definition();
				 _localctx.ast.addAll(((Function_bodyContext)_localctx).vd.ast); 
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(92);
				((Function_bodyContext)_localctx).s = statement();
				 _localctx.ast.add(((Function_bodyContext)_localctx).s.ast); 
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast;
		public TypeContext t;
		public Token i1;
		public Token i2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Variable_definitionContext)_localctx).ast =  new ArrayList<VariableDefinition>(); 
			setState(101);
			((Variable_definitionContext)_localctx).t = type(0);
			setState(102);
			((Variable_definitionContext)_localctx).i1 = match(ID);
			 _localctx.ast.add(new VariableDefinition((((Variable_definitionContext)_localctx).i1!=null?((Variable_definitionContext)_localctx).i1.getText():null), ((Variable_definitionContext)_localctx).t.ast, ((Variable_definitionContext)_localctx).t.ast.getColumn(), ((Variable_definitionContext)_localctx).t.ast.getLine())); 
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(104);
				match(T__6);
				setState(105);
				((Variable_definitionContext)_localctx).i2 = match(ID);
				 _localctx.ast.add( new VariableDefinition((((Variable_definitionContext)_localctx).i2!=null?((Variable_definitionContext)_localctx).i2.getText():null), ((Variable_definitionContext)_localctx).t.ast, ((Variable_definitionContext)_localctx).t.ast.getColumn(), ((Variable_definitionContext)_localctx).t.ast.getLine())); 
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<VariableDefinition> ast;
		public Typed_paramContext tp1;
		public Typed_paramContext tp2;
		public List<Typed_paramContext> typed_param() {
			return getRuleContexts(Typed_paramContext.class);
		}
		public Typed_paramContext typed_param(int i) {
			return getRuleContext(Typed_paramContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				((ParametersContext)_localctx).tp1 = typed_param();
				 ((ParametersContext)_localctx).ast =  new ArrayList<VariableDefinition>(); _localctx.ast.add(((ParametersContext)_localctx).tp1.ast);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(116);
					match(T__6);
					setState(117);
					((ParametersContext)_localctx).tp2 = typed_param();
					_localctx.ast.add(((ParametersContext)_localctx).tp2.ast); 
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				 ((ParametersContext)_localctx).ast =  new ArrayList<VariableDefinition>(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Typed_paramContext extends ParserRuleContext {
		public VariableDefinition ast;
		public TypeContext t;
		public Token ID;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Typed_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_param; }
	}

	public final Typed_paramContext typed_param() throws RecognitionException {
		Typed_paramContext _localctx = new Typed_paramContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typed_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((Typed_paramContext)_localctx).t = type(0);
			setState(129);
			((Typed_paramContext)_localctx).ID = match(ID);
			 ((Typed_paramContext)_localctx).ast =  new VariableDefinition((((Typed_paramContext)_localctx).ID!=null?((Typed_paramContext)_localctx).ID.getText():null), ((Typed_paramContext)_localctx).t.ast, ((Typed_paramContext)_localctx).t.ast.getColumn(), ((Typed_paramContext)_localctx).t.ast.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public Builtin_typeContext t1;
		public Token ID;
		public ArgumentsContext a;
		public Token il;
		public Token cl;
		public Token dl;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Builtin_typeContext builtin_type() {
			return getRuleContext(Builtin_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(133);
				match(T__4);
				setState(134);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(135);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 2:
				{
				setState(138);
				match(T__4);
				setState(139);
				((ExpressionContext)_localctx).t1 = builtin_type();
				setState(140);
				match(T__5);
				setState(141);
				((ExpressionContext)_localctx).e1 = expression(12);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).t1.ast, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).t1.ast.getColumn(), ((ExpressionContext)_localctx).t1.ast.getLine()); 
				}
				break;
			case 3:
				{
				setState(144);
				match(T__11);
				setState(145);
				((ExpressionContext)_localctx).e1 = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 4:
				{
				setState(148);
				match(T__12);
				setState(149);
				((ExpressionContext)_localctx).e1 = expression(10);
				 ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 5:
				{
				setState(152);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(153);
				match(T__4);
				setState(154);
				((ExpressionContext)_localctx).a = arguments();
				setState(155);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new FunctionInvocation((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).a.ast, ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getLine()); 
				}
				break;
			case 6:
				{
				setState(158);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getLine());
				}
				break;
			case 7:
				{
				setState(160);
				((ExpressionContext)_localctx).il = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(LexerHelper.lexemeToInt((((ExpressionContext)_localctx).il!=null?((ExpressionContext)_localctx).il.getText():null)), ((ExpressionContext)_localctx).il.getCharPositionInLine()+1, ((ExpressionContext)_localctx).il.getLine());
				}
				break;
			case 8:
				{
				setState(162);
				((ExpressionContext)_localctx).cl = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(LexerHelper.lexemeToChar((((ExpressionContext)_localctx).cl!=null?((ExpressionContext)_localctx).cl.getText():null)), ((ExpressionContext)_localctx).cl.getCharPositionInLine()+1, ((ExpressionContext)_localctx).cl.getLine());
				}
				break;
			case 9:
				{
				setState(164);
				((ExpressionContext)_localctx).dl = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(LexerHelper.lexemeToReal((((ExpressionContext)_localctx).dl!=null?((ExpressionContext)_localctx).dl.getText():null)), ((ExpressionContext)_localctx).dl.getCharPositionInLine()+1, ((ExpressionContext)_localctx).dl.getLine());
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(169);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),  ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(174);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__16) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),  ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(179);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(180);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ComparisonOperation((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),  ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(184);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new LogicalOperation((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),  ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(189);
						match(T__8);
						setState(190);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(191);
						match(T__9);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(195);
						match(T__10);
						setState(196);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new RecordAccesor(((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arguments);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__11:
			case T__12:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((ArgumentsContext)_localctx).e1 = expression(0);
				((ArgumentsContext)_localctx).ast =  new ArrayList<Expression>(); _localctx.ast.add(((ArgumentsContext)_localctx).e1.ast);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(205);
					match(T__6);
					setState(206);
					((ArgumentsContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).e2.ast);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				 ((ArgumentsContext)_localctx).ast =  new ArrayList<Expression>(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public Expression_listContext el;
		public ExpressionContext e1;
		public Code_blockContext cb;
		public Code_blockContext cb1;
		public Code_blockContext cb2;
		public ExpressionContext e2;
		public Token ID;
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<Code_blockContext> code_block() {
			return getRuleContexts(Code_blockContext.class);
		}
		public Code_blockContext code_block(int i) {
			return getRuleContext(Code_blockContext.class,i);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(T__25);
				setState(218);
				((StatementContext)_localctx).el = expression_list();
				setState(219);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new ReadStatement(((StatementContext)_localctx).el.ast, ((StatementContext)_localctx).el.ast.get(0).getColumn(), ((StatementContext)_localctx).el.ast.get(0).getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__26);
				setState(223);
				((StatementContext)_localctx).el = expression_list();
				setState(224);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new WriteStatement(((StatementContext)_localctx).el.ast, ((StatementContext)_localctx).el.ast.get(0).getColumn(), ((StatementContext)_localctx).el.ast.get(0).getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(T__27);
				setState(228);
				match(T__4);
				setState(229);
				((StatementContext)_localctx).e1 = expression(0);
				setState(230);
				match(T__5);
				setState(231);
				((StatementContext)_localctx).cb = code_block();
				 ((StatementContext)_localctx).ast =  new WhileStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
				match(T__28);
				setState(235);
				match(T__4);
				setState(236);
				((StatementContext)_localctx).e1 = expression(0);
				setState(237);
				match(T__5);
				setState(238);
				((StatementContext)_localctx).cb = code_block();
				 ((StatementContext)_localctx).ast =  new IfStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				match(T__28);
				setState(242);
				match(T__4);
				setState(243);
				((StatementContext)_localctx).e1 = expression(0);
				setState(244);
				match(T__5);
				setState(245);
				((StatementContext)_localctx).cb1 = code_block();
				setState(246);
				match(T__29);
				setState(247);
				((StatementContext)_localctx).cb2 = code_block();
				 ((StatementContext)_localctx).ast =  new IfStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb1.ast, ((StatementContext)_localctx).cb2.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				((StatementContext)_localctx).e1 = expression(0);
				setState(251);
				match(T__30);
				setState(252);
				((StatementContext)_localctx).e2 = expression(0);
				setState(253);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new AssignmentStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(256);
				match(T__31);
				setState(257);
				((StatementContext)_localctx).e1 = expression(0);
				setState(258);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new ReturnStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				((StatementContext)_localctx).ID = match(ID);
				setState(262);
				match(T__4);
				setState(263);
				((StatementContext)_localctx).el = expression_list();
				setState(264);
				match(T__5);
				setState(265);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new FunctionInvocation((((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null), ((StatementContext)_localctx).el.ast, ((StatementContext)_localctx).ID.getCharPositionInLine()+1, ((StatementContext)_localctx).ID.getLine());
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(268);
				((StatementContext)_localctx).ID = match(ID);
				setState(272);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(269);
					match(T__1);
					}
					break;
				case T__4:
					{
					setState(270);
					match(T__4);
					setState(271);
					match(T__5);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(274);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new ProcedureInvocation((((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null), ((StatementContext)_localctx).ID.getCharPositionInLine()+1, ((StatementContext)_localctx).ID.getLine()); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression_listContext extends ParserRuleContext {
		public List<Expression> ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Expression_listContext)_localctx).ast =  new ArrayList(); 
			setState(279);
			((Expression_listContext)_localctx).e1 = expression(0);
			 _localctx.ast.add(((Expression_listContext)_localctx).e1.ast); 
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(281);
				match(T__6);
				setState(282);
				((Expression_listContext)_localctx).e2 = expression(0);
				 _localctx.ast.add( ((Expression_listContext)_localctx).e2.ast); 
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Code_blockContext extends ParserRuleContext {
		public List<Statement> ast;
		public StatementContext e1;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_code_block);
		int _la;
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__11:
			case T__12:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				 ((Code_blockContext)_localctx).ast =  new ArrayList<Statement>(); 
				setState(291);
				((Code_blockContext)_localctx).e1 = statement();
				_localctx.ast.add(((Code_blockContext)_localctx).e1.ast); 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				 ((Code_blockContext)_localctx).ast =  new ArrayList<Statement>(); 
				setState(295);
				match(T__2);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(296);
					((Code_blockContext)_localctx).e1 = statement();
					 _localctx.ast.add(((Code_blockContext)_localctx).e1.ast); 
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(304);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t;
		public Return_typeContext rt;
		public Record_fieldsContext rf;
		public Token il;
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Record_fieldsContext record_fields() {
			return getRuleContext(Record_fieldsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
			case T__36:
				{
				setState(308);
				((TypeContext)_localctx).rt = return_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).rt.ast; 
				}
				break;
			case T__32:
				{
				setState(311);
				match(T__32);
				setState(312);
				match(T__2);
				setState(313);
				((TypeContext)_localctx).rf = record_fields();
				setState(314);
				match(T__3);
				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).rf.ast, ((TypeContext)_localctx).rf.ast.get(0).getColumn(), ((TypeContext)_localctx).rf.ast.get(0).getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(319);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(320);
					match(T__8);
					setState(321);
					((TypeContext)_localctx).il = match(INT_CONSTANT);
					setState(322);
					match(T__9);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).il!=null?((TypeContext)_localctx).il.getText():null)), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast.getLine());
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Record_fieldsContext extends ParserRuleContext {
		public List<RecordField> ast;
		public TypeContext t;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Record_fieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_fields; }
	}

	public final Record_fieldsContext record_fields() throws RecognitionException {
		Record_fieldsContext _localctx = new Record_fieldsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_record_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Record_fieldsContext)_localctx).ast =  new ArrayList<RecordField>(); 
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(330);
				((Record_fieldsContext)_localctx).t = type(0);
				setState(331);
				((Record_fieldsContext)_localctx).ID = match(ID);
				setState(332);
				match(T__7);
				 _localctx.ast.add(new RecordField(((Record_fieldsContext)_localctx).t.ast, (((Record_fieldsContext)_localctx).ID!=null?((Record_fieldsContext)_localctx).ID.getText():null), ((Record_fieldsContext)_localctx).t.ast.getColumn(), ((Record_fieldsContext)_localctx).t.ast.getLine())); 
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public Type ast;
		public Void_typeContext t;
		public Builtin_typeContext bt;
		public Void_typeContext void_type() {
			return getRuleContext(Void_typeContext.class,0);
		}
		public Builtin_typeContext builtin_type() {
			return getRuleContext(Builtin_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_return_type);
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				((Return_typeContext)_localctx).t = void_type();
				 ((Return_typeContext)_localctx).ast =  ((Return_typeContext)_localctx).t.ast; 
				}
				break;
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				((Return_typeContext)_localctx).bt = builtin_type();
				 ((Return_typeContext)_localctx).ast =  ((Return_typeContext)_localctx).bt.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Void_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public Void_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void_type; }
	}

	public final Void_typeContext void_type() throws RecognitionException {
		Void_typeContext _localctx = new Void_typeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_void_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			((Void_typeContext)_localctx).t = match(T__33);
			 ((Void_typeContext)_localctx).ast =  new VoidType(((Void_typeContext)_localctx).t.getCharPositionInLine()+1, ((Void_typeContext)_localctx).t.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_typeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public Builtin_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_type; }
	}

	public final Builtin_typeContext builtin_type() throws RecognitionException {
		Builtin_typeContext _localctx = new Builtin_typeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_builtin_type);
		try {
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				((Builtin_typeContext)_localctx).t = match(T__34);
				 ((Builtin_typeContext)_localctx).ast =  new IntType(((Builtin_typeContext)_localctx).t.getCharPositionInLine()+1, ((Builtin_typeContext)_localctx).t.getLine()); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				((Builtin_typeContext)_localctx).t = match(T__35);
				 ((Builtin_typeContext)_localctx).ast =  new CharType(((Builtin_typeContext)_localctx).t.getCharPositionInLine()+1, ((Builtin_typeContext)_localctx).t.getLine()); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 3);
				{
				setState(354);
				((Builtin_typeContext)_localctx).t = match(T__36);
				 ((Builtin_typeContext)_localctx).ast =  new DoubleType(((Builtin_typeContext)_localctx).t.getCharPositionInLine()+1, ((Builtin_typeContext)_localctx).t.getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0169\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\3\t\5\t\u0081\n\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a9\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00c9"+
		"\n\13\f\13\16\13\u00cc\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d4\n\f\f\f"+
		"\16\f\u00d7\13\f\3\f\5\f\u00da\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0113\n\r\3\r\3\r\5\r"+
		"\u0117\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0120\n\16\f\16\16"+
		"\16\u0123\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u012e"+
		"\n\17\f\17\16\17\u0131\13\17\3\17\5\17\u0134\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0140\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u0147\n\20\f\20\16\20\u014a\13\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\6\21\u0152\n\21\r\21\16\21\u0153\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u015c"+
		"\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0167\n\24\3\24"+
		"\2\4\24\36\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\6\3\2\20\22"+
		"\4\2\16\16\23\23\3\2\24\31\3\2\32\33\2\u017f\2(\3\2\2\2\4,\3\2\2\2\6;"+
		"\3\2\2\2\bC\3\2\2\2\nK\3\2\2\2\fU\3\2\2\2\16f\3\2\2\2\20\u0080\3\2\2\2"+
		"\22\u0082\3\2\2\2\24\u00a8\3\2\2\2\26\u00d9\3\2\2\2\30\u0116\3\2\2\2\32"+
		"\u0118\3\2\2\2\34\u0133\3\2\2\2\36\u013f\3\2\2\2 \u014b\3\2\2\2\"\u015b"+
		"\3\2\2\2$\u015d\3\2\2\2&\u0166\3\2\2\2()\5\4\3\2)*\5\6\4\2*+\b\2\1\2+"+
		"\3\3\2\2\2,8\b\3\1\2-.\5\n\6\2./\b\3\1\2/\67\3\2\2\2\60\61\5\b\5\2\61"+
		"\62\b\3\1\2\62\67\3\2\2\2\63\64\5\16\b\2\64\65\b\3\1\2\65\67\3\2\2\2\66"+
		"-\3\2\2\2\66\60\3\2\2\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29\5\3\2\2\2:8\3\2\2\2;<\5$\23\2<=\7\3\2\2=>\7\4\2\2>?\7\5\2\2?@\5\f"+
		"\7\2@A\7\6\2\2AB\b\4\1\2B\7\3\2\2\2CD\5\"\22\2DE\7*\2\2EF\7\4\2\2FG\7"+
		"\5\2\2GH\5\f\7\2HI\7\6\2\2IJ\b\5\1\2J\t\3\2\2\2KL\5\"\22\2LM\7*\2\2MN"+
		"\7\7\2\2NO\5\20\t\2OP\7\b\2\2PQ\7\5\2\2QR\5\f\7\2RS\7\6\2\2ST\b\6\1\2"+
		"T\13\3\2\2\2U[\b\7\1\2VW\5\16\b\2WX\b\7\1\2XZ\3\2\2\2YV\3\2\2\2Z]\3\2"+
		"\2\2[Y\3\2\2\2[\\\3\2\2\2\\c\3\2\2\2][\3\2\2\2^_\5\30\r\2_`\b\7\1\2`b"+
		"\3\2\2\2a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\r\3\2\2\2ec\3\2\2\2"+
		"fg\b\b\1\2gh\5\36\20\2hi\7*\2\2io\b\b\1\2jk\7\t\2\2kl\7*\2\2ln\b\b\1\2"+
		"mj\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\n\2\2"+
		"s\17\3\2\2\2tu\5\22\n\2u|\b\t\1\2vw\7\t\2\2wx\5\22\n\2xy\b\t\1\2y{\3\2"+
		"\2\2zv\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0081\3\2\2\2~|\3\2\2\2"+
		"\177\u0081\b\t\1\2\u0080t\3\2\2\2\u0080\177\3\2\2\2\u0081\21\3\2\2\2\u0082"+
		"\u0083\5\36\20\2\u0083\u0084\7*\2\2\u0084\u0085\b\n\1\2\u0085\23\3\2\2"+
		"\2\u0086\u0087\b\13\1\2\u0087\u0088\7\7\2\2\u0088\u0089\5\24\13\2\u0089"+
		"\u008a\7\b\2\2\u008a\u008b\b\13\1\2\u008b\u00a9\3\2\2\2\u008c\u008d\7"+
		"\7\2\2\u008d\u008e\5&\24\2\u008e\u008f\7\b\2\2\u008f\u0090\5\24\13\16"+
		"\u0090\u0091\b\13\1\2\u0091\u00a9\3\2\2\2\u0092\u0093\7\16\2\2\u0093\u0094"+
		"\5\24\13\r\u0094\u0095\b\13\1\2\u0095\u00a9\3\2\2\2\u0096\u0097\7\17\2"+
		"\2\u0097\u0098\5\24\13\f\u0098\u0099\b\13\1\2\u0099\u00a9\3\2\2\2\u009a"+
		"\u009b\7*\2\2\u009b\u009c\7\7\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7\b"+
		"\2\2\u009e\u009f\b\13\1\2\u009f\u00a9\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1"+
		"\u00a9\b\13\1\2\u00a2\u00a3\7+\2\2\u00a3\u00a9\b\13\1\2\u00a4\u00a5\7"+
		".\2\2\u00a5\u00a9\b\13\1\2\u00a6\u00a7\7-\2\2\u00a7\u00a9\b\13\1\2\u00a8"+
		"\u0086\3\2\2\2\u00a8\u008c\3\2\2\2\u00a8\u0092\3\2\2\2\u00a8\u0096\3\2"+
		"\2\2\u00a8\u009a\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ca\3\2\2\2\u00aa\u00ab\f\13"+
		"\2\2\u00ab\u00ac\t\2\2\2\u00ac\u00ad\5\24\13\f\u00ad\u00ae\b\13\1\2\u00ae"+
		"\u00c9\3\2\2\2\u00af\u00b0\f\n\2\2\u00b0\u00b1\t\3\2\2\u00b1\u00b2\5\24"+
		"\13\13\u00b2\u00b3\b\13\1\2\u00b3\u00c9\3\2\2\2\u00b4\u00b5\f\t\2\2\u00b5"+
		"\u00b6\t\4\2\2\u00b6\u00b7\5\24\13\n\u00b7\u00b8\b\13\1\2\u00b8\u00c9"+
		"\3\2\2\2\u00b9\u00ba\f\b\2\2\u00ba\u00bb\t\5\2\2\u00bb\u00bc\5\24\13\t"+
		"\u00bc\u00bd\b\13\1\2\u00bd\u00c9\3\2\2\2\u00be\u00bf\f\20\2\2\u00bf\u00c0"+
		"\7\13\2\2\u00c0\u00c1\5\24\13\2\u00c1\u00c2\7\f\2\2\u00c2\u00c3\b\13\1"+
		"\2\u00c3\u00c9\3\2\2\2\u00c4\u00c5\f\17\2\2\u00c5\u00c6\7\r\2\2\u00c6"+
		"\u00c7\7*\2\2\u00c7\u00c9\b\13\1\2\u00c8\u00aa\3\2\2\2\u00c8\u00af\3\2"+
		"\2\2\u00c8\u00b4\3\2\2\2\u00c8\u00b9\3\2\2\2\u00c8\u00be\3\2\2\2\u00c8"+
		"\u00c4\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\25\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\5\24\13\2\u00ce"+
		"\u00d5\b\f\1\2\u00cf\u00d0\7\t\2\2\u00d0\u00d1\5\24\13\2\u00d1\u00d2\b"+
		"\f\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d8\u00da\b\f\1\2\u00d9\u00cd\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\27\3\2\2\2\u00db\u00dc\7\34\2\2\u00dc\u00dd\5\32\16\2\u00dd\u00de\7\n"+
		"\2\2\u00de\u00df\b\r\1\2\u00df\u0117\3\2\2\2\u00e0\u00e1\7\35\2\2\u00e1"+
		"\u00e2\5\32\16\2\u00e2\u00e3\7\n\2\2\u00e3\u00e4\b\r\1\2\u00e4\u0117\3"+
		"\2\2\2\u00e5\u00e6\7\36\2\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\5\24\13\2"+
		"\u00e8\u00e9\7\b\2\2\u00e9\u00ea\5\34\17\2\u00ea\u00eb\b\r\1\2\u00eb\u0117"+
		"\3\2\2\2\u00ec\u00ed\7\37\2\2\u00ed\u00ee\7\7\2\2\u00ee\u00ef\5\24\13"+
		"\2\u00ef\u00f0\7\b\2\2\u00f0\u00f1\5\34\17\2\u00f1\u00f2\b\r\1\2\u00f2"+
		"\u0117\3\2\2\2\u00f3\u00f4\7\37\2\2\u00f4\u00f5\7\7\2\2\u00f5\u00f6\5"+
		"\24\13\2\u00f6\u00f7\7\b\2\2\u00f7\u00f8\5\34\17\2\u00f8\u00f9\7 \2\2"+
		"\u00f9\u00fa\5\34\17\2\u00fa\u00fb\b\r\1\2\u00fb\u0117\3\2\2\2\u00fc\u00fd"+
		"\5\24\13\2\u00fd\u00fe\7!\2\2\u00fe\u00ff\5\24\13\2\u00ff\u0100\7\n\2"+
		"\2\u0100\u0101\b\r\1\2\u0101\u0117\3\2\2\2\u0102\u0103\7\"\2\2\u0103\u0104"+
		"\5\24\13\2\u0104\u0105\7\n\2\2\u0105\u0106\b\r\1\2\u0106\u0117\3\2\2\2"+
		"\u0107\u0108\7*\2\2\u0108\u0109\7\7\2\2\u0109\u010a\5\32\16\2\u010a\u010b"+
		"\7\b\2\2\u010b\u010c\7\n\2\2\u010c\u010d\b\r\1\2\u010d\u0117\3\2\2\2\u010e"+
		"\u0112\7*\2\2\u010f\u0113\7\4\2\2\u0110\u0111\7\7\2\2\u0111\u0113\7\b"+
		"\2\2\u0112\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\7\n\2\2\u0115\u0117\b\r\1\2\u0116\u00db\3\2\2\2\u0116\u00e0\3\2"+
		"\2\2\u0116\u00e5\3\2\2\2\u0116\u00ec\3\2\2\2\u0116\u00f3\3\2\2\2\u0116"+
		"\u00fc\3\2\2\2\u0116\u0102\3\2\2\2\u0116\u0107\3\2\2\2\u0116\u010e\3\2"+
		"\2\2\u0117\31\3\2\2\2\u0118\u0119\b\16\1\2\u0119\u011a\5\24\13\2\u011a"+
		"\u0121\b\16\1\2\u011b\u011c\7\t\2\2\u011c\u011d\5\24\13\2\u011d\u011e"+
		"\b\16\1\2\u011e\u0120\3\2\2\2\u011f\u011b\3\2\2\2\u0120\u0123\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\33\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0124\u0125\b\17\1\2\u0125\u0126\5\30\r\2\u0126\u0127\b\17\1"+
		"\2\u0127\u0134\3\2\2\2\u0128\u0129\b\17\1\2\u0129\u012f\7\5\2\2\u012a"+
		"\u012b\5\30\r\2\u012b\u012c\b\17\1\2\u012c\u012e\3\2\2\2\u012d\u012a\3"+
		"\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0134\7\6\2\2\u0133\u0124\3\2"+
		"\2\2\u0133\u0128\3\2\2\2\u0134\35\3\2\2\2\u0135\u0136\b\20\1\2\u0136\u0137"+
		"\5\"\22\2\u0137\u0138\b\20\1\2\u0138\u0140\3\2\2\2\u0139\u013a\7#\2\2"+
		"\u013a\u013b\7\5\2\2\u013b\u013c\5 \21\2\u013c\u013d\7\6\2\2\u013d\u013e"+
		"\b\20\1\2\u013e\u0140\3\2\2\2\u013f\u0135\3\2\2\2\u013f\u0139\3\2\2\2"+
		"\u0140\u0148\3\2\2\2\u0141\u0142\f\4\2\2\u0142\u0143\7\13\2\2\u0143\u0144"+
		"\7+\2\2\u0144\u0145\7\f\2\2\u0145\u0147\b\20\1\2\u0146\u0141\3\2\2\2\u0147"+
		"\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\37\3\2\2"+
		"\2\u014a\u0148\3\2\2\2\u014b\u0151\b\21\1\2\u014c\u014d\5\36\20\2\u014d"+
		"\u014e\7*\2\2\u014e\u014f\7\n\2\2\u014f\u0150\b\21\1\2\u0150\u0152\3\2"+
		"\2\2\u0151\u014c\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154!\3\2\2\2\u0155\u0156\5$\23\2\u0156\u0157\b\22\1\2"+
		"\u0157\u015c\3\2\2\2\u0158\u0159\5&\24\2\u0159\u015a\b\22\1\2\u015a\u015c"+
		"\3\2\2\2\u015b\u0155\3\2\2\2\u015b\u0158\3\2\2\2\u015c#\3\2\2\2\u015d"+
		"\u015e\7$\2\2\u015e\u015f\b\23\1\2\u015f%\3\2\2\2\u0160\u0161\7%\2\2\u0161"+
		"\u0167\b\24\1\2\u0162\u0163\7&\2\2\u0163\u0167\b\24\1\2\u0164\u0165\7"+
		"\'\2\2\u0165\u0167\b\24\1\2\u0166\u0160\3\2\2\2\u0166\u0162\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0167\'\3\2\2\2\30\668[co|\u0080\u00a8\u00c8\u00ca\u00d5"+
		"\u00d9\u0112\u0116\u0121\u012f\u0133\u013f\u0148\u0153\u015b\u0166";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}