// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.9.2
package antlr4;

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathGrammarParser}.
 */
public interface XPathGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterXpathChildren(XPathGrammarParser.XpathChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitXpathChildren(XPathGrammarParser.XpathChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterXpathAll(XPathGrammarParser.XpathAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitXpathAll(XPathGrammarParser.XpathAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XPathGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocumentName(XPathGrammarParser.DocumentNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XPathGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocumentName(XPathGrammarParser.DocumentNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterChildrenRP(XPathGrammarParser.ChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitChildrenRP(XPathGrammarParser.ChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedRP(XPathGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedRP(XPathGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentOfContext(XPathGrammarParser.ParentOfContextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentOfContext(XPathGrammarParser.ParentOfContextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDescendantsRP(XPathGrammarParser.DescendantsRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDescendantsRP(XPathGrammarParser.DescendantsRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(XPathGrammarParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(XPathGrammarParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(XPathGrammarParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(XPathGrammarParser.AttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterConcatRP(XPathGrammarParser.ConcatRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitConcatRP(XPathGrammarParser.ConcatRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterWildCard(XPathGrammarParser.WildCardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitWildCard(XPathGrammarParser.WildCardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrentContext(XPathGrammarParser.CurrentContextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrentContext(XPathGrammarParser.CurrentContextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterGetText(XPathGrammarParser.GetTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitGetText(XPathGrammarParser.GetTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterValueEqualitySym(XPathGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitValueEqualitySym(XPathGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIdentityEqualitySym(XPathGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIdentityEqualitySym(XPathGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIdentityEqualityWord(XPathGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIdentityEqualityWord(XPathGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XPathGrammarParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XPathGrammarParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantEquality(XPathGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantEquality(XPathGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedFilter(XPathGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedFilter(XPathGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterValueEqualityWord(XPathGrammarParser.ValueEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitValueEqualityWord(XPathGrammarParser.ValueEqualityWordContext ctx);
}