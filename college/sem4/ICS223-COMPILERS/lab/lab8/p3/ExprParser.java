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
		GTE=18, LT=19, LTE=20, EQ=21, NEQ=22, ASSIGN=23, SEMICOLON=24, PLUS=25, 
		MINUS=26, MULT=27, DIV=28, SPACE=29;
	public static final int
		RULE_start = 0, RULE_code_block = 1, RULE_statements = 2, RULE_while_stat = 3, 
		RULE_if_stat = 4, RULE_conditional_block = 5, RULE_condition = 6, RULE_bool_expr = 7, 
		RULE_line = 8, RULE_arithmetic_expr = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "code_block", "statements", "while_stat", "if_stat", "conditional_block", 
			"condition", "bool_expr", "line", "arithmetic_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", null, null, null, null, null, "'('", 
			"')'", "'{'", "'}'", "'~'", "'&'", "'|'", "'^'", "'>'", "'>='", "'<'", 
			"'<='", "'=='", "'!='", "'='", "';'", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "WHILE", "VAR_TYPE", "IDEN", "BOOl", "INT", "FLOAT", 
			"OPAREN", "CPAREN", "OFLOWER", "CFLOWER", "NOT", "AND", "OR", "XOR", 
			"GT", "GTE", "LT", "LTE", "EQ", "NEQ", "ASSIGN", "SEMICOLON", "PLUS", 
			"MINUS", "MULT", "DIV", "SPACE"
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
			setState(20);
			code_block();
			setState(21);
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
			setState(23);
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
		public List<If_statContext> if_stat() {
			return getRuleContexts(If_statContext.class);
		}
		public If_statContext if_stat(int i) {
			return getRuleContext(If_statContext.class,i);
		}
		public List<While_statContext> while_stat() {
			return getRuleContexts(While_statContext.class);
		}
		public While_statContext while_stat(int i) {
			return getRuleContext(While_statContext.class,i);
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
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16777274L) != 0)) {
				{
				setState(28);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR_TYPE:
				case IDEN:
				case SEMICOLON:
					{
					setState(25);
					line();
					}
					break;
				case IF:
					{
					setState(26);
					if_stat();
					}
					break;
				case WHILE:
					{
					setState(27);
					while_stat();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32);
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
	public static class While_statContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ExprParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Conditional_blockContext conditional_block() {
			return getRuleContext(Conditional_blockContext.class,0);
		}
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterWhile_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitWhile_stat(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(WHILE);
			setState(34);
			condition();
			setState(35);
			conditional_block();
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
	public static class If_statContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(ExprParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(ExprParser.IF, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<Conditional_blockContext> conditional_block() {
			return getRuleContexts(Conditional_blockContext.class);
		}
		public Conditional_blockContext conditional_block(int i) {
			return getRuleContext(Conditional_blockContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(ExprParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ExprParser.ELSE, i);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitIf_stat(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(IF);
			setState(38);
			condition();
			setState(39);
			conditional_block();
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					match(ELSE);
					setState(41);
					match(IF);
					setState(42);
					condition();
					setState(43);
					conditional_block();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(50);
				match(ELSE);
				setState(51);
				conditional_block();
				}
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
	public static class Conditional_blockContext extends ParserRuleContext {
		public TerminalNode OFLOWER() { return getToken(ExprParser.OFLOWER, 0); }
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public TerminalNode CFLOWER() { return getToken(ExprParser.CFLOWER, 0); }
		public Conditional_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterConditional_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitConditional_block(this);
		}
	}

	public final Conditional_blockContext conditional_block() throws RecognitionException {
		Conditional_blockContext _localctx = new Conditional_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(OFLOWER);
			setState(55);
			code_block();
			setState(56);
			match(CFLOWER);
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
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode OPAREN() { return getToken(ExprParser.OPAREN, 0); }
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public TerminalNode CPAREN() { return getToken(ExprParser.CPAREN, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(OPAREN);
			setState(59);
			bool_expr(0);
			setState(60);
			match(CPAREN);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_bool_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(63);
				match(OPAREN);
				setState(64);
				bool_expr(0);
				setState(65);
				match(CPAREN);
				}
				break;
			case NOT:
				{
				setState(67);
				match(NOT);
				setState(68);
				bool_expr(3);
				}
				break;
			case IDEN:
			case BOOl:
			case INT:
			case FLOAT:
				{
				setState(69);
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
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
					setState(72);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(73);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8372224L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(74);
					bool_expr(3);
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public List<TerminalNode> VAR_TYPE() { return getTokens(ExprParser.VAR_TYPE); }
		public TerminalNode VAR_TYPE(int i) {
			return getToken(ExprParser.VAR_TYPE, i);
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
		enterRule(_localctx, 16, RULE_line);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VAR_TYPE || _la==IDEN) {
						{
						setState(81);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==VAR_TYPE) {
							{
							setState(80);
							match(VAR_TYPE);
							}
						}

						setState(83);
						match(IDEN);
						setState(84);
						match(ASSIGN);
						setState(85);
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
					}

					setState(88);
					match(SEMICOLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(91); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Arithmetic_exprContext extends ParserRuleContext {
		public TerminalNode OPAREN() { return getToken(ExprParser.OPAREN, 0); }
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode CPAREN() { return getToken(ExprParser.CPAREN, 0); }
		public TerminalNode IDEN() { return getToken(ExprParser.IDEN, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(ExprParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public Arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterArithmetic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitArithmetic_expr(this);
		}
	}

	public final Arithmetic_exprContext arithmetic_expr() throws RecognitionException {
		return arithmetic_expr(0);
	}

	private Arithmetic_exprContext arithmetic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_exprContext _localctx = new Arithmetic_exprContext(_ctx, _parentState);
		Arithmetic_exprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(94);
				match(OPAREN);
				setState(95);
				arithmetic_expr(0);
				setState(96);
				match(CPAREN);
				}
				break;
			case IDEN:
			case INT:
			case FLOAT:
				{
				setState(98);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 416L) != 0)) ) {
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
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Arithmetic_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
					setState(101);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(102);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316480L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(103);
					arithmetic_expr(3);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return bool_expr_sempred((Bool_exprContext)_localctx, predIndex);
		case 9:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
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
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001dn\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u001d\b\u0002"+
		"\n\u0002\f\u0002 \t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004.\b\u0004\n\u0004\f\u00041\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u00045\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007G\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007L\b\u0007\n\u0007\f\u0007O\t\u0007\u0001\b\u0003"+
		"\bR\b\b\u0001\b\u0001\b\u0001\b\u0003\bW\b\b\u0001\b\u0004\bZ\b\b\u000b"+
		"\b\f\b[\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\td\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\ti\b\t\n\t\f\tl\t\t\u0001\t\u0000\u0002\u000e"+
		"\u0012\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0004\u0001"+
		"\u0000\u0005\b\u0001\u0000\u000e\u0016\u0002\u0000\u0005\u0005\u0007\b"+
		"\u0001\u0000\u0019\u001cp\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u0017"+
		"\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006!\u0001"+
		"\u0000\u0000\u0000\b%\u0001\u0000\u0000\u0000\n6\u0001\u0000\u0000\u0000"+
		"\f:\u0001\u0000\u0000\u0000\u000eF\u0001\u0000\u0000\u0000\u0010Y\u0001"+
		"\u0000\u0000\u0000\u0012c\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002"+
		"\u0001\u0000\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0003\u0001\u0000"+
		"\u0000\u0000\u0019\u001d\u0003\u0010\b\u0000\u001a\u001d\u0003\b\u0004"+
		"\u0000\u001b\u001d\u0003\u0006\u0003\u0000\u001c\u0019\u0001\u0000\u0000"+
		"\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001b\u0001\u0000\u0000"+
		"\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000!\"\u0005\u0003\u0000\u0000\"#\u0003\f"+
		"\u0006\u0000#$\u0003\n\u0005\u0000$\u0007\u0001\u0000\u0000\u0000%&\u0005"+
		"\u0001\u0000\u0000&\'\u0003\f\u0006\u0000\'/\u0003\n\u0005\u0000()\u0005"+
		"\u0002\u0000\u0000)*\u0005\u0001\u0000\u0000*+\u0003\f\u0006\u0000+,\u0003"+
		"\n\u0005\u0000,.\u0001\u0000\u0000\u0000-(\u0001\u0000\u0000\u0000.1\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"04\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u0002\u0000"+
		"\u000035\u0003\n\u0005\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u00005\t\u0001\u0000\u0000\u000067\u0005\u000b\u0000\u000078\u0003\u0002"+
		"\u0001\u000089\u0005\f\u0000\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005"+
		"\t\u0000\u0000;<\u0003\u000e\u0007\u0000<=\u0005\n\u0000\u0000=\r\u0001"+
		"\u0000\u0000\u0000>?\u0006\u0007\uffff\uffff\u0000?@\u0005\t\u0000\u0000"+
		"@A\u0003\u000e\u0007\u0000AB\u0005\n\u0000\u0000BG\u0001\u0000\u0000\u0000"+
		"CD\u0005\r\u0000\u0000DG\u0003\u000e\u0007\u0003EG\u0007\u0000\u0000\u0000"+
		"F>\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000"+
		"\u0000GM\u0001\u0000\u0000\u0000HI\n\u0002\u0000\u0000IJ\u0007\u0001\u0000"+
		"\u0000JL\u0003\u000e\u0007\u0003KH\u0001\u0000\u0000\u0000LO\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u000f"+
		"\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PR\u0005\u0004\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000ST\u0005\u0005\u0000\u0000TU\u0005\u0017\u0000\u0000UW\u0007"+
		"\u0000\u0000\u0000VQ\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XZ\u0005\u0018\u0000\u0000YV\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0006\t\uffff\uffff\u0000"+
		"^_\u0005\t\u0000\u0000_`\u0003\u0012\t\u0000`a\u0005\n\u0000\u0000ad\u0001"+
		"\u0000\u0000\u0000bd\u0007\u0002\u0000\u0000c]\u0001\u0000\u0000\u0000"+
		"cb\u0001\u0000\u0000\u0000dj\u0001\u0000\u0000\u0000ef\n\u0002\u0000\u0000"+
		"fg\u0007\u0003\u0000\u0000gi\u0003\u0012\t\u0003he\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000k\u0013\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000\u000b"+
		"\u001c\u001e/4FMQV[cj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}