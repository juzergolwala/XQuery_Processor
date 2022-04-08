package edu.ucsd.CSE232B.Milestone3;

//Import required libraries
import edu.ucsd.CSE232B.parsers.XQueryGrammarBaseVisitor;
import edu.ucsd.CSE232B.parsers.XQueryGrammarParser;


/*
   This class transforms the abstract syntax tree of a query into its string representation.
   This class will be used as a base implementation for the RenameVariables and Optimizer classes.
 */
abstract public class VisitorToSerializeXQuery extends XQueryGrammarBaseVisitor<String> {

    /* This function returns the string representation of the variable along the path of current context in the
    abstract syntax tree */
    @Override
    public String visitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx) {
        return ctx.VARIABLE().getText();
    }

    /* This function returns the string representation of the constant along the path of current context in the
    abstract syntax tree */
    @Override
    public String visitXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx) {
        return ctx.STRING().getText();
    }

    /* This function returns the string representation, which is a result of visiting the absolute path
    along the current context in the abstract syntax tree */
    @Override
    public String visitXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx) {
        return visit(ctx.ap());
    }

    /* This function returns the string representation of a parenthesized Xquery by visiting and fetching
    the string representation of the Xquery itself */
    @Override
    public String visitParenthesizedXquery(XQueryGrammarParser.ParenthesizedXqueryContext ctx) {
        return "(" + visit(ctx.xq()) + ")";
    }

    /* This function returns the string representation of Xquery concat rule by visiting and fetching the
    string representation of xq1 and xq2 */
    @Override
    public String visitXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx) {
        return visit(ctx.xq(0)) + "," + visit(ctx.xq(1));
    }

    /* This function returns the string representation of rule for resulting nodes along the relative path
    of a Xquery output list by visiting and fetching the string representation of the Xquery and relative path */
    @Override
    public String visitXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx) {
        return visit(ctx.xq()) + "/" + visit(ctx.rp());
    }

    /* This function returns the string representation of rule for resulting nodes along the descendants or self path
    of a Xquery output list by visiting and fetching the string representation of the Xquery and relative path */
    @Override
    public String visitXqueryAll(XQueryGrammarParser.XqueryAllContext ctx) {
        return visit(ctx.xq()) + "//" + visit(ctx.rp());
    }

    /* This function returns the string representation of XQuery tag rule by fetching the tag names from
    abstract syntax tree and of the Xquery by visiting the Xquery */
    @Override
    public String visitXqueryTag(XQueryGrammarParser.XqueryTagContext ctx) {
        return "<" + ctx.IDENTIFIER(0).getText() + ">{" + visit(ctx.xq()) + "}</"
                + ctx.IDENTIFIER(1).getText() + ">";
    }

    /* This function returns the string representation of XQuery join rule by visiting the argument names
    and join attributes list from abstract syntax tree */
    @Override
    public String visitXQueryJoin(XQueryGrammarParser.XQueryJoinContext ctx) {
        return " join(" + visit(ctx.xq(0)) + "," + visit(ctx.xq(1)) + ","
                + visit(ctx.joinAttributes(0)) + "," + visit(ctx.joinAttributes(1)) + ")";
    }

    /* This function returns the string representation of XQuery let clause by visiting the let clause in the
    current context and the associated Xquery */
    @Override
    public String visitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx) {
        return visit(ctx.letClause()) + " " + visit(ctx.xq());
    }

    /* This function returns string representation of visiting a Xquery FLWR block */
    @Override
    public String visitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx) {
        String query = "";

        //Fetch string representation of visiting the for clause
        query+= visit(ctx.forClause());

        //If let clause is present, fetch the string representation of visiting the let clause
        if(ctx.letClause()!=null){
            query+= visit(ctx.letClause());
        }

        //If where clause is present, fetch the string representation of visiting the where clause
        if(ctx.whereClause()!=null){
            query+= visit(ctx.whereClause());
        }

        //Fetch string representation of visiting the return clause
        query+= visit(ctx.returnClause());

        return query;
    }

    /* This function returns the string representation of visiting the for clause */
    @Override
    public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        String query = " for ";

        //For every variable defined in the for clause
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            /* Append the variable to the string representation by fetching its name from abstract syntax tree
            and visiting the Xquery associated to it */
            query+= ctx.VARIABLE(i).getText() + " in " + visit(ctx.xq(i));

            //If we have not reached the last variable in the for clause, add a comma to the string representation
            if(i!=(ctx.VARIABLE().size()-1)){
                query+= ",";
            }
        }

        return query;
    }

    /* This function returns the string representation of visiting the let clause */
    @Override
    public String visitLetClause(XQueryGrammarParser.LetClauseContext ctx) {
        String query = " let ";

        //For every variable defined in the let clause
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            /* Append the variable to the string representation by fetching its name from abstract syntax tree
            and visiting the Xquery associated to it */
            query+= ctx.VARIABLE(i).getText() + ":=" + visit(ctx.xq(i));

            //If we have not reached the last variable in the let clause, add a comma to the string representation
            if(i!=(ctx.VARIABLE().size()-1)){
                query+= ",";
            }
        }

        return query;
    }

    /* This function returns the string representation of visiting the where clause */
    @Override
    public String visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx) {
        return " where " + visit(ctx.cond());
    }

    /* This function returns the string representation of visiting the return clause */
    @Override
    public String visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx) {
        return "\nreturn " + visit(ctx.xq());
    }

    /* This function returns the string representation of visiting the Join attributes mentioned in the
    Xquery join rule. It fetches the attributes for a given join argument by fetching the string representation
    of the identifiers from abstract syntax tree */
    @Override
    public String visitJoinAttributes(XQueryGrammarParser.JoinAttributesContext ctx) {
        String query = "[";

        //For every attribute of a given argument which is in the join condition
        for(int i=0; i<ctx.IDENTIFIER().size(); i++){

            //Fetch the string representation from abstract syntax tree
            query+= ctx.IDENTIFIER(i).getText();

            //If we have not reached the last attribute, add a comma to the string representation
            if(i!=(ctx.IDENTIFIER().size()-1)){
                query+= ",";
            }
        }

        query+= "]";
        return query;
    }

    /* This function returns the string representation of visiting value equality condition by visiting and fetching
    the string representation of xq1 and xq2 */
    @Override
    public String visitConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx) {
        return visit(ctx.xq(0)) + " = " + visit(ctx.xq(1));
    }

    /* This function returns the string representation of visiting value equality condition by visiting and fetching
    the string representation of xq1 and xq2 */
    @Override
    public String visitConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx) {
        return visit(ctx.xq(0)) + " eq " + visit(ctx.xq(1));
    }

    /* This function returns the string representation of visiting identity equality condition by visiting and fetching
    the string representation of xq1 and xq2 */
    @Override
    public String visitConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx) {
        return visit(ctx.xq(0)) + " == " + visit(ctx.xq(1));
    }

    /* This function returns the string representation of visiting identity equality condition by visiting and fetching
    the string representation of xq1 and xq2 */
    @Override
    public String visitConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx) {
        return visit(ctx.xq(0)) + " is " + visit(ctx.xq(1));

    }

    /* This function returns the string representation of visiting empty condition by visiting and fetching
    the string representation of the xquery associated with it */
    @Override
    public String visitConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx) {
        return " empty(" + visit(ctx.xq()) + ")";
    }

    /* This function returns the string representation of visiting some condition */
    @Override
    public String visitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx) {
        String query = " some ";

        //For every variable declared in the condition
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            /* Append the variable to the string representation by fetching its name from abstract syntax tree
            and visiting the Xquery associated to it */
            query+= ctx.VARIABLE(i).getText() + " in " + visit(ctx.xq(i));

            //If we have not reached the last variable, add a comma to the string representation
            if(i!=(ctx.VARIABLE().size()-1)){
                query+=",";
            }
        }

        //Fetch the string representation of the condition associated to the variables
        query+= " satisfies " + visit(ctx.cond());
        return query;
    }

    /* This function returns the string representation of visiting a parenthesized condition */
    @Override
    public String visitParenthesizedCondition(XQueryGrammarParser.ParenthesizedConditionContext ctx) {
        return "(" + visit(ctx.cond()) + ")";
    }

    /* This function returns the string representation of visiting And condition by visiting and fetching
    the string representation of cond1 and cond2 */
    @Override
    public String visitConditionAnd(XQueryGrammarParser.ConditionAndContext ctx) {
        return visit(ctx.cond(0)) + " and " + visit(ctx.cond(1));
    }

    /* This function returns the string representation of visiting Or condition by visiting and fetching
    the string representation of cond1 and cond2 */
    @Override
    public String visitConditionOr(XQueryGrammarParser.ConditionOrContext ctx) {
        return visit(ctx.cond(0)) + " or " + visit(ctx.cond(1));
    }

    /* This function returns the string representation of visiting Not condition by visiting and fetching
    the string representation of the condition associated with it */
    @Override
    public String visitConditionNot(XQueryGrammarParser.ConditionNotContext ctx) {
        return " not " + visit(ctx.cond());
    }

    /* This function returns the string representation of visiting relative path along the root of the document */
    @Override
    public String visitXpathChildren(XQueryGrammarParser.XpathChildrenContext ctx) {
        return visit(ctx.docName()) + "/" + visit(ctx.rp());
    }

    /* This function returns the string representation of visiting descendants or self nodes along the relative path
    from the root of the document */
    @Override
    public String visitXpathAll(XQueryGrammarParser.XpathAllContext ctx) {
        return visit(ctx.docName()) + "//" + visit(ctx.rp());
    }

    /* This function returns the string representation of Document by fetching the name from abstract
    syntax tree */
    @Override
    public String visitDocumentName(XQueryGrammarParser.DocumentNameContext ctx) {
        return "doc(" + ctx.STRING().getText() + ")";
    }

    /* This function returns the string representation of Tag name used as relative path */
    @Override
    public String visitTagName(XQueryGrammarParser.TagNameContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    /* This function returns string "*" used as wild card for relative paths */
    @Override
    public String visitWildCard(XQueryGrammarParser.WildCardContext ctx) {
        return "*";
    }

    /* This function returns string "." used to represent current context for relative paths */
    @Override
    public String visitCurrentContext(XQueryGrammarParser.CurrentContextContext ctx) {
        return ".";
    }

    /* This function returns string ".." used to represent parent of current context in relative paths */
    @Override
    public String visitParentOfContext(XQueryGrammarParser.ParentOfContextContext ctx) {
        return "..";
    }

    /* This function returns string "text()" used to represent text value of current context in relative paths */
    @Override
    public String visitGetText(XQueryGrammarParser.GetTextContext ctx) {
        return "text()";
    }

    /* This function returns string representation of attribute name used in a relative path */
    @Override
    public String visitAttributeName(XQueryGrammarParser.AttributeNameContext ctx) {
        return "@" + ctx.IDENTIFIER().getText();
    }

    /* This function returns the string representation of a parenthesized relative path by visiting it and fetching
    its string representation */
    @Override
    public String visitParenthesizedRP(XQueryGrammarParser.ParenthesizedRPContext ctx) {
        return "(" + visit(ctx.rp()) + ")";
    }

    /* This function returns the string representation of rule ChildrenRP by visiting and fetching the
    string representations of rp1 and rp2 associated with it */
    @Override
    public String visitChildrenRP(XQueryGrammarParser.ChildrenRPContext ctx) {
        return visit(ctx.rp(0)) + "/" +visit(ctx.rp(1));
    }

    /* This function returns the string representation of rule DescendantsRP by visiting and fetching the
    string representations of rp1 and rp2 associated with it */
    @Override
    public String visitDescendantsRP(XQueryGrammarParser.DescendantsRPContext ctx) {
        return visit(ctx.rp(0)) + "//" + visit(ctx.rp(1));
    }

    /* This function returns the string representation of rule FilterRP by visiting and fetching the
    string representations of rp (relative path) and f (filter) associated with it */
    @Override
    public String visitFilterRP(XQueryGrammarParser.FilterRPContext ctx) {
        return visit(ctx.rp()) + "[" + visit(ctx.f()) + "]";
    }

    /* This function returns the string representation of  ConcatRP rule by visiting and fetching the
    string representation of rp1 and rp2 */
    @Override
    public String visitConcatRP(XQueryGrammarParser.ConcatRPContext ctx) {
        return visit(ctx.rp(0)) + "," + visit(ctx.rp(1));
    }

    /* This function returns the string representation of the relative path used in a filter condition */
    @Override
    public String visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx) {
        return visit(ctx.rp());
    }

    /* This function returns the string representation of visiting value equality filter by visiting and fetching
    the string representation of rp1 and rp2 */
    @Override
    public String visitValueEqualitySym(XQueryGrammarParser.ValueEqualitySymContext ctx) {
        return visit(ctx.rp(0)) + " = " + visit(ctx.rp(1));
    }

    /* This function returns the string representation of visiting value equality filter by visiting and fetching
    the string representation of rp1 and rp2 */
    @Override
    public String visitValueEqualityWord(XQueryGrammarParser.ValueEqualityWordContext ctx) {
        return visit(ctx.rp(0)) + " eq " + visit(ctx.rp(1));
    }

    /* This function returns the string representation of visiting identity equality filter by visiting and fetching
    the string representation of rp1 and rp2 */
    @Override
    public String visitIdentityEqualitySym(XQueryGrammarParser.IdentityEqualitySymContext ctx) {
        return visit(ctx.rp(0)) + " == " + visit(ctx.rp(1));
    }

    /* This function returns the string representation of visiting identity equality filter by visiting and fetching
    the string representation of rp1 and rp2 */
    @Override
    public String visitIdentityEqualityWord(XQueryGrammarParser.IdentityEqualityWordContext ctx) {
        return visit(ctx.rp(0)) + " is " + visit(ctx.rp(1));

    }

    /* This function returns the string representation of visiting constant equality filter by visiting and fetching
    the string representation of rp (relative path) and fetching text of the string constant from abstract parse tree */
    @Override
    public String visitConstantEquality(XQueryGrammarParser.ConstantEqualityContext ctx) {
        return visit(ctx.rp()) + " = " + ctx.STRING().getText();
    }

    /* This function returns the string representation of visiting a parenthesized filter by visiting and fetching
    the string representation of the filter f */
    @Override
    public String visitParenthesizedFilter(XQueryGrammarParser.ParenthesizedFilterContext ctx) {
        return "(" + visit(ctx.f()) + ")";
    }

    /* This function returns the string representation of visiting And filter by visiting and fetching
    the string representation of f1 and f2 */
    @Override
    public String visitAndFilter(XQueryGrammarParser.AndFilterContext ctx) {
        return visit(ctx.f(0)) + " and " + visit(ctx.f(1));
    }

    /* This function returns the string representation of visiting Or filter by visiting and fetching
    the string representation of f1 and f2 */
    @Override
    public String visitOrFilter(XQueryGrammarParser.OrFilterContext ctx) {
        return visit(ctx.f(0)) + " or " + visit(ctx.f(1));
    }

    /* This function returns the string representation of visiting Not filter by visiting and fetching
    the string representation of the filter f associated with it */
    @Override
    public String visitNotFilter(XQueryGrammarParser.NotFilterContext ctx) {
        return " not " + visit(ctx.f());
    }
}