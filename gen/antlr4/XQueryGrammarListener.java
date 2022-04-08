// Generated from /Users/juzer/Downloads/MS-Homeworks:Assignments/WINTER-2022/CSE232B/CSE232BProject/src/main/resources/antlr4/XQueryGrammar.g4 by ANTLR 4.9.2
package antlr4;

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryGrammarParser}.
 */
public interface XQueryGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code XqueryRelativePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryRelativePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryAbsolutePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryAbsolutePath}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQueryJoin}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQueryJoin(XQueryGrammarParser.XQueryJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQueryJoin}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQueryJoin(XQueryGrammarParser.XQueryJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryFLWR}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryFLWR}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryConcat}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryConcat}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryVariable}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryVariable}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryTag}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryTag(XQueryGrammarParser.XqueryTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryTag}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryTag(XQueryGrammarParser.XqueryTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedXquery}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedXquery(XQueryGrammarParser.ParenthesizedXqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedXquery}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedXquery(XQueryGrammarParser.ParenthesizedXqueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryAll}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryAll(XQueryGrammarParser.XqueryAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryAll}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryAll(XQueryGrammarParser.XqueryAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryLetClause}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryLetClause}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqueryStringConstant}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqueryStringConstant}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#joinAttributes}.
	 * @param ctx the parse tree
	 */
	void enterJoinAttributes(XQueryGrammarParser.JoinAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#joinAttributes}.
	 * @param ctx the parse tree
	 */
	void exitJoinAttributes(XQueryGrammarParser.JoinAttributesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionAnd}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionAnd(XQueryGrammarParser.ConditionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionAnd}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionAnd(XQueryGrammarParser.ConditionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionSome}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionSome(XQueryGrammarParser.ConditionSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionSome}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionIdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionIdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionOr}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionOr(XQueryGrammarParser.ConditionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionOr}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionOr(XQueryGrammarParser.ConditionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionNot}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionNot(XQueryGrammarParser.ConditionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionNot}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionNot(XQueryGrammarParser.ConditionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionIdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionIdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionEmpty}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionEmpty}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedCondition}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedCondition(XQueryGrammarParser.ParenthesizedConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedCondition}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedCondition(XQueryGrammarParser.ParenthesizedConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterXpathChildren(XQueryGrammarParser.XpathChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XpathChildren}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitXpathChildren(XQueryGrammarParser.XpathChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterXpathAll(XQueryGrammarParser.XpathAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XpathAll}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitXpathAll(XQueryGrammarParser.XpathAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XQueryGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocumentName(XQueryGrammarParser.DocumentNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DocumentName}
	 * labeled alternative in {@link XQueryGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocumentName(XQueryGrammarParser.DocumentNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterChildrenRP(XQueryGrammarParser.ChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitChildrenRP(XQueryGrammarParser.ChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedRP(XQueryGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedRP(XQueryGrammarParser.ParenthesizedRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentOfContext(XQueryGrammarParser.ParentOfContextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentOfContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentOfContext(XQueryGrammarParser.ParentOfContextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDescendantsRP(XQueryGrammarParser.DescendantsRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DescendantsRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDescendantsRP(XQueryGrammarParser.DescendantsRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(XQueryGrammarParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(XQueryGrammarParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(XQueryGrammarParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(XQueryGrammarParser.AttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterConcatRP(XQueryGrammarParser.ConcatRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitConcatRP(XQueryGrammarParser.ConcatRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterWildCard(XQueryGrammarParser.WildCardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitWildCard(XQueryGrammarParser.WildCardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrentContext(XQueryGrammarParser.CurrentContextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CurrentContext}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrentContext(XQueryGrammarParser.CurrentContextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterGetText(XQueryGrammarParser.GetTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitGetText(XQueryGrammarParser.GetTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterValueEqualitySym(XQueryGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitValueEqualitySym(XQueryGrammarParser.ValueEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIdentityEqualitySym(XQueryGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentityEqualitySym}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIdentityEqualitySym(XQueryGrammarParser.IdentityEqualitySymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIdentityEqualityWord(XQueryGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentityEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIdentityEqualityWord(XQueryGrammarParser.IdentityEqualityWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XQueryGrammarParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XQueryGrammarParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantEquality(XQueryGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantEquality}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantEquality(XQueryGrammarParser.ConstantEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedFilter(XQueryGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedFilter(XQueryGrammarParser.ParenthesizedFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterValueEqualityWord(XQueryGrammarParser.ValueEqualityWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueEqualityWord}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitValueEqualityWord(XQueryGrammarParser.ValueEqualityWordContext ctx);
}