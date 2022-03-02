// Generated from C:/Users/luisv/Desktop/clase/DLP/DLP-2122/DLP/src/parser\Cmm.g4 by ANTLR 4.9.2
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
		RULE_program = 0, RULE_main = 1, RULE_expression = 2, RULE_arguments = 3, 
		RULE_definition = 4, RULE_variable_def = 5, RULE_statement = 6, RULE_expression_list = 7, 
		RULE_code_block = 8, RULE_type = 9, RULE_record_fields = 10, RULE_return_type = 11, 
		RULE_builtin_type = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "expression", "arguments", "definition", "variable_def", 
			"statement", "expression_list", "code_block", "type", "record_fields", 
			"return_type", "builtin_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'()'", "'{'", "'}'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'>'", 
			"'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "','", "';'", "'read'", 
			"'write'", "'while'", "'if'", "'else'", "'='", "'return'", "'struct'", 
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
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					definition();
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(32);
			main();
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
		public List<Variable_defContext> variable_def() {
			return getRuleContexts(Variable_defContext.class);
		}
		public Variable_defContext variable_def(int i) {
			return getRuleContext(Variable_defContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			match(T__1);
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(36);
				match(T__2);
				setState(37);
				match(T__3);
				}
				break;
			case T__4:
				{
				setState(38);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(41);
			match(T__5);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) {
				{
				{
				setState(42);
				variable_def();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__32) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(48);
				statement();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__6);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(57);
				match(T__2);
				setState(58);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(59);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 2:
				{
				setState(62);
				match(T__10);
				setState(63);
				((ExpressionContext)_localctx).e1 = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 3:
				{
				setState(66);
				match(T__11);
				setState(67);
				((ExpressionContext)_localctx).e1 = expression(10);
				 ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 4:
				{
				setState(70);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(71);
				match(T__2);
				setState(72);
				((ExpressionContext)_localctx).a = arguments();
				setState(73);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  new FunctionInvocation((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).a.args, ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getLine()); 
				}
				break;
			case 5:
				{
				setState(76);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getLine());
				}
				break;
			case 6:
				{
				setState(78);
				((ExpressionContext)_localctx).il = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(LexerHelper.lexemeToInt((((ExpressionContext)_localctx).il!=null?((ExpressionContext)_localctx).il.getText():null)), ((ExpressionContext)_localctx).il.getCharPositionInLine()+1, ((ExpressionContext)_localctx).il.getLine());
				}
				break;
			case 7:
				{
				setState(80);
				((ExpressionContext)_localctx).cl = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(LexerHelper.lexemeToChar((((ExpressionContext)_localctx).cl!=null?((ExpressionContext)_localctx).cl.getText():null)), ((ExpressionContext)_localctx).cl.getCharPositionInLine()+1, ((ExpressionContext)_localctx).cl.getLine());
				}
				break;
			case 8:
				{
				setState(82);
				((ExpressionContext)_localctx).dl = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(LexerHelper.lexemeToReal((((ExpressionContext)_localctx).dl!=null?((ExpressionContext)_localctx).dl.getText():null)), ((ExpressionContext)_localctx).dl.getCharPositionInLine()+1, ((ExpressionContext)_localctx).dl.getLine());
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(87);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
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
						setState(91);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(92);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__15) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
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
						setState(96);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(97);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
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
						setState(101);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(102);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
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
						setState(106);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(107);
						match(T__7);
						setState(108);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(109);
						match(T__8);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(113);
						match(T__9);
						setState(114);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new RecordAccesor(((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast.getLine()); 
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public List<Expression> args;
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
		enterRule(_localctx, 6, RULE_arguments);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__2);
				setState(122);
				((ArgumentsContext)_localctx).e1 = expression(0);
				((ArgumentsContext)_localctx).args =  new ArrayList<Expression>();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(124);
					match(T__24);
					setState(125);
					((ArgumentsContext)_localctx).e2 = expression(0);
					 _localctx.args.add(((ArgumentsContext)_localctx).e2.ast);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(T__3);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				 ((ArgumentsContext)_localctx).args =  new ArrayList<Expression>(); 
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

	public static class DefinitionContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<Variable_defContext> variable_def() {
			return getRuleContexts(Variable_defContext.class);
		}
		public Variable_defContext variable_def(int i) {
			return getRuleContext(Variable_defContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definition);
		int _la;
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				return_type();
				setState(139);
				match(ID);
				setState(156);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case T__3:
					{
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(140);
						match(T__2);
						setState(141);
						type(0);
						setState(142);
						match(ID);
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__24) {
							{
							{
							setState(143);
							match(T__24);
							setState(144);
							type(0);
							setState(145);
							match(ID);
							}
							}
							setState(151);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(154);
					match(T__3);
					}
					break;
				case T__4:
					{
					setState(155);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(158);
				match(T__5);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) {
					{
					{
					setState(159);
					variable_def();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__32) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(165);
					statement();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				variable_def();
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

	public static class Variable_defContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Variable_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_def; }
	}

	public final Variable_defContext variable_def() throws RecognitionException {
		Variable_defContext _localctx = new Variable_defContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			type(0);
			setState(177);
			match(ID);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(178);
				match(T__24);
				setState(179);
				match(ID);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(T__25);
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
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(T__26);
				setState(188);
				((StatementContext)_localctx).el = expression_list();
				setState(189);
				match(T__25);
				 ((StatementContext)_localctx).ast =  new ReadStatement(((StatementContext)_localctx).el.args, ((StatementContext)_localctx).el.args.get(0).getColumn(), ((StatementContext)_localctx).el.args.get(0).getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(T__27);
				setState(193);
				((StatementContext)_localctx).el = expression_list();
				setState(194);
				match(T__25);
				 ((StatementContext)_localctx).ast =  new WriteStatement(((StatementContext)_localctx).el.args, ((StatementContext)_localctx).el.args.get(0).getColumn(), ((StatementContext)_localctx).el.args.get(0).getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(T__28);
				setState(198);
				match(T__2);
				setState(199);
				((StatementContext)_localctx).e1 = expression(0);
				setState(200);
				match(T__3);
				setState(201);
				((StatementContext)_localctx).cb = code_block();
				 ((StatementContext)_localctx).ast =  new WhileStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb.args, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(T__29);
				setState(205);
				match(T__2);
				setState(206);
				((StatementContext)_localctx).e1 = expression(0);
				setState(207);
				match(T__3);
				setState(208);
				((StatementContext)_localctx).cb = code_block();
				 ((StatementContext)_localctx).ast =  new IfStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb.args, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(211);
				match(T__29);
				setState(212);
				match(T__2);
				setState(213);
				((StatementContext)_localctx).e1 = expression(0);
				setState(214);
				match(T__3);
				setState(215);
				((StatementContext)_localctx).cb1 = code_block();
				setState(216);
				match(T__30);
				setState(217);
				((StatementContext)_localctx).cb2 = code_block();
				 ((StatementContext)_localctx).ast =  new IfStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).cb1.args, ((StatementContext)_localctx).cb2.args, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				((StatementContext)_localctx).e1 = expression(0);
				setState(221);
				match(T__31);
				setState(222);
				((StatementContext)_localctx).e2 = expression(0);
				setState(223);
				match(T__25);
				 ((StatementContext)_localctx).ast =  new AssignmentStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(226);
				match(T__32);
				setState(227);
				((StatementContext)_localctx).e1 = expression(0);
				setState(228);
				match(T__25);
				 ((StatementContext)_localctx).ast =  new ReturnStatement(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast.getLine()); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(231);
				((StatementContext)_localctx).ID = match(ID);
				setState(232);
				match(T__2);
				setState(233);
				((StatementContext)_localctx).el = expression_list();
				setState(234);
				match(T__3);
				setState(235);
				match(T__25);
				 ((StatementContext)_localctx).ast =  new FunctionInvocation((((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null), ((StatementContext)_localctx).el.args, ((StatementContext)_localctx).ID.getCharPositionInLine()+1, ((StatementContext)_localctx).ID.getLine());
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(238);
				((StatementContext)_localctx).ID = match(ID);
				setState(242);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(239);
					match(T__4);
					}
					break;
				case T__2:
					{
					setState(240);
					match(T__2);
					setState(241);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(244);
				match(T__25);
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
		public List<Expression> args;
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
		enterRule(_localctx, 14, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Expression_listContext)_localctx).args =  new ArrayList(); 
			setState(249);
			((Expression_listContext)_localctx).e1 = expression(0);
			 _localctx.args.add(((Expression_listContext)_localctx).e1.ast); 
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(251);
				match(T__24);
				setState(252);
				((Expression_listContext)_localctx).e2 = expression(0);
				 _localctx.args.add( ((Expression_listContext)_localctx).e2.ast); 
				}
				}
				setState(259);
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
		public List<Statement> args;
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
		enterRule(_localctx, 16, RULE_code_block);
		int _la;
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__10:
			case T__11:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__32:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				 ((Code_blockContext)_localctx).args =  new ArrayList<Statement>(); 
				setState(261);
				((Code_blockContext)_localctx).e1 = statement();
				_localctx.args.add(((Code_blockContext)_localctx).e1.ast); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				 ((Code_blockContext)_localctx).args =  new ArrayList<Statement>(); 
				setState(265);
				match(T__5);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__32) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(266);
					((Code_blockContext)_localctx).e1 = statement();
					 _localctx.args.add(((Code_blockContext)_localctx).e1.ast); 
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(274);
				match(T__6);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__34:
			case T__35:
			case T__36:
				{
				setState(278);
				((TypeContext)_localctx).rt = return_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).rt.ast; 
				}
				break;
			case T__33:
				{
				setState(281);
				match(T__33);
				setState(282);
				match(T__5);
				setState(283);
				((TypeContext)_localctx).rf = record_fields();
				setState(284);
				match(T__6);
				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).rf.args, ((TypeContext)_localctx).rf.args.get(0).getColumn(), ((TypeContext)_localctx).rf.args.get(0).getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
					setState(289);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(290);
					match(T__7);
					setState(291);
					((TypeContext)_localctx).il = match(INT_CONSTANT);
					setState(292);
					match(T__8);
					 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).il!=null?((TypeContext)_localctx).il.getText():null)), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast.getLine());
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public List<RecordField> args;
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
		enterRule(_localctx, 20, RULE_record_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Record_fieldsContext)_localctx).args =  new ArrayList<RecordField>(); 
			setState(305); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(300);
				((Record_fieldsContext)_localctx).t = type(0);
				setState(301);
				((Record_fieldsContext)_localctx).ID = match(ID);
				setState(302);
				match(T__25);
				 _localctx.args.add(new RecordField(((Record_fieldsContext)_localctx).t.ast, (((Record_fieldsContext)_localctx).ID!=null?((Record_fieldsContext)_localctx).ID.getText():null), ((Record_fieldsContext)_localctx).t.ast.getColumn(), ((Record_fieldsContext)_localctx).t.ast.getLine())); 
				}
				}
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0) );
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
		public Token t;
		public Builtin_typeContext bt;
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
		enterRule(_localctx, 22, RULE_return_type);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				((Return_typeContext)_localctx).t = match(T__0);
				 ((Return_typeContext)_localctx).ast =  new VoidType(((Return_typeContext)_localctx).t.getCharPositionInLine()+1, ((Return_typeContext)_localctx).t.getLine()); 
				}
				break;
			case T__34:
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
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
		enterRule(_localctx, 24, RULE_builtin_type);
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				((Builtin_typeContext)_localctx).t = match(T__34);
				 ((Builtin_typeContext)_localctx).ast =  new IntType(((Builtin_typeContext)_localctx).t.getCharPositionInLine()+1, ((Builtin_typeContext)_localctx).t.getLine()); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				((Builtin_typeContext)_localctx).t = match(T__35);
				 ((Builtin_typeContext)_localctx).ast =  new CharType(((Builtin_typeContext)_localctx).t.getCharPositionInLine()+1, ((Builtin_typeContext)_localctx).t.getLine()); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
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
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0147\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\7\3"+
		"\64\n\3\f\3\16\3\67\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4w"+
		"\n\4\f\4\16\4z\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0083\n\5\f\5\16\5"+
		"\u0086\13\5\3\5\3\5\3\5\5\5\u008b\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6\u0096\n\6\f\6\16\6\u0099\13\6\5\6\u009b\n\6\3\6\3\6\5\6\u009f"+
		"\n\6\3\6\3\6\7\6\u00a3\n\6\f\6\16\6\u00a6\13\6\3\6\7\6\u00a9\n\6\f\6\16"+
		"\6\u00ac\13\6\3\6\3\6\3\6\5\6\u00b1\n\6\3\7\3\7\3\7\3\7\7\7\u00b7\n\7"+
		"\f\7\16\7\u00ba\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00f5\n\b\3\b\3\b\5\b\u00f9"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0102\n\t\f\t\16\t\u0105\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0110\n\n\f\n\16\n\u0113\13\n\3\n"+
		"\5\n\u0116\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0122\n\13\3\13\3\13\3\13\3\13\3\13\7\13\u0129\n\13\f\13\16\13\u012c"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0134\n\f\r\f\16\f\u0135\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u013d\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0145\n\16"+
		"\3\16\2\4\6\24\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2\17\21\4\2\r"+
		"\r\22\22\3\2\23\30\3\2\31\32\2\u0165\2\37\3\2\2\2\4$\3\2\2\2\6V\3\2\2"+
		"\2\b\u008a\3\2\2\2\n\u00b0\3\2\2\2\f\u00b2\3\2\2\2\16\u00f8\3\2\2\2\20"+
		"\u00fa\3\2\2\2\22\u0115\3\2\2\2\24\u0121\3\2\2\2\26\u012d\3\2\2\2\30\u013c"+
		"\3\2\2\2\32\u0144\3\2\2\2\34\36\5\n\6\2\35\34\3\2\2\2\36!\3\2\2\2\37\35"+
		"\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\5\4\3\2#\3\3\2\2\2$%\7"+
		"\3\2\2%)\7\4\2\2&\'\7\5\2\2\'*\7\6\2\2(*\7\7\2\2)&\3\2\2\2)(\3\2\2\2*"+
		"+\3\2\2\2+/\7\b\2\2,.\5\f\7\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\60\65\3\2\2\2\61/\3\2\2\2\62\64\5\16\b\2\63\62\3\2\2\2\64\67\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\t\2\29"+
		"\5\3\2\2\2:;\b\4\1\2;<\7\5\2\2<=\5\6\4\2=>\7\6\2\2>?\b\4\1\2?W\3\2\2\2"+
		"@A\7\r\2\2AB\5\6\4\rBC\b\4\1\2CW\3\2\2\2DE\7\16\2\2EF\5\6\4\fFG\b\4\1"+
		"\2GW\3\2\2\2HI\7*\2\2IJ\7\5\2\2JK\5\b\5\2KL\7\6\2\2LM\b\4\1\2MW\3\2\2"+
		"\2NO\7*\2\2OW\b\4\1\2PQ\7+\2\2QW\b\4\1\2RS\7.\2\2SW\b\4\1\2TU\7-\2\2U"+
		"W\b\4\1\2V:\3\2\2\2V@\3\2\2\2VD\3\2\2\2VH\3\2\2\2VN\3\2\2\2VP\3\2\2\2"+
		"VR\3\2\2\2VT\3\2\2\2Wx\3\2\2\2XY\f\13\2\2YZ\t\2\2\2Z[\5\6\4\f[\\\b\4\1"+
		"\2\\w\3\2\2\2]^\f\n\2\2^_\t\3\2\2_`\5\6\4\13`a\b\4\1\2aw\3\2\2\2bc\f\t"+
		"\2\2cd\t\4\2\2de\5\6\4\nef\b\4\1\2fw\3\2\2\2gh\f\b\2\2hi\t\5\2\2ij\5\6"+
		"\4\tjk\b\4\1\2kw\3\2\2\2lm\f\17\2\2mn\7\n\2\2no\5\6\4\2op\7\13\2\2pq\b"+
		"\4\1\2qw\3\2\2\2rs\f\16\2\2st\7\f\2\2tu\7*\2\2uw\b\4\1\2vX\3\2\2\2v]\3"+
		"\2\2\2vb\3\2\2\2vg\3\2\2\2vl\3\2\2\2vr\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3"+
		"\2\2\2y\7\3\2\2\2zx\3\2\2\2{|\7\5\2\2|}\5\6\4\2}\u0084\b\5\1\2~\177\7"+
		"\33\2\2\177\u0080\5\6\4\2\u0080\u0081\b\5\1\2\u0081\u0083\3\2\2\2\u0082"+
		"~\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\6\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u008b\b\5\1\2\u008a{\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\t\3\2\2\2\u008c\u008d\5\30\r\2\u008d\u009e\7*\2\2\u008e\u008f\7\5\2\2"+
		"\u008f\u0090\5\24\13\2\u0090\u0097\7*\2\2\u0091\u0092\7\33\2\2\u0092\u0093"+
		"\5\24\13\2\u0093\u0094\7*\2\2\u0094\u0096\3\2\2\2\u0095\u0091\3\2\2\2"+
		"\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u008e\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009f\7\6\2\2\u009d\u009f\7\7\2\2\u009e\u009a\3\2"+
		"\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a4\7\b\2\2\u00a1"+
		"\u00a3\5\f\7\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00aa\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a9\5\16\b\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00ae\7\t\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\5\f\7\2\u00b0\u008c\3\2"+
		"\2\2\u00b0\u00af\3\2\2\2\u00b1\13\3\2\2\2\u00b2\u00b3\5\24\13\2\u00b3"+
		"\u00b8\7*\2\2\u00b4\u00b5\7\33\2\2\u00b5\u00b7\7*\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\34\2\2\u00bc\r\3\2\2"+
		"\2\u00bd\u00be\7\35\2\2\u00be\u00bf\5\20\t\2\u00bf\u00c0\7\34\2\2\u00c0"+
		"\u00c1\b\b\1\2\u00c1\u00f9\3\2\2\2\u00c2\u00c3\7\36\2\2\u00c3\u00c4\5"+
		"\20\t\2\u00c4\u00c5\7\34\2\2\u00c5\u00c6\b\b\1\2\u00c6\u00f9\3\2\2\2\u00c7"+
		"\u00c8\7\37\2\2\u00c8\u00c9\7\5\2\2\u00c9\u00ca\5\6\4\2\u00ca\u00cb\7"+
		"\6\2\2\u00cb\u00cc\5\22\n\2\u00cc\u00cd\b\b\1\2\u00cd\u00f9\3\2\2\2\u00ce"+
		"\u00cf\7 \2\2\u00cf\u00d0\7\5\2\2\u00d0\u00d1\5\6\4\2\u00d1\u00d2\7\6"+
		"\2\2\u00d2\u00d3\5\22\n\2\u00d3\u00d4\b\b\1\2\u00d4\u00f9\3\2\2\2\u00d5"+
		"\u00d6\7 \2\2\u00d6\u00d7\7\5\2\2\u00d7\u00d8\5\6\4\2\u00d8\u00d9\7\6"+
		"\2\2\u00d9\u00da\5\22\n\2\u00da\u00db\7!\2\2\u00db\u00dc\5\22\n\2\u00dc"+
		"\u00dd\b\b\1\2\u00dd\u00f9\3\2\2\2\u00de\u00df\5\6\4\2\u00df\u00e0\7\""+
		"\2\2\u00e0\u00e1\5\6\4\2\u00e1\u00e2\7\34\2\2\u00e2\u00e3\b\b\1\2\u00e3"+
		"\u00f9\3\2\2\2\u00e4\u00e5\7#\2\2\u00e5\u00e6\5\6\4\2\u00e6\u00e7\7\34"+
		"\2\2\u00e7\u00e8\b\b\1\2\u00e8\u00f9\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea"+
		"\u00eb\7\5\2\2\u00eb\u00ec\5\20\t\2\u00ec\u00ed\7\6\2\2\u00ed\u00ee\7"+
		"\34\2\2\u00ee\u00ef\b\b\1\2\u00ef\u00f9\3\2\2\2\u00f0\u00f4\7*\2\2\u00f1"+
		"\u00f5\7\7\2\2\u00f2\u00f3\7\5\2\2\u00f3\u00f5\7\6\2\2\u00f4\u00f1\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\34\2\2\u00f7"+
		"\u00f9\b\b\1\2\u00f8\u00bd\3\2\2\2\u00f8\u00c2\3\2\2\2\u00f8\u00c7\3\2"+
		"\2\2\u00f8\u00ce\3\2\2\2\u00f8\u00d5\3\2\2\2\u00f8\u00de\3\2\2\2\u00f8"+
		"\u00e4\3\2\2\2\u00f8\u00e9\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f9\17\3\2\2"+
		"\2\u00fa\u00fb\b\t\1\2\u00fb\u00fc\5\6\4\2\u00fc\u0103\b\t\1\2\u00fd\u00fe"+
		"\7\33\2\2\u00fe\u00ff\5\6\4\2\u00ff\u0100\b\t\1\2\u0100\u0102\3\2\2\2"+
		"\u0101\u00fd\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\21\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\b\n\1\2\u0107"+
		"\u0108\5\16\b\2\u0108\u0109\b\n\1\2\u0109\u0116\3\2\2\2\u010a\u010b\b"+
		"\n\1\2\u010b\u0111\7\b\2\2\u010c\u010d\5\16\b\2\u010d\u010e\b\n\1\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0116\7\t\2\2\u0115\u0106\3\2\2\2\u0115\u010a\3\2\2\2\u0116\23\3\2\2"+
		"\2\u0117\u0118\b\13\1\2\u0118\u0119\5\30\r\2\u0119\u011a\b\13\1\2\u011a"+
		"\u0122\3\2\2\2\u011b\u011c\7$\2\2\u011c\u011d\7\b\2\2\u011d\u011e\5\26"+
		"\f\2\u011e\u011f\7\t\2\2\u011f\u0120\b\13\1\2\u0120\u0122\3\2\2\2\u0121"+
		"\u0117\3\2\2\2\u0121\u011b\3\2\2\2\u0122\u012a\3\2\2\2\u0123\u0124\f\4"+
		"\2\2\u0124\u0125\7\n\2\2\u0125\u0126\7+\2\2\u0126\u0127\7\13\2\2\u0127"+
		"\u0129\b\13\1\2\u0128\u0123\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\25\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u0133\b\f\1\2\u012e\u012f\5\24\13\2\u012f\u0130\7*\2\2\u0130\u0131\7"+
		"\34\2\2\u0131\u0132\b\f\1\2\u0132\u0134\3\2\2\2\u0133\u012e\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\27\3\2\2"+
		"\2\u0137\u0138\7\3\2\2\u0138\u013d\b\r\1\2\u0139\u013a\5\32\16\2\u013a"+
		"\u013b\b\r\1\2\u013b\u013d\3\2\2\2\u013c\u0137\3\2\2\2\u013c\u0139\3\2"+
		"\2\2\u013d\31\3\2\2\2\u013e\u013f\7%\2\2\u013f\u0145\b\16\1\2\u0140\u0141"+
		"\7&\2\2\u0141\u0145\b\16\1\2\u0142\u0143\7\'\2\2\u0143\u0145\b\16\1\2"+
		"\u0144\u013e\3\2\2\2\u0144\u0140\3\2\2\2\u0144\u0142\3\2\2\2\u0145\33"+
		"\3\2\2\2\34\37)/\65Vvx\u0084\u008a\u0097\u009a\u009e\u00a4\u00aa\u00b0"+
		"\u00b8\u00f4\u00f8\u0103\u0111\u0115\u0121\u012a\u0135\u013c\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}