// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.9.2
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
public class XPathGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		DOC=18, LPR=19, RPR=20, STRING=21, IDENTIFIER=22, WS=23;
	public static final int
		RULE_ap = 0, RULE_docName = 1, RULE_rp = 2, RULE_f = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "docName", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", 
			"']'", "','", "'='", "'eq'", "'=='", "'is'", "'and'", "'or'", "'not'", 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "DOC", "LPR", "RPR", "STRING", "IDENTIFIER", 
			"WS"
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
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterXpathAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitXpathAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitXpathAll(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterXpathChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitXpathChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitXpathChildren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new XpathChildrenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				docName();
				setState(9);
				match(T__0);
				setState(10);
				rp(0);
				}
				break;
			case 2:
				_localctx = new XpathAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				docName();
				setState(13);
				match(T__1);
				setState(14);
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
		public TerminalNode DOC() { return getToken(XPathGrammarParser.DOC, 0); }
		public TerminalNode LPR() { return getToken(XPathGrammarParser.LPR, 0); }
		public TerminalNode STRING() { return getToken(XPathGrammarParser.STRING, 0); }
		public TerminalNode RPR() { return getToken(XPathGrammarParser.RPR, 0); }
		public DocumentNameContext(DocNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterDocumentName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitDocumentName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitDocumentName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocNameContext docName() throws RecognitionException {
		DocNameContext _localctx = new DocNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_docName);
		try {
			_localctx = new DocumentNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(DOC);
			setState(19);
			match(LPR);
			setState(20);
			match(STRING);
			setState(21);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterChildrenRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitChildrenRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitChildrenRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedRPContext extends RpContext {
		public TerminalNode LPR() { return getToken(XPathGrammarParser.LPR, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XPathGrammarParser.RPR, 0); }
		public ParenthesizedRPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterParenthesizedRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitParenthesizedRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitParenthesizedRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagNameContext extends RpContext {
		public TerminalNode IDENTIFIER() { return getToken(XPathGrammarParser.IDENTIFIER, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentOfContextContext extends RpContext {
		public ParentOfContextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterParentOfContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitParentOfContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitParentOfContext(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterDescendantsRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitDescendantsRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitDescendantsRP(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterFilterRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitFilterRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitFilterRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeNameContext extends RpContext {
		public TerminalNode IDENTIFIER() { return getToken(XPathGrammarParser.IDENTIFIER, 0); }
		public AttributeNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitAttributeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitAttributeName(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterConcatRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitConcatRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitConcatRP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WildCardContext extends RpContext {
		public WildCardContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterWildCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitWildCard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitWildCard(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentContextContext extends RpContext {
		public CurrentContextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterCurrentContext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitCurrentContext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitCurrentContext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetTextContext extends RpContext {
		public GetTextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterGetText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitGetText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitGetText(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(24);
				match(IDENTIFIER);
				}
				break;
			case T__2:
				{
				_localctx = new WildCardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new CurrentContextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new ParentOfContextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(T__4);
				}
				break;
			case T__5:
				{
				_localctx = new GetTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new AttributeNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(T__6);
				setState(30);
				match(IDENTIFIER);
				}
				break;
			case LPR:
				{
				_localctx = new ParenthesizedRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(LPR);
				setState(32);
				rp(0);
				setState(33);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(51);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ChildrenRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(37);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(38);
						match(T__0);
						setState(39);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new DescendantsRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(40);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(41);
						match(T__1);
						setState(42);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new ConcatRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(43);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(44);
						match(T__9);
						setState(45);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(46);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(47);
						match(T__7);
						setState(48);
						f(0);
						setState(49);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterValueEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitValueEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitValueEqualitySym(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterIdentityEqualitySym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitIdentityEqualitySym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitIdentityEqualitySym(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterAndFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitAndFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitAndFilter(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterFilteredRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitFilteredRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitFilteredRP(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterNotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitNotFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitNotFilter(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterIdentityEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitIdentityEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitIdentityEqualityWord(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterOrFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitOrFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitOrFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantEqualityContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathGrammarParser.STRING, 0); }
		public ConstantEqualityContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterConstantEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitConstantEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitConstantEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedFilterContext extends FContext {
		public TerminalNode LPR() { return getToken(XPathGrammarParser.LPR, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode RPR() { return getToken(XPathGrammarParser.RPR, 0); }
		public ParenthesizedFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterParenthesizedFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitParenthesizedFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitParenthesizedFilter(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterValueEqualityWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitValueEqualityWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitValueEqualityWord(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new FilteredRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(57);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new ValueEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				rp(0);
				setState(59);
				match(T__10);
				setState(60);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new ValueEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				rp(0);
				setState(63);
				match(T__11);
				setState(64);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new IdentityEqualitySymContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				rp(0);
				setState(67);
				match(T__12);
				setState(68);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new IdentityEqualityWordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				rp(0);
				setState(71);
				match(T__13);
				setState(72);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new ConstantEqualityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				rp(0);
				setState(75);
				match(T__10);
				setState(76);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new ParenthesizedFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(LPR);
				setState(79);
				f(0);
				setState(80);
				match(RPR);
				}
				break;
			case 8:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(T__16);
				setState(83);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(86);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(87);
						match(T__14);
						setState(88);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(89);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(90);
						match(T__15);
						setState(91);
						f(3);
						}
						break;
					}
					} 
				}
				setState(96);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 3:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4&\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\66\n\4\f"+
		"\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5W\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5_\n\5\f\5\16\5b\13\5\3\5\2\4\6\b\6\2\4\6\b\2\2"+
		"\2s\2\22\3\2\2\2\4\24\3\2\2\2\6%\3\2\2\2\bV\3\2\2\2\n\13\5\4\3\2\13\f"+
		"\7\3\2\2\f\r\5\6\4\2\r\23\3\2\2\2\16\17\5\4\3\2\17\20\7\4\2\2\20\21\5"+
		"\6\4\2\21\23\3\2\2\2\22\n\3\2\2\2\22\16\3\2\2\2\23\3\3\2\2\2\24\25\7\24"+
		"\2\2\25\26\7\25\2\2\26\27\7\27\2\2\27\30\7\26\2\2\30\5\3\2\2\2\31\32\b"+
		"\4\1\2\32&\7\30\2\2\33&\7\5\2\2\34&\7\6\2\2\35&\7\7\2\2\36&\7\b\2\2\37"+
		" \7\t\2\2 &\7\30\2\2!\"\7\25\2\2\"#\5\6\4\2#$\7\26\2\2$&\3\2\2\2%\31\3"+
		"\2\2\2%\33\3\2\2\2%\34\3\2\2\2%\35\3\2\2\2%\36\3\2\2\2%\37\3\2\2\2%!\3"+
		"\2\2\2&\67\3\2\2\2\'(\f\6\2\2()\7\3\2\2)\66\5\6\4\7*+\f\5\2\2+,\7\4\2"+
		"\2,\66\5\6\4\6-.\f\3\2\2./\7\f\2\2/\66\5\6\4\4\60\61\f\4\2\2\61\62\7\n"+
		"\2\2\62\63\5\b\5\2\63\64\7\13\2\2\64\66\3\2\2\2\65\'\3\2\2\2\65*\3\2\2"+
		"\2\65-\3\2\2\2\65\60\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7"+
		"\3\2\2\29\67\3\2\2\2:;\b\5\1\2;W\5\6\4\2<=\5\6\4\2=>\7\r\2\2>?\5\6\4\2"+
		"?W\3\2\2\2@A\5\6\4\2AB\7\16\2\2BC\5\6\4\2CW\3\2\2\2DE\5\6\4\2EF\7\17\2"+
		"\2FG\5\6\4\2GW\3\2\2\2HI\5\6\4\2IJ\7\20\2\2JK\5\6\4\2KW\3\2\2\2LM\5\6"+
		"\4\2MN\7\r\2\2NO\7\27\2\2OW\3\2\2\2PQ\7\25\2\2QR\5\b\5\2RS\7\26\2\2SW"+
		"\3\2\2\2TU\7\23\2\2UW\5\b\5\3V:\3\2\2\2V<\3\2\2\2V@\3\2\2\2VD\3\2\2\2"+
		"VH\3\2\2\2VL\3\2\2\2VP\3\2\2\2VT\3\2\2\2W`\3\2\2\2XY\f\5\2\2YZ\7\21\2"+
		"\2Z_\5\b\5\6[\\\f\4\2\2\\]\7\22\2\2]_\5\b\5\5^X\3\2\2\2^[\3\2\2\2_b\3"+
		"\2\2\2`^\3\2\2\2`a\3\2\2\2a\t\3\2\2\2b`\3\2\2\2\t\22%\65\67V^`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}