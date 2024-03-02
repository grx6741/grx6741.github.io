// Generated from Expr.g by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BoolParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, EQUAL=3, LT=4, GT=5, LTE=6, GTE=7, NE=8, AND=9, OR=10, 
		NUM=11, VARIABLE=12, PLUS=13, SPACE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "EQUAL", "LT", "GT", "LTE", "GTE", "NE", "AND", "OR", 
			"NUM", "VARIABLE", "PLUS", "SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, "'<='", "'>='", null, null, null, 
			null, null, "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "EQUAL", "LT", "GT", "LTE", "GTE", "NE", "AND", "OR", 
			"NUM", "VARIABLE", "PLUS", "SPACE"
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


	public BoolParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g"; }

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
		"\u0004\u0000\u000e^\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002%\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003*\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004/\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007;\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bD\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\tJ\b\t\u0001\n\u0004\nM\b\n\u000b\n\f\nN\u0001\u000b"+
		"\u0004\u000bR\b\u000b\u000b\u000b\f\u000bS\u0001\f\u0001\f\u0001\r\u0004"+
		"\rY\b\r\u000b\r\f\rZ\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000\u0003\u0001"+
		"\u000009\u0005\u0000-.09AZ__az\u0003\u0000\t\n\r\r  g\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000"+
		"\u0000\u0003\u001f\u0001\u0000\u0000\u0000\u0005$\u0001\u0000\u0000\u0000"+
		"\u0007)\u0001\u0000\u0000\u0000\t.\u0001\u0000\u0000\u0000\u000b0\u0001"+
		"\u0000\u0000\u0000\r3\u0001\u0000\u0000\u0000\u000f:\u0001\u0000\u0000"+
		"\u0000\u0011C\u0001\u0000\u0000\u0000\u0013I\u0001\u0000\u0000\u0000\u0015"+
		"L\u0001\u0000\u0000\u0000\u0017Q\u0001\u0000\u0000\u0000\u0019U\u0001"+
		"\u0000\u0000\u0000\u001bX\u0001\u0000\u0000\u0000\u001d\u001e\u0005(\u0000"+
		"\u0000\u001e\u0002\u0001\u0000\u0000\u0000\u001f \u0005)\u0000\u0000 "+
		"\u0004\u0001\u0000\u0000\u0000!%\u0005=\u0000\u0000\"#\u0005E\u0000\u0000"+
		"#%\u0005Q\u0000\u0000$!\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"%\u0006\u0001\u0000\u0000\u0000&*\u0005<\u0000\u0000\'(\u0005L\u0000\u0000"+
		"(*\u0005T\u0000\u0000)&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		"*\b\u0001\u0000\u0000\u0000+/\u0005>\u0000\u0000,-\u0005G\u0000\u0000"+
		"-/\u0005T\u0000\u0000.+\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000"+
		"/\n\u0001\u0000\u0000\u000001\u0005<\u0000\u000012\u0005=\u0000\u0000"+
		"2\f\u0001\u0000\u0000\u000034\u0005>\u0000\u000045\u0005=\u0000\u0000"+
		"5\u000e\u0001\u0000\u0000\u000067\u0005!\u0000\u00007;\u0005=\u0000\u0000"+
		"89\u0005N\u0000\u00009;\u0005E\u0000\u0000:6\u0001\u0000\u0000\u0000:"+
		"8\u0001\u0000\u0000\u0000;\u0010\u0001\u0000\u0000\u0000<=\u0005A\u0000"+
		"\u0000=>\u0005N\u0000\u0000>D\u0005D\u0000\u0000?D\u0005&\u0000\u0000"+
		"@A\u0005a\u0000\u0000AB\u0005n\u0000\u0000BD\u0005d\u0000\u0000C<\u0001"+
		"\u0000\u0000\u0000C?\u0001\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000"+
		"D\u0012\u0001\u0000\u0000\u0000EF\u0005O\u0000\u0000FJ\u0005R\u0000\u0000"+
		"GH\u0005o\u0000\u0000HJ\u0005r\u0000\u0000IE\u0001\u0000\u0000\u0000I"+
		"G\u0001\u0000\u0000\u0000J\u0014\u0001\u0000\u0000\u0000KM\u0007\u0000"+
		"\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0016\u0001\u0000\u0000"+
		"\u0000PR\u0007\u0001\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0018"+
		"\u0001\u0000\u0000\u0000UV\u0005+\u0000\u0000V\u001a\u0001\u0000\u0000"+
		"\u0000WY\u0007\u0002\u0000\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\]\u0006\r\u0000\u0000]\u001c\u0001\u0000\u0000\u0000"+
		"\n\u0000$).:CINSZ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}