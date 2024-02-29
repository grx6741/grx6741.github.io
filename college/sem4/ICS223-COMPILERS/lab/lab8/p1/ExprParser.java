// Generated from Expr.g by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, WHILE=3, VAR_TYPE=4, IDEN=5, BOOl=6, INT=7, FLOAT=8, OPAREN=9, 
		CPAREN=10, OFLOWER=11, CFLOWER=12, NOT=13, AND=14, OR=15, XOR=16, GT=17, 
		GTE=18, LT=19, LTE=20, EQ=21, LSHIFT=22, RSHIFT=23, NEQ=24, ASSIGN=25, 
		SEMICOLON=26, PLUS=27, MINUS=28, MULT=29, DIV=30, SPACE=31;
	public static final int
		RULE_start = 0, RULE_code_block = 1, RULE_statements = 2, RULE_bool_expr = 3, 
		RULE_line = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "code_block", "statements", "bool_expr", "line"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", null, null, null, null, null, "'('", 
			"')'", "'{'", "'}'", "'~'", "'&'", "'|'", "'^'", "'>'", "'>='", "'<'", 
			"'<='", "'=='", "'<<'", "'>>'", "'!='", "'='", "';'", "'+'", "'-'", "'*'", 
			"'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "WHILE", "VAR_TYPE", "IDEN", "BOOl", "INT", "FLOAT", 
			"OPAREN", "CPAREN", "OFLOWER", "CFLOWER", "NOT", "AND", "OR", "XOR", 
			"GT", "GTE", "LT", "LTE", "EQ", "LSHIFT", "RSHIFT", "NEQ", "ASSIGN", 
			"SEMICOLON", "PLUS", "MINUS", "MULT", "DIV", "SPACE"
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
	public String getGrammarFileName() { return "Expr.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			code_block();
			setState(11);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Code_blockContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterCode_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitCode_block(this);
		}
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			statements();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67108912L) != 0)) {
				{
				{
				setState(15);
				line();
				}
				}
				setState(20);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Bool_exprContext extends ParserRuleContext {
		public TerminalNode OPAREN() { return getToken(ExprParser.OPAREN, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode CPAREN() { return getToken(ExprParser.CPAREN, 0); }
		public TerminalNode NOT() { return getToken(ExprParser.NOT, 0); }
		public TerminalNode IDEN() { return getToken(ExprParser.IDEN, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public TerminalNode BOOl() { return getToken(ExprParser.BOOl, 0); }
		public TerminalNode AND() { return getToken(ExprParser.AND, 0); }
		public TerminalNode OR() { return getToken(ExprParser.OR, 0); }
		public TerminalNode XOR() { return getToken(ExprParser.XOR, 0); }
		public TerminalNode GT() { return getToken(ExprParser.GT, 0); }
		public TerminalNode GTE() { return getToken(ExprParser.GTE, 0); }
		public TerminalNode LT() { return getToken(ExprParser.LT, 0); }
		public TerminalNode LTE() { return getToken(ExprParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(ExprParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExprParser.NEQ, 0); }
		public TerminalNode RSHIFT() { return getToken(ExprParser.RSHIFT, 0); }
		public TerminalNode LSHIFT() { return getToken(ExprParser.LSHIFT, 0); }
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitBool_expr(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		return bool_expr(0);
	}

	private Bool_exprContext bool_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, _parentState);
		Bool_exprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_bool_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(22);
				match(OPAREN);
				setState(23);
				bool_expr(0);
				setState(24);
				match(CPAREN);
				}
				break;
			case NOT:
				{
				setState(26);
				match(NOT);
				setState(27);
				bool_expr(3);
				}
				break;
			case IDEN:
			case BOOl:
			case INT:
			case FLOAT:
				{
				setState(28);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
					setState(31);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(32);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33538048L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(33);
					bool_expr(3);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(ExprParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ExprParser.SEMICOLON, i);
		}
		public List<TerminalNode> IDEN() { return getTokens(ExprParser.IDEN); }
		public TerminalNode IDEN(int i) {
			return getToken(ExprParser.IDEN, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(ExprParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(ExprParser.ASSIGN, i);
		}
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public List<TerminalNode> VAR_TYPE() { return getTokens(ExprParser.VAR_TYPE); }
		public TerminalNode VAR_TYPE(int i) {
			return getToken(ExprParser.VAR_TYPE, i);
		}
		public List<TerminalNode> INT() { return getTokens(ExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ExprParser.INT, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(ExprParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(ExprParser.FLOAT, i);
		}
		public List<TerminalNode> BOOl() { return getTokens(ExprParser.BOOl); }
		public TerminalNode BOOl(int i) {
			return getToken(ExprParser.BOOl, i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_line);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VAR_TYPE || _la==IDEN) {
						{
						setState(40);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==VAR_TYPE) {
							{
							setState(39);
							match(VAR_TYPE);
							}
						}

						setState(42);
						match(IDEN);
						setState(43);
						match(ASSIGN);
						setState(46);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
						case 1:
							{
							setState(44);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							break;
						case 2:
							{
							setState(45);
							bool_expr(0);
							}
							break;
						}
						}
					}

					setState(50);
					match(SEMICOLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(53); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 3:
			return bool_expr_sempred((Bool_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bool_expr_sempred(Bool_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0005"+
		"\u0002\u0011\b\u0002\n\u0002\f\u0002\u0014\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u001e\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"#\b\u0003\n\u0003\f\u0003&\t\u0003\u0001\u0004\u0003\u0004)\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004/\b\u0004\u0003"+
		"\u00041\b\u0004\u0001\u0004\u0004\u00044\b\u0004\u000b\u0004\f\u00045"+
		"\u0001\u0004\u0000\u0001\u0006\u0005\u0000\u0002\u0004\u0006\b\u0000\u0002"+
		"\u0001\u0000\u0005\b\u0001\u0000\u000e\u0018:\u0000\n\u0001\u0000\u0000"+
		"\u0000\u0002\r\u0001\u0000\u0000\u0000\u0004\u0012\u0001\u0000\u0000\u0000"+
		"\u0006\u001d\u0001\u0000\u0000\u0000\b3\u0001\u0000\u0000\u0000\n\u000b"+
		"\u0003\u0002\u0001\u0000\u000b\f\u0005\u0000\u0000\u0001\f\u0001\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0003\u0004\u0002\u0000\u000e\u0003\u0001\u0000"+
		"\u0000\u0000\u000f\u0011\u0003\b\u0004\u0000\u0010\u000f\u0001\u0000\u0000"+
		"\u0000\u0011\u0014\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000"+
		"\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0005\u0001\u0000\u0000"+
		"\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0015\u0016\u0006\u0003\uffff"+
		"\uffff\u0000\u0016\u0017\u0005\t\u0000\u0000\u0017\u0018\u0003\u0006\u0003"+
		"\u0000\u0018\u0019\u0005\n\u0000\u0000\u0019\u001e\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0005\r\u0000\u0000\u001b\u001e\u0003\u0006\u0003\u0003\u001c"+
		"\u001e\u0007\u0000\u0000\u0000\u001d\u0015\u0001\u0000\u0000\u0000\u001d"+
		"\u001a\u0001\u0000\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e"+
		"$\u0001\u0000\u0000\u0000\u001f \n\u0002\u0000\u0000 !\u0007\u0001\u0000"+
		"\u0000!#\u0003\u0006\u0003\u0003\"\u001f\u0001\u0000\u0000\u0000#&\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%\u0007\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\')\u0005\u0004"+
		"\u0000\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*+\u0005\u0005\u0000\u0000+.\u0005\u0019\u0000\u0000"+
		",/\u0007\u0000\u0000\u0000-/\u0003\u0006\u0003\u0000.,\u0001\u0000\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000(\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0005"+
		"\u001a\u0000\u000030\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u00006\t\u0001\u0000\u0000"+
		"\u0000\u0007\u0012\u001d$(.05";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}