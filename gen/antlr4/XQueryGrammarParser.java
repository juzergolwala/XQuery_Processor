// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XQueryGrammar.g4 by ANTLR 4.9.2
package antlr4;

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, VARIABLE=33, DOC=34, LPR=35, RPR=36, STRING=37, IDENTIFIER=38, 
		WS=39;
	public static final int
		RULE_xq = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_joinAttributes = 5, RULE_cond = 6, RULE_ap = 7, 
		RULE_docName = 8, RULE_rp = 9, RULE_f = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "forClause", "letClause", "whereClause", "returnClause", "joinAttributes", 
			"cond", "ap", "docName", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", "'</'", "'join'", 
			"'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'['", "']'", 
			"'='", "'eq'", "'=='", "'is'", "'empty'", "'some'", "'satisfies'", "'and'", 
			"'or'", "'not'", "'*'", "'.'", "'..'", "'text()'", "'@'", null, null, 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "VARIABLE", "DOC", 
			"LPR", "RPR", "STRING", "IDENTIFIER", "WS"
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
	public String getGrammarFileName() { return "XQueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqueryRelativePathContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqueryRelativePathContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryRelativePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryRelativePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryRelativePath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryAbsolutePathContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XqueryAbsolutePathContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryAbsolutePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryAbsolutePath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQueryJoinContext extends XqContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<JoinAttributesContext> joinAttributes() {
			return getRuleContexts(JoinAttributesContext.class);
		}
		public JoinAttributesContext joinAttributes(int i) {
			return getRuleContext(JoinAttributesContext.class,i);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public XQueryJoinContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXQueryJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXQueryJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXQueryJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryFLWRContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public XqueryFLWRContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryFLWR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryFLWR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryFLWR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryConcatContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XqueryConcatContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryVariableContext extends XqContext {
		public TerminalNode VARIABLE() { return getToken(XQueryGrammarParser.VARIABLE, 0); }
		public XqueryVariableContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryTagContext extends XqContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(XQueryGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(XQueryGrammarParser.IDENTIFIER, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqueryTagContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryTag(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedXqueryContext extends XqContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public ParenthesizedXqueryContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterParenthesizedXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitParenthesizedXquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitParenthesizedXquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryAllContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqueryAllContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryLetClauseContext extends XqContext {
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqueryLetClauseContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryLetClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqueryStringConstantContext extends XqContext {
		public TerminalNode STRING() { return getToken(XQueryGrammarParser.STRING, 0); }
		public XqueryStringConstantContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXqueryStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXqueryStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXqueryStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				{
				_localctx = new XqueryVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23);
				match(VARIABLE);
				}
				break;
			case STRING:
				{
				_localctx = new XqueryStringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(STRING);
				}
				break;
			case DOC:
				{
				_localctx = new XqueryAbsolutePathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				ap();
				}
				break;
			case LPR:
				{
				_localctx = new ParenthesizedXqueryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(LPR);
				setState(27);
				xq(0);
				setState(28);
				match(RPR);
				}
				break;
			case T__3:
				{
				_localctx = new XqueryTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__3);
				setState(31);
				match(IDENTIFIER);
				setState(32);
				match(T__4);
				setState(33);
				match(T__5);
				setState(34);
				xq(0);
				setState(35);
				match(T__6);
				setState(36);
				match(T__7);
				setState(37);
				match(IDENTIFIER);
				setState(38);
				match(T__4);
				}
				break;
			case T__8:
				{
				_localctx = new XQueryJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(T__8);
				setState(41);
				match(LPR);
				setState(42);
				xq(0);
				setState(43);
				match(T__0);
				setState(44);
				xq(0);
				setState(45);
				match(T__0);
				setState(46);
				joinAttributes();
				setState(47);
				match(T__0);
				setState(48);
				joinAttributes();
				setState(49);
				match(RPR);
				}
				break;
			case T__9:
				{
				_localctx = new XqueryFLWRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				forClause();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(52);
					letClause();
					}
				}

				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(55);
					whereClause();
					}
				}

				setState(58);
				returnClause();
				}
				break;
			case T__11:
				{
				_localctx = new XqueryLetClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				letClause();
				setState(61);
				xq(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(74);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqueryConcatContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(65);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(66);
						match(T__0);
						setState(67);
						xq(8);
						}
						break;
					case 2:
						{
						_localctx = new XqueryRelativePathContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(68);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(69);
						match(T__1);
						setState(70);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqueryAllContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(71);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(72);
						match(T__2);
						setState(73);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ForClauseContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(XQueryGrammarParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(XQueryGrammarParser.VARIABLE, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__9);
			setState(80);
			match(VARIABLE);
			setState(81);
			match(T__10);
			setState(82);
			xq(0);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(83);
				match(T__0);
				setState(84);
				match(VARIABLE);
				setState(85);
				match(T__10);
				setState(86);
				xq(0);
				}
				}
				setState(91);
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(XQueryGrammarParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(XQueryGrammarParser.VARIABLE, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__11);
			setState(93);
			match(VARIABLE);
			setState(94);
			match(T__12);
			setState(95);
			xq(0);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(96);
				match(T__0);
				setState(97);
				match(VARIABLE);
				setState(98);
				match(T__12);
				setState(99);
				xq(0);
				}
				}
				setState(104);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__13);
			setState(106);
			cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__14);
			setState(109);
			xq(0);
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

	public static class JoinAttributesContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(XQueryGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(XQueryGrammarParser.IDENTIFIER, i);
		}
		public JoinAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterJoinAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitJoinAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitJoinAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinAttributesContext joinAttributes() throws RecognitionException {
		JoinAttributesContext _localctx = new JoinAttributesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_joinAttributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__15);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(112);
				match(IDENTIFIER);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(113);
					match(T__0);
					setState(114);
					match(IDENTIFIER);
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(122);
			match(T__16);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionAndContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public ConditionAndContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionSomeContext extends CondContext {
		public List<TerminalNode> VARIABLE() { return getTokens(XQueryGrammarParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(XQueryGrammarParser.VARIABLE, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ConditionSomeContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionIdentityEqualityWordContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ConditionIdentityEqualityWordContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionIdentityEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionIdentityEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionIdentityEqualityWord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionOrContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public ConditionOrContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionNotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ConditionNotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionIdentityEqualitySymContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ConditionIdentityEqualitySymContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionIdentityEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionIdentityEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionIdentityEqualitySym(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionEmptyContext extends CondContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public ConditionEmptyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionValueEqualitySymContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ConditionValueEqualitySymContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionValueEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionValueEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionValueEqualitySym(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionValueEqualityWordContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ConditionValueEqualityWordContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConditionValueEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConditionValueEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConditionValueEqualityWord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedConditionContext extends CondContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public ParenthesizedConditionContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterParenthesizedCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitParenthesizedCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitParenthesizedCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionValueEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(125);
				xq(0);
				setState(126);
				match(T__17);
				setState(127);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new ConditionValueEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				xq(0);
				setState(130);
				match(T__18);
				setState(131);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new ConditionIdentityEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				xq(0);
				setState(134);
				match(T__19);
				setState(135);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new ConditionIdentityEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				xq(0);
				setState(138);
				match(T__20);
				setState(139);
				xq(0);
				}
				break;
			case 5:
				{
				_localctx = new ConditionEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(T__21);
				setState(142);
				match(LPR);
				setState(143);
				xq(0);
				setState(144);
				match(RPR);
				}
				break;
			case 6:
				{
				_localctx = new ConditionSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(T__22);
				setState(147);
				match(VARIABLE);
				setState(148);
				match(T__10);
				setState(149);
				xq(0);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(150);
					match(T__0);
					setState(151);
					match(VARIABLE);
					setState(152);
					match(T__10);
					setState(153);
					xq(0);
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				match(T__23);
				setState(160);
				cond(5);
				}
				break;
			case 7:
				{
				_localctx = new ParenthesizedConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(LPR);
				setState(163);
				cond(0);
				setState(164);
				match(RPR);
				}
				break;
			case 8:
				{
				_localctx = new ConditionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(T__26);
				setState(167);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionAndContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(170);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(171);
						match(T__24);
						setState(172);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new ConditionOrContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(173);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(174);
						match(T__25);
						setState(175);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XpathAllContext extends ApContext {
		public DocNameContext docName() {
			return getRuleContext(DocNameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XpathAllContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXpathAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXpathAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXpathAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XpathChildrenContext extends ApContext {
		public DocNameContext docName() {
			return getRuleContext(DocNameContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XpathChildrenContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXpathChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXpathChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXpathChildren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ap);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new XpathChildrenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				docName();
				setState(182);
				match(T__1);
				setState(183);
				rp(0);
				}
				break;
			case 2:
				_localctx = new XpathAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				docName();
				setState(186);
				match(T__2);
				setState(187);
				rp(0);
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

	public static class DocNameContext extends ParserRuleContext {
		public DocNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_docName; }
	 
		public DocNameContext() { }
		public void copyFrom(DocNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DocumentNameContext extends DocNameContext {
		public TerminalNode DOC() { return getToken(XQueryGrammarParser.DOC, 0); }
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public TerminalNode STRING() { return getToken(XQueryGrammarParser.STRING, 0); }
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public DocumentNameContext(DocNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterDocumentName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitDocumentName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitDocumentName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocNameContext docName() throws RecognitionException {
		DocNameContext _localctx = new DocNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_docName);
		try {
			_localctx = new DocumentNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(DOC);
			setState(192);
			match(LPR);
			setState(193);
			match(STRING);
			setState(194);
			match(RPR);
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChildrenRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ChildrenRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterChildrenRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitChildrenRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitChildrenRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedRPContext extends RpContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public ParenthesizedRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterParenthesizedRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitParenthesizedRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitParenthesizedRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagNameContext extends RpContext {
		public TerminalNode IDENTIFIER() { return getToken(XQueryGrammarParser.IDENTIFIER, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentOfContextContext extends RpContext {
		public ParentOfContextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterParentOfContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitParentOfContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitParentOfContext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescendantsRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DescendantsRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterDescendantsRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitDescendantsRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitDescendantsRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FilterRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilterRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterFilterRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitFilterRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitFilterRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeNameContext extends RpContext {
		public TerminalNode IDENTIFIER() { return getToken(XQueryGrammarParser.IDENTIFIER, 0); }
		public AttributeNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitAttributeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitAttributeName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ConcatRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConcatRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConcatRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConcatRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WildCardContext extends RpContext {
		public WildCardContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterWildCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitWildCard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitWildCard(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentContextContext extends RpContext {
		public CurrentContextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterCurrentContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitCurrentContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitCurrentContext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetTextContext extends RpContext {
		public GetTextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterGetText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitGetText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitGetText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197);
				match(IDENTIFIER);
				}
				break;
			case T__27:
				{
				_localctx = new WildCardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(T__27);
				}
				break;
			case T__28:
				{
				_localctx = new CurrentContextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(T__28);
				}
				break;
			case T__29:
				{
				_localctx = new ParentOfContextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(T__29);
				}
				break;
			case T__30:
				{
				_localctx = new GetTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(T__30);
				}
				break;
			case T__31:
				{
				_localctx = new AttributeNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(T__31);
				setState(203);
				match(IDENTIFIER);
				}
				break;
			case LPR:
				{
				_localctx = new ParenthesizedRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(LPR);
				setState(205);
				rp(0);
				setState(206);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(224);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ChildrenRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(210);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(211);
						match(T__1);
						setState(212);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new DescendantsRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(213);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(214);
						match(T__2);
						setState(215);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new ConcatRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(216);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(217);
						match(T__0);
						setState(218);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(219);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(220);
						match(T__15);
						setState(221);
						f(0);
						setState(222);
						match(T__16);
						}
						break;
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueEqualitySymContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ValueEqualitySymContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterValueEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitValueEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitValueEqualitySym(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentityEqualitySymContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IdentityEqualitySymContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterIdentityEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitIdentityEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitIdentityEqualitySym(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterAndFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitAndFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitAndFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FilteredRPContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FilteredRPContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterFilteredRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitFilteredRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitFilteredRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterNotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitNotFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitNotFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentityEqualityWordContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IdentityEqualityWordContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterIdentityEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitIdentityEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitIdentityEqualityWord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterOrFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitOrFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitOrFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantEqualityContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XQueryGrammarParser.STRING, 0); }
		public ConstantEqualityContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterConstantEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitConstantEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitConstantEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedFilterContext extends FContext {
		public TerminalNode LPR() { return getToken(XQueryGrammarParser.LPR, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XQueryGrammarParser.RPR, 0); }
		public ParenthesizedFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterParenthesizedFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitParenthesizedFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitParenthesizedFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueEqualityWordContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ValueEqualityWordContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterValueEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitValueEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitValueEqualityWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new FilteredRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(230);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new ValueEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				rp(0);
				setState(232);
				match(T__17);
				setState(233);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new ValueEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				rp(0);
				setState(236);
				match(T__18);
				setState(237);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new IdentityEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				rp(0);
				setState(240);
				match(T__19);
				setState(241);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new IdentityEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				rp(0);
				setState(244);
				match(T__20);
				setState(245);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new ConstantEqualityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				rp(0);
				setState(248);
				match(T__17);
				setState(249);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new ParenthesizedFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(LPR);
				setState(252);
				f(0);
				setState(253);
				match(RPR);
				}
				break;
			case 8:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(T__26);
				setState(256);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(265);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(259);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(260);
						match(T__24);
						setState(261);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(262);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(263);
						match(T__25);
						setState(264);
						f(3);
						}
						break;
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 6:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 9:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 10:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0111\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2"+
		"8\n\2\3\2\5\2;\n\2\3\2\3\2\3\2\3\2\3\2\5\2B\n\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3Z\n\3\f\3\16\3]\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4g\n\4\f\4"+
		"\16\4j\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7v\n\7\f\7\16\7"+
		"y\13\7\5\7{\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u009d\n\b\f\b\16\b\u00a0\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u00ab\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b3\n\b\f\b\16\b\u00b6"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c0\n\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d3"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00e3\n\13\f\13\16\13\u00e6\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u0104\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u010c\n\f\f"+
		"\f\16\f\u010f\13\f\3\f\2\6\2\16\24\26\r\2\4\6\b\n\f\16\20\22\24\26\2\2"+
		"\2\u0133\2A\3\2\2\2\4Q\3\2\2\2\6^\3\2\2\2\bk\3\2\2\2\nn\3\2\2\2\fq\3\2"+
		"\2\2\16\u00aa\3\2\2\2\20\u00bf\3\2\2\2\22\u00c1\3\2\2\2\24\u00d2\3\2\2"+
		"\2\26\u0103\3\2\2\2\30\31\b\2\1\2\31B\7#\2\2\32B\7\'\2\2\33B\5\20\t\2"+
		"\34\35\7%\2\2\35\36\5\2\2\2\36\37\7&\2\2\37B\3\2\2\2 !\7\6\2\2!\"\7(\2"+
		"\2\"#\7\7\2\2#$\7\b\2\2$%\5\2\2\2%&\7\t\2\2&\'\7\n\2\2\'(\7(\2\2()\7\7"+
		"\2\2)B\3\2\2\2*+\7\13\2\2+,\7%\2\2,-\5\2\2\2-.\7\3\2\2./\5\2\2\2/\60\7"+
		"\3\2\2\60\61\5\f\7\2\61\62\7\3\2\2\62\63\5\f\7\2\63\64\7&\2\2\64B\3\2"+
		"\2\2\65\67\5\4\3\2\668\5\6\4\2\67\66\3\2\2\2\678\3\2\2\28:\3\2\2\29;\5"+
		"\b\5\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\5\n\6\2=B\3\2\2\2>?\5\6\4\2?@\5"+
		"\2\2\3@B\3\2\2\2A\30\3\2\2\2A\32\3\2\2\2A\33\3\2\2\2A\34\3\2\2\2A \3\2"+
		"\2\2A*\3\2\2\2A\65\3\2\2\2A>\3\2\2\2BN\3\2\2\2CD\f\t\2\2DE\7\3\2\2EM\5"+
		"\2\2\nFG\f\b\2\2GH\7\4\2\2HM\5\24\13\2IJ\f\7\2\2JK\7\5\2\2KM\5\24\13\2"+
		"LC\3\2\2\2LF\3\2\2\2LI\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\3\3\2\2"+
		"\2PN\3\2\2\2QR\7\f\2\2RS\7#\2\2ST\7\r\2\2T[\5\2\2\2UV\7\3\2\2VW\7#\2\2"+
		"WX\7\r\2\2XZ\5\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\5\3\2"+
		"\2\2][\3\2\2\2^_\7\16\2\2_`\7#\2\2`a\7\17\2\2ah\5\2\2\2bc\7\3\2\2cd\7"+
		"#\2\2de\7\17\2\2eg\5\2\2\2fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\7"+
		"\3\2\2\2jh\3\2\2\2kl\7\20\2\2lm\5\16\b\2m\t\3\2\2\2no\7\21\2\2op\5\2\2"+
		"\2p\13\3\2\2\2qz\7\22\2\2rw\7(\2\2st\7\3\2\2tv\7(\2\2us\3\2\2\2vy\3\2"+
		"\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zr\3\2\2\2z{\3\2\2\2{|\3\2"+
		"\2\2|}\7\23\2\2}\r\3\2\2\2~\177\b\b\1\2\177\u0080\5\2\2\2\u0080\u0081"+
		"\7\24\2\2\u0081\u0082\5\2\2\2\u0082\u00ab\3\2\2\2\u0083\u0084\5\2\2\2"+
		"\u0084\u0085\7\25\2\2\u0085\u0086\5\2\2\2\u0086\u00ab\3\2\2\2\u0087\u0088"+
		"\5\2\2\2\u0088\u0089\7\26\2\2\u0089\u008a\5\2\2\2\u008a\u00ab\3\2\2\2"+
		"\u008b\u008c\5\2\2\2\u008c\u008d\7\27\2\2\u008d\u008e\5\2\2\2\u008e\u00ab"+
		"\3\2\2\2\u008f\u0090\7\30\2\2\u0090\u0091\7%\2\2\u0091\u0092\5\2\2\2\u0092"+
		"\u0093\7&\2\2\u0093\u00ab\3\2\2\2\u0094\u0095\7\31\2\2\u0095\u0096\7#"+
		"\2\2\u0096\u0097\7\r\2\2\u0097\u009e\5\2\2\2\u0098\u0099\7\3\2\2\u0099"+
		"\u009a\7#\2\2\u009a\u009b\7\r\2\2\u009b\u009d\5\2\2\2\u009c\u0098\3\2"+
		"\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\32\2\2\u00a2\u00a3\5"+
		"\16\b\7\u00a3\u00ab\3\2\2\2\u00a4\u00a5\7%\2\2\u00a5\u00a6\5\16\b\2\u00a6"+
		"\u00a7\7&\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00a9\7\35\2\2\u00a9\u00ab\5\16"+
		"\b\3\u00aa~\3\2\2\2\u00aa\u0083\3\2\2\2\u00aa\u0087\3\2\2\2\u00aa\u008b"+
		"\3\2\2\2\u00aa\u008f\3\2\2\2\u00aa\u0094\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00b4\3\2\2\2\u00ac\u00ad\f\5\2\2\u00ad\u00ae\7\33"+
		"\2\2\u00ae\u00b3\5\16\b\6\u00af\u00b0\f\4\2\2\u00b0\u00b1\7\34\2\2\u00b1"+
		"\u00b3\5\16\b\5\u00b2\u00ac\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3\u00b6\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\17\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00b9\7\4\2\2\u00b9\u00ba\5"+
		"\24\13\2\u00ba\u00c0\3\2\2\2\u00bb\u00bc\5\22\n\2\u00bc\u00bd\7\5\2\2"+
		"\u00bd\u00be\5\24\13\2\u00be\u00c0\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00bb"+
		"\3\2\2\2\u00c0\21\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\u00c3\7%\2\2\u00c3"+
		"\u00c4\7\'\2\2\u00c4\u00c5\7&\2\2\u00c5\23\3\2\2\2\u00c6\u00c7\b\13\1"+
		"\2\u00c7\u00d3\7(\2\2\u00c8\u00d3\7\36\2\2\u00c9\u00d3\7\37\2\2\u00ca"+
		"\u00d3\7 \2\2\u00cb\u00d3\7!\2\2\u00cc\u00cd\7\"\2\2\u00cd\u00d3\7(\2"+
		"\2\u00ce\u00cf\7%\2\2\u00cf\u00d0\5\24\13\2\u00d0\u00d1\7&\2\2\u00d1\u00d3"+
		"\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2"+
		"\u00ca\3\2\2\2\u00d2\u00cb\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00ce\3\2"+
		"\2\2\u00d3\u00e4\3\2\2\2\u00d4\u00d5\f\6\2\2\u00d5\u00d6\7\4\2\2\u00d6"+
		"\u00e3\5\24\13\7\u00d7\u00d8\f\5\2\2\u00d8\u00d9\7\5\2\2\u00d9\u00e3\5"+
		"\24\13\6\u00da\u00db\f\3\2\2\u00db\u00dc\7\3\2\2\u00dc\u00e3\5\24\13\4"+
		"\u00dd\u00de\f\4\2\2\u00de\u00df\7\22\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1"+
		"\7\23\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00d4\3\2\2\2\u00e2\u00d7\3\2\2\2"+
		"\u00e2\u00da\3\2\2\2\u00e2\u00dd\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\25\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e8\b\f\1\2\u00e8\u0104\5\24\13\2\u00e9\u00ea\5\24\13\2\u00ea\u00eb"+
		"\7\24\2\2\u00eb\u00ec\5\24\13\2\u00ec\u0104\3\2\2\2\u00ed\u00ee\5\24\13"+
		"\2\u00ee\u00ef\7\25\2\2\u00ef\u00f0\5\24\13\2\u00f0\u0104\3\2\2\2\u00f1"+
		"\u00f2\5\24\13\2\u00f2\u00f3\7\26\2\2\u00f3\u00f4\5\24\13\2\u00f4\u0104"+
		"\3\2\2\2\u00f5\u00f6\5\24\13\2\u00f6\u00f7\7\27\2\2\u00f7\u00f8\5\24\13"+
		"\2\u00f8\u0104\3\2\2\2\u00f9\u00fa\5\24\13\2\u00fa\u00fb\7\24\2\2\u00fb"+
		"\u00fc\7\'\2\2\u00fc\u0104\3\2\2\2\u00fd\u00fe\7%\2\2\u00fe\u00ff\5\26"+
		"\f\2\u00ff\u0100\7&\2\2\u0100\u0104\3\2\2\2\u0101\u0102\7\35\2\2\u0102"+
		"\u0104\5\26\f\3\u0103\u00e7\3\2\2\2\u0103\u00e9\3\2\2\2\u0103\u00ed\3"+
		"\2\2\2\u0103\u00f1\3\2\2\2\u0103\u00f5\3\2\2\2\u0103\u00f9\3\2\2\2\u0103"+
		"\u00fd\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u010d\3\2\2\2\u0105\u0106\f\5"+
		"\2\2\u0106\u0107\7\33\2\2\u0107\u010c\5\26\f\6\u0108\u0109\f\4\2\2\u0109"+
		"\u010a\7\34\2\2\u010a\u010c\5\26\f\5\u010b\u0105\3\2\2\2\u010b\u0108\3"+
		"\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\27\3\2\2\2\u010f\u010d\3\2\2\2\26\67:ALN[hwz\u009e\u00aa\u00b2\u00b4"+
		"\u00bf\u00d2\u00e2\u00e4\u0103\u010b\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}