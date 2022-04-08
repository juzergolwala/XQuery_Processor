// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XQueryGrammar.g4 by ANTLR 4.9.2
package antlr4;

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code XqueryRelativePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryAbsolutePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQueryJoin}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQueryJoin(XQueryGrammarParser.XQueryJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryFLWR}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryConcat}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryVariable}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryTag}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryTag(XQueryGrammarParser.XqueryTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedXquery}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedXquery(XQueryGrammarParser.ParenthesizedXqueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryAll}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryAll(XQueryGrammarParser.XqueryAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryLetClause}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqueryStringConstant}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#joinAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinAttributes(XQueryGrammarParser.JoinAttributesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionAnd}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAnd(XQueryGrammarParser.ConditionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionSome}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionIdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionOr}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOr(XQueryGrammarParser.ConditionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionNot}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNot(XQueryGrammarParser.ConditionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionIdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionEmpty}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedCondition}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedCondition(XQueryGrammarParser.ParenthesizedConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathChildren(XQueryGrammarParser.XpathChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpathAll(XQueryGrammarParser.XpathAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XQueryGrammarParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentName(XQueryGrammarParser.DocumentNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildrenRP(XQueryGrammarParser.ChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedRP(XQueryGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentOfContext(XQueryGrammarParser.ParentOfContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantsRP(XQueryGrammarParser.DescendantsRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(XQueryGrammarParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(XQueryGrammarParser.AttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatRP(XQueryGrammarParser.ConcatRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildCard(XQueryGrammarParser.WildCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentContext(XQueryGrammarParser.CurrentContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetText(XQueryGrammarParser.GetTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEqualitySym(XQueryGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityEqualitySym(XQueryGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityEqualityWord(XQueryGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryGrammarParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantEquality(XQueryGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFilter(XQueryGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEqualityWord(XQueryGrammarParser.ValueEqualityWordContext ctx);
}