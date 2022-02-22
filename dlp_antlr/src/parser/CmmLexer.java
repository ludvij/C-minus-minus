// Generated from C:/Users/luisv/IdeaProjects/dlp_antlr/src/parser\Cmm.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, MULTI_LINE_COMMENT=2, ID=3, INT_CONSTANT=4, WHITE_SPACES=5, 
		REAL_CONSTANT=6, CHAR_CONSTANT=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "MULTI_LINE_COMMENT", "ID", "DIGIT", "INT_CONSTANT", "WHITE_SPACES", 
			"EXPONENT", "REAL_CONSTANT", "VALID_CHAR", "CHAR_CONSTANT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "MULTI_LINE_COMMENT", "ID", "INT_CONSTANT", "WHITE_SPACES", 
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tt\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4\63\n\4\f\4"+
		"\16\4\66\13\4\3\5\3\5\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\6\5\6B\n\6\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\5\bJ\n\b\3\b\3\b\3\t\3\t\3\t\7\tQ\n\t\f\t\16\tT\13"+
		"\t\3\t\5\tW\n\t\3\t\5\tZ\n\t\3\t\3\t\6\t^\n\t\r\t\16\t_\3\t\5\tc\n\t\3"+
		"\t\3\t\3\t\5\th\n\t\3\n\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13\3\13\3\13\3"+
		"(\2\f\3\3\5\4\7\5\t\2\13\6\r\7\17\2\21\b\23\2\25\t\3\2\13\3\2\f\f\5\2"+
		"C\\aac|\6\2\62;C\\aac|\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\4\2GGgg\4\2"+
		"--//\4\2ppvv\2\177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\"\3\2\2\2\7\60\3\2"+
		"\2\2\t\67\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17G\3\2\2\2\21g\3\2\2\2\23n\3"+
		"\2\2\2\25p\3\2\2\2\27\30\7\61\2\2\30\31\7\61\2\2\31\35\3\2\2\2\32\34\n"+
		"\2\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2"+
		"\2\2\37\35\3\2\2\2 !\b\2\2\2!\4\3\2\2\2\"#\7\61\2\2#$\7,\2\2$(\3\2\2\2"+
		"%\'\13\2\2\2&%\3\2\2\2\'*\3\2\2\2()\3\2\2\2(&\3\2\2\2)+\3\2\2\2*(\3\2"+
		"\2\2+,\7,\2\2,-\7\61\2\2-.\3\2\2\2./\b\3\2\2/\6\3\2\2\2\60\64\t\3\2\2"+
		"\61\63\t\4\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\b\3\2\2\2\66\64\3\2\2\2\678\t\5\2\28\n\3\2\2\29=\t\6\2\2:<\5\t\5\2"+
		";:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>B\3\2\2\2?=\3\2\2\2@B\7\62\2"+
		"\2A9\3\2\2\2A@\3\2\2\2B\f\3\2\2\2CD\t\7\2\2DE\3\2\2\2EF\b\7\2\2F\16\3"+
		"\2\2\2GI\t\b\2\2HJ\t\t\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\5\13\6\2L\20"+
		"\3\2\2\2MN\5\13\6\2NR\7\60\2\2OQ\5\t\5\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2SV\3\2\2\2TR\3\2\2\2UW\5\17\b\2VU\3\2\2\2VW\3\2\2\2Wh\3\2\2"+
		"\2XZ\5\13\6\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]\7\60\2\2\\^\5\t\5\2]\\\3"+
		"\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\5\17\b\2ba\3\2\2\2bc"+
		"\3\2\2\2ch\3\2\2\2de\5\13\6\2ef\5\17\b\2fh\3\2\2\2gM\3\2\2\2gY\3\2\2\2"+
		"gd\3\2\2\2h\22\3\2\2\2ij\7^\2\2jo\t\n\2\2kl\7^\2\2lo\5\13\6\2mo\13\2\2"+
		"\2ni\3\2\2\2nk\3\2\2\2nm\3\2\2\2o\24\3\2\2\2pq\7)\2\2qr\5\23\n\2rs\7)"+
		"\2\2s\26\3\2\2\2\20\2\35(\64=AIRVY_bgn\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}