// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.9.2
package antlr4;

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathChildren(XPathGrammarParser.XpathChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathAll(XPathGrammarParser.XpathAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XPathGrammarParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentName(XPathGrammarParser.DocumentNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildrenRP(XPathGrammarParser.ChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedRP(XPathGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentOfContext(XPathGrammarParser.ParentOfContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantsRP(XPathGrammarParser.DescendantsRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(XPathGrammarParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(XPathGrammarParser.AttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatRP(XPathGrammarParser.ConcatRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildCard(XPathGrammarParser.WildCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentContext(XPathGrammarParser.CurrentContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetText(XPathGrammarParser.GetTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEqualitySym(XPathGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityEqualitySym(XPathGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityEqualityWord(XPathGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XPathGrammarParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantEquality(XPathGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFilter(XPathGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEqualityWord(XPathGrammarParser.ValueEqualityWordContext ctx);
}