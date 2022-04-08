package edu.ucsd.CSE232B.Milestone2;

//Import required libraries
import edu.ucsd.CSE232B.Milestone1.XMLDataParser;
import edu.ucsd.CSE232B.parsers.XQueryGrammarBaseVisitor;
import edu.ucsd.CSE232B.parsers.XQueryGrammarParser;
import org.w3c.dom.Node;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashMap;
import java.util.LinkedList;

public class XQueryVisitor extends XQueryGrammarBaseVisitor<LinkedList<Node>> {

    //This data structure will store the current context of variables
    private HashMap<String, LinkedList<Node>> variables;

    /* This list will hold the nodes visited during the parsing of  Xquery and will be
    returned as output list once the entire query is parsed */
    private LinkedList<Node> nodes;

    // Create an object of the Data Parser class which iterates through the DOM tree
    private XMLDataParserXquery xmlDataParser;

    public XQueryVisitor(boolean flag) throws ParserConfigurationException {
        this.xmlDataParser = new XMLDataParserXquery(flag);
        this.nodes = new LinkedList<>();
        this.variables = new HashMap<>();

    }

    /* This function assigns the nodes associated with a variable name (in the current context) to the
    current list of nodes for execution */
    @Override
    public LinkedList<Node> visitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx) {

        //Fetch variable name from parse tree
        String variable = ctx.VARIABLE().getText();

        //Check if variable is defined and usable in given context
        if(this.variables.containsKey(variable)){
            this.nodes = this.variables.get(variable);
        }
        else {
            this.nodes = new LinkedList<>();
            xmlDataParser.printError("Variable " + variable + " is not defined.");
        }
        return this.nodes;
    }

    /* This function creates a text node of given String and returns it as a singular list */
    @Override
    public LinkedList<Node> visitXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx) {

        //Fetch text value from parse tree
        String constant = ctx.STRING().getText();

        //Remove extra double quotes from the string value obtained from parse tree
        constant = constant.substring(1,constant.length()-1);

        //Create a text node using DOM and assign it to current list of nodes as a singular list
        this.nodes = xmlDataParser.returnList(xmlDataParser.makeText(constant));
        return this.nodes;
    }

    /* This function visits the absolute path in the Xquery and assigns the nodes in the absolute path
    to the current list of nodes */
    @Override
    public LinkedList<Node> visitXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx) {
        return visit(ctx.ap());
    }

    /* This function visits, executes and returns the result of Xquery specified within parentheses */
    @Override
    public LinkedList<Node> visitParenthesizedXquery(XQueryGrammarParser.ParenthesizedXqueryContext ctx) {
        return visit(ctx.xq());
    }

    /* This function visits, executes and concatenates the resulting nodes of xq1 and xq2 */
    @Override
    public LinkedList<Node> visitXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx) {

        //Create a temporary list from current list of nodes
        LinkedList<Node> tmp = this.nodes;

        //This list will hold the resulting nodes
        LinkedList<Node> nodes = new LinkedList<>();

        //Add resulting nodes of xq1 to the final result
        nodes.addAll(visit(ctx.xq(0)));

        //Restore current list of nodes to the original value, i.e. pre xq1 execution
        this.nodes = tmp;

        //Add resulting nodes of xq2 to the final result
        nodes.addAll(visit(ctx.xq(1)));

        //Assign result to the return current list of nodes
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function visits and returns the unique nodes in the specified relative path of the Xquery */
    @Override
    public LinkedList<Node> visitXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx) {
        visit(ctx.xq());
        this.nodes = xmlDataParser.getUniqueNodes(visit(ctx.rp()));
        return this.nodes;
    }

    /* This function visits and executes the Xquery, then visits and returns the descendants or self nodes of the
    output nodes of the xquery, and lastly assigns the unique nodes in the relative path specified, to the current
    list of nodes */
    @Override
    public LinkedList<Node> visitXqueryAll(XQueryGrammarParser.XqueryAllContext ctx) {
        this.nodes = xmlDataParser.descendantsOrSelf(visit(ctx.xq()));
        this.nodes = xmlDataParser.getUniqueNodes(visit(ctx.rp()));
        return this.nodes;
    }

    /* This function creates a DOM element with given tag name and nodes returned by execution of the Xquery
    specified within the tag name */
    @Override
    public LinkedList<Node> visitXqueryTag(XQueryGrammarParser.XqueryTagContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();

        //Fetch the opening tag name from the parse tree
        String tagNameOpen = ctx.IDENTIFIER(0).getText();

        //Fetch the closing tag name from the parse tree
        String tagNameClose = ctx.IDENTIFIER(1).getText();

        //Raise an error if opening and closing tag names do not match
        if(!(tagNameOpen.equals(tagNameClose))){
            xmlDataParser.printError("Opening and closing tags: " + tagNameOpen +
                    " and " + tagNameClose + " do not match!");
        }

        //If tag names match, visit the Xquery and create an element with output nodes of the Xquery
        else{
            nodes.add(xmlDataParser.makeElement(tagNameOpen, visit(ctx.xq())));
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function returns the result of visiting the FLWR block in the Xquery */
    @Override
    public LinkedList<Node> visitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();

        //Store the current context of variables in a temporary hash map
        HashMap<String, LinkedList<Node>> variables= new HashMap<>(this.variables);

        //Iterate through the FLWR block for every variable (each node at a time) in the for clause
        iterateFLWRBlock(ctx,0,nodes);
        this.variables = variables;
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function will be called recursively for every node mapped to the variable in the for clause.
    Moreover, execution will move to the Let, Where and Return clauses when the depth of for clause variables
    is reached */
    private void iterateFLWRBlock(XQueryGrammarParser.XqueryFLWRContext ctx, int variableNum,
                                  LinkedList<Node> nodes){

        //If we are at the depth of the for clause variables, proceed with execution of Let, Where and Return
        if(variableNum == ctx.forClause().VARIABLE().size()){
            HashMap<String, LinkedList<Node>> variables = new HashMap<>(this.variables);

            //If Let clause is present, visit and add variables to the current context of variables
            if(ctx.letClause()!=null){
                visit(ctx.letClause());
            }
            //If Where clause is satisfied, add node to the return list
            if(ctx.whereClause()==null || (!visit(ctx.whereClause()).isEmpty())) {
                nodes.addAll(visit(ctx.returnClause()));
            }

            //Post execution, restore the current context of variables
            this.variables = variables;
        }

        //If the depth of variables in for clause is not reached, keep calling the function recursively
        else {

            //Fetch name of the next variable in for clause given by variable number
            String variableName = ctx.forClause().VARIABLE(variableNum).getText();

            //Execute the Xquery associated with the variable definition
            LinkedList<Node> xqueryEvaluation = visit(ctx.forClause().xq(variableNum));

            /* For every node in the output of Xquery Execution, add it to the variables hash map
            and call the function recursively */
            for(int i=0; i<xqueryEvaluation.size(); i++){
                Node n = xqueryEvaluation.get(i);
                this.variables.put(variableName, xmlDataParser.returnList(n));
                /* For the recursive call, increment depth of variable such that once we reach the last variable,
                further execution of FLWR block takes place */
                iterateFLWRBlock(ctx, variableNum+1, nodes);
            }
        }
    }

    /* This function visits the Let clause, evaluates the Xquery associated with the variable, and adds the variable
    and the output of Xquery evaluation to the hash map of variables. Post that it executes the Xquery after the
    Let clause */
    @Override
    public LinkedList<Node> visitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx) {
        HashMap<String, LinkedList<Node>> variables = new HashMap<>(this.variables);

        //Visit the Let clause which adds on to the current context of variables
        visit(ctx.letClause());

        //Visit the Xquery and evaluate it
        visit(ctx.xq());

        //Restore the current context of variables
        this.variables = variables;
        return this.nodes;
    }

    /* This function returns null as utilising the result of visiting a for clause is invalid */
    @Override
    public LinkedList<Node> visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        return null;
    }

    /* This function visits the Xquery associated with each variable in the Let clause, evaluates it
    and adds the mapping of variable and output of Xquery to the current context of variables */
    @Override
    public LinkedList<Node> visitLetClause(XQueryGrammarParser.LetClauseContext ctx) {

        //Fetch the total number of variables defined in the Let clause
        int variableNum = ctx.VARIABLE().size();

        //For every variable, evaluate the Xquery associated with it
        for(int i=0; i<variableNum; i++){

            //Fetch the variable name from the parse tree
            String variableName = ctx.VARIABLE(i).getText();

            //Create a temporary list of variables before executing the Xquery
            HashMap<String, LinkedList<Node>> variables = new HashMap<>(this.variables);

            //Evaluate the Xquery associated with variable name
            LinkedList<Node> xQueryEvaluation = visit(ctx.xq(i));

            //Restore the context of variables prior to that of Xquery evaluation
            this.variables = variables;

            //Add the variable name and its Xquery evaluation to the current context of variables
            this.variables.put(variableName, xQueryEvaluation);
        }
        //Return null as utilising the result of visiting a let clause is invalid
        return null;
    }

    /* This function returns the result of visiting the condition specified within the where clause */
    @Override
    public LinkedList<Node> visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx) {
        return visit(ctx.cond());
    }

    /* This function returns the result of visiting the Xquery specified within the return clause */
    @Override
    public LinkedList<Node> visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx) {
        return visit(ctx.xq());
    }

    /* This function checks if there exists any node equal in value on the Xquery evaluation xq1 and
    Xquery evaluation xq2 for the current context node called from iterateFLWRBlock()
    If it does find such a node, it returns a non-empty list, else it returns an empty list */
    @Override
    public LinkedList<Node> visitConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx) {
        LinkedList<Node> tmp = this.nodes;

        //Fetch nodes from result of evaluation of xq1
        LinkedList<Node> leftList = visit(ctx.xq(0));
        this.nodes = tmp;

        //Fetch nodes from result of evaluation of xq2
        LinkedList<Node> rightList = visit(ctx.xq(1));
        this.nodes = tmp;

        //Check if there exists any node equal in value
        if(xmlDataParser.existsEqualNode(leftList,rightList)){
            return this.nodes;
        }

        //Return an empty list if the condition is not satisfied
        return new LinkedList<>();
    }

    /* Same functionality as that of XQueryVisitor.visitConditionValueEqualitySym()
    Grammar rule uses 'eq' instead of '=' */
    @Override
    public LinkedList<Node> visitConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx) {
        LinkedList<Node> tmp = this.nodes;
        LinkedList<Node> leftList = visit(ctx.xq(0));
        this.nodes = tmp;
        LinkedList<Node> rightList = visit(ctx.xq(1));
        this.nodes = tmp;
        if(xmlDataParser.existsEqualNode(leftList,rightList)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* This function checks if there exists any node equal in identity on the Xquery evaluation xq1 and
    Xquery evaluation xq2 for the current context node called from iterateFLWRBlock()
    If it does find such a node, it returns a non-empty list, else it returns an empty list */
    @Override
    public LinkedList<Node> visitConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx) {
        LinkedList<Node> tmp = this.nodes;

        //Fetch nodes from result of evaluation of xq1
        LinkedList<Node> leftList = visit(ctx.xq(0));
        this.nodes = tmp;

        //Fetch nodes from result of evaluation of xq2
        LinkedList<Node> rightList = visit(ctx.xq(1));
        this.nodes = tmp;

        //Check if there exists any node equal in identity
        if(xmlDataParser.existsSameNode(leftList,rightList)){
            return this.nodes;
        }

        //Return an empty list if the condition is not satisfied
        return new LinkedList<>();
    }

    /* Same functionality as that of XQueryVisitor.visitConditionIdentityEqualitySym()
    Grammar rule uses 'is' instead of '==' */
    @Override
    public LinkedList<Node> visitConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx) {
        LinkedList<Node> tmp = this.nodes;
        LinkedList<Node> leftList = visit(ctx.xq(0));
        this.nodes = tmp;
        LinkedList<Node> rightList = visit(ctx.xq(1));
        this.nodes = tmp;
        if(xmlDataParser.existsSameNode(leftList,rightList)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* This function checks if evaluation of Xquery in the condition evaluates to an empty list. If yes, it
    returns a non-empty list, else it returns an empty list  */
    @Override
    public LinkedList<Node> visitConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx) {
        LinkedList<Node> tmp = this.nodes;

        //Fetch the result of Xquery evaluation
        LinkedList<Node> xqueryEvaluation = visit(ctx.xq());
        this.nodes = tmp;

        //If the result is empty return the current list of nodes which is a non-empty list
        if(xqueryEvaluation.isEmpty()){
            return this.nodes;
        }

        //Return an empty list if the condition is not satisfied
        return new LinkedList<>();
    }

    /* This function maps the variables introduced in the some clause with its corresponding Xquery evaluations,
    then checks if the condition is satisfied and returns the condition evaluation */
    @Override
    public LinkedList<Node> visitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx) {
        HashMap<String, LinkedList<Node>> variables = new HashMap<>(this.variables);
        LinkedList<Node> nodes = this.nodes;

        //Fetch the number of variables introduced in the some clause
        int numberVariables = ctx.VARIABLE().size();

        //For every variable, evaluate its corresponding Xquery and add the mapping to the current context of variables
        for(int i=0; i<numberVariables; i++){
            String variableName = ctx.VARIABLE(i).getText();
            LinkedList<Node> xqueryEvaluation = visit(ctx.xq(i));
            this.variables.put(variableName,xqueryEvaluation);
        }

        //Visit the condition specified within the some clause
        LinkedList<Node> conditionEvaluation = visit(ctx.cond());

        //Restore the current context of nodes and variables post evaluation of the condition
        this.variables = variables;
        this.nodes = nodes;

        /* Return the condition evaluation list which will be empty if the condition is not satisfied
        and non-empty if the condition is satisfied */
        return conditionEvaluation;
    }

    /* This function returns the result of visiting the condition specified within parentheses */
    @Override
    public LinkedList<Node> visitParenthesizedCondition(XQueryGrammarParser.ParenthesizedConditionContext ctx) {
        return visit(ctx.cond());
    }

    /* This function checks for logical AND operation between 2 conditions
    Returns True:non-empty list if both are True, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitConditionAnd(XQueryGrammarParser.ConditionAndContext ctx) {

        /* If the result of visiting any condition evaluates to an empty list,
        we return an empty list as the overall condition evaluates to False */
        if(visit(ctx.cond(0)).isEmpty() || visit(ctx.cond(1)).isEmpty()){
            return new LinkedList<>();
        }
        return this.nodes;
    }

    /* This function checks for logical OR operation between 2 conditions
    Returns True:non-empty list if anyone or both conditions are True, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitConditionOr(XQueryGrammarParser.ConditionOrContext ctx) {

        /* If the result of visiting both the conditions evaluates to an empty list,
        we return an empty list as the overall condition evaluates to False */
        if(visit(ctx.cond(0)).isEmpty() && visit(ctx.cond(1)).isEmpty()){
            return new LinkedList<>();
        }
        return this.nodes;
    }

    /* This function checks for logical NOT operation
    Returns True: non-empty if the condition returns an empty list, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitConditionNot(XQueryGrammarParser.ConditionNotContext ctx) {

        // If the condition to be evaluated within NOT returns False (empty list), we return a non-empty list
        if(visit(ctx.cond()).isEmpty()){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* This function visits the children nodes of root node of DOM tree reachable through the relative path */
    @Override
    public LinkedList<Node> visitXpathChildren(XQueryGrammarParser.XpathChildrenContext ctx) {
        //Initially visit node docName in the parse tree to load root of DOM tree in the class' list
        visit(ctx.docName());

        //Fetch and return unique nodes in the relative path from root node in the DOM tree
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp()));
        return this.nodes;
    }

    /* This function visits all the descendants nodes (including root node of DOM tree) reachable through
    the relative path */
    @Override
    public LinkedList<Node> visitXpathAll(XQueryGrammarParser.XpathAllContext ctx) {
        // Load the root node of DOM tree to the list by visiting docName and then visit all its dependents
        this.nodes = XMLDataParser.descendantsOrSelf(visit(ctx.docName()));

        // Remove duplicates from the list
        this.nodes = XMLDataParser.getUniqueNodes((visit(ctx.rp())));
        return this.nodes;
    }

    /* This function will load the XML file as a DOM tree (root node) to the list */
    @Override
    public LinkedList<Node> visitDocumentName(XQueryGrammarParser.DocumentNameContext ctx) {
        this.nodes = XMLDataParser.getRootNode(ctx.STRING().getText());
        return this.nodes;
    }

    /* This function will fetch children of nodes currently in the list and load those children
    whose tag names are equal to the tag name specified in the relative path */
    @Override
    public LinkedList<Node> visitTagName(XQueryGrammarParser.TagNameContext ctx) {
        //Create a list to be returned
        LinkedList<Node> nodes = new LinkedList<>();
        String tagName = ctx.IDENTIFIER().getText();

        //For every node currently in the list we fetch their children
        for(int i=0; i<this.nodes.size(); i++){
            Node N = this.nodes.get(i);
            LinkedList<Node> childrenOfN = XMLDataParser.getChildren(N);

            /* For every child node, if their tag name equals to the one specified in the relative path
            add them to the output list */
            for(int j=0; j<childrenOfN.size(); j++){
                if(XMLDataParser.getTagName(childrenOfN.get(j)).equals(tagName)){
                    nodes.add(childrenOfN.get(j));
                }
            }
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function visits all the child nodes irrespective of their tag name
    of all the nodes in the current list */
    @Override
    public LinkedList<Node> visitWildCard(XQueryGrammarParser.WildCardContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();
        for(int i=0; i<this.nodes.size(); i++){
            //Add the collection of children nodes to the list of nodes
            nodes.addAll(XMLDataParser.getChildren(this.nodes.get(i)));
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function returns the current list of nodes as parsing of XPath query should continue
    from current context */
    @Override
    public LinkedList<Node> visitCurrentContext(XQueryGrammarParser.CurrentContextContext ctx) {

        return this.nodes;
    }

    /* This function visits the parent nodes of the current list of nodes (i.e. current context nodes) */
    @Override
    public LinkedList<Node> visitParentOfContext(XQueryGrammarParser.ParentOfContextContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();
        for(int i=0; i<this.nodes.size(); i++){
            /* Add the parent node to the list of node
            (addAll is used as the parent is returned as a singleton list) */
            nodes.addAll(XMLDataParser.getParent(this.nodes.get(i)));
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function fetches the text value within the current context nodes */
    @Override
    public LinkedList<Node> visitGetText(XQueryGrammarParser.GetTextContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();
        for(int i=0; i<this.nodes.size(); i++){
            //Get the content of nodes (text value) from DOM tree
            nodes.addAll(XMLDataParser.getTextNodes(this.nodes.get(i)));
        }
        this.nodes = nodes;
        return nodes;
    }

    /* This function will visit the attributes of the current context nodes and return the ones whose
    attribute name matches with that specified in the relative path */
    @Override
    public LinkedList<Node> visitAttributeName(XQueryGrammarParser.AttributeNameContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();
        String attrName = ctx.IDENTIFIER().getText();

        for(int i=0; i<this.nodes.size(); i++){
            //Fetch values of attributes whose name matches with that specified in the relative path
            nodes.addAll(XMLDataParser.getAttributes(this.nodes.get(i),attrName));
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function will visit nodes in the relative path within parentheses from the current context nodes */
    @Override
    public LinkedList<Node> visitParenthesizedRP(XQueryGrammarParser.ParenthesizedRPContext ctx) {
        return visit(ctx.rp());
    }

    /* This function will first visit the relative path on the left of the parsed XPath from current
     context nodes and then continue with the one on the right */
    @Override
    public LinkedList<Node> visitChildrenRP(XQueryGrammarParser.ChildrenRPContext ctx) {
        visit(ctx.rp(0));
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp(1)));
        return this.nodes;
    }

    /* This function will visit all the descendants including self of the relative on the left of the XPath
    and then continue processing of the relative path on thr right */
    @Override
    public LinkedList<Node> visitDescendantsRP(XQueryGrammarParser.DescendantsRPContext ctx) {
        //Fetch descendants including self of current context nodes using left path on the left
        this.nodes = XMLDataParser.descendantsOrSelf(visit(ctx.rp(0)));

        //Now traverse the tree using the right relative path and fetch the unique nodes
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp(1)));
        return this.nodes;
    }

    /* This function returns nodes in the relative path of current context nodes which satisfy the filter */
    @Override
    public LinkedList<Node> visitFilterRP(XQueryGrammarParser.FilterRPContext ctx) {
        LinkedList<Node> nodes = new LinkedList<>();

        //Fetch nodes in the relative path of current context nodes
        LinkedList<Node> rpNodes = visit(ctx.rp());

        for(int i=0; i<rpNodes.size(); i++){
            Node n = rpNodes.get(i);

            //Add node to the current context list
            this.nodes = XMLDataParser.returnList(n);

            /*Visit the filter rule in the parse tree and if the node satisfies the filter condition,
            add it to the output list */
            if(!(visit(ctx.f()).isEmpty())){
                nodes.add(n);
            }
        }
        this.nodes = nodes;
        return this.nodes;
    }

    /* This function concatenates the output of two relative paths rp1 and rp2, reachable through the
    current context nodes */
    @Override
    public LinkedList<Node> visitConcatRP(XQueryGrammarParser.ConcatRPContext ctx) {
        LinkedList<Node> temp = this.nodes;
        //Fetch nodes on the first relative path
        LinkedList<Node> nodes1 = visit(ctx.rp(0));
        this.nodes = temp;

        //Fetch nodes on the second relative path
        LinkedList<Node> nodes2 = visit(ctx.rp(1));

        LinkedList<Node> toReturn = new LinkedList<>();

        //Add nodes on both the paths to the output list
        for(int i=0; i<nodes1.size(); i++){
            Node n = nodes1.get(i);
            if(!(toReturn.contains(n))){
                toReturn.add(n);
            }
        }
        for(int i=0; i<nodes2.size(); i++){
            Node n = nodes2.get(i);
            if(!(toReturn.contains(n))){
                toReturn.add(n);
            }
        }
        this.nodes = toReturn;
        return this.nodes;
    }

    /* This function treats a relative path as a filter condition and returns the nodes on the specified
    relative path, thereby implying the filter value as True:not empty list, False: empty list */
    @Override
    public LinkedList<Node> visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx) {
        LinkedList<Node> nodes = this.nodes;

        //Fetch the nodes on the relative path of current context nodes
        LinkedList<Node> rpNodes = visit(ctx.rp());
        this.nodes = nodes;
        return rpNodes;
    }

    /* This function checks if there exists any node equal in value on the relative path rp1 and
    relative path rp2 from the current context node
    If it does find such a node, it returns the current context node, else it returns an empty list*/
    @Override
    public LinkedList<Node> visitValueEqualitySym(XQueryGrammarParser.ValueEqualitySymContext ctx) {
        LinkedList<Node> nodes = this.nodes;
        //Fetch nodes on the first relative path
        LinkedList<Node> left = visit(ctx.rp(0));
        this.nodes = nodes;

        //Fetch nodes on the second relative path
        LinkedList<Node> right = visit(ctx.rp(1));
        this.nodes = nodes;

        //Check if there exists any node equal in value
        if(XMLDataParser.existsEqualNode(left,right)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* Same functionality as that of XPathVisitor.visitValueEqualitySym()
    Grammar rule uses 'eq' instead of '=' */
    @Override
    public LinkedList<Node> visitValueEqualityWord(XQueryGrammarParser.ValueEqualityWordContext ctx) {
        LinkedList<Node> nodes = this.nodes;
        LinkedList<Node> left = visit(ctx.rp(0));
        this.nodes = nodes;
        LinkedList<Node> right = visit(ctx.rp(1));
        this.nodes = nodes;
        if(XMLDataParser.existsEqualNode(left,right)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* This function checks if there exists any node equal in identity on the relative path rp1 and
    relative path rp2 from the current context node
    If it does find such a node, it returns the current context node, else it returns an empty list*/
    @Override
    public LinkedList<Node> visitIdentityEqualitySym(XQueryGrammarParser.IdentityEqualitySymContext ctx) {
        LinkedList<Node> nodes = this.nodes;

        //Fetch nodes on the first relative path
        LinkedList<Node> left = visit(ctx.rp(0));
        this.nodes = nodes;

        //Fetch nodes on the second relative path
        LinkedList<Node> right = visit(ctx.rp(1));
        this.nodes = nodes;

        //Check if there exists any node equal in identity
        if(XMLDataParser.existsSameNode(left,right)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* Same functionality as that of XPathVisitor.visitIdentityEqualitySym()
    Grammar rule uses 'is' instead of '==' */
    @Override
    public LinkedList<Node> visitIdentityEqualityWord(XQueryGrammarParser.IdentityEqualityWordContext ctx) {
        LinkedList<Node> nodes = this.nodes;
        LinkedList<Node> left = visit(ctx.rp(0));
        this.nodes = nodes;
        LinkedList<Node> right = visit(ctx.rp(1));
        this.nodes = nodes;
        if(XMLDataParser.existsSameNode(left,right)){
            return this.nodes;
        }
        return new LinkedList<>();
    }

    /* This function checks if there is a node on the relative path from current context node whose value
    is equal to a string constant
    If it does find such a node, it returns the current context node, else it returns an empty list */
    @Override
    public LinkedList<Node> visitConstantEquality(XQueryGrammarParser.ConstantEqualityContext ctx) {
        LinkedList<Node> nodes = this.nodes;

        //Fetch the string constant value
        String constant = ctx.STRING().getText();

        //Remove extra double quotes from string
        constant = constant.substring(1,constant.length()-1);

        //Fetch nodes on the relative path from current context node
        LinkedList<Node> toCheck = visit(ctx.rp());
        this.nodes = nodes;

        //If any node's value matches the string constant, return the current context node
        for(int i=0; i<toCheck.size(); i++) {
            Node n = toCheck.get(i);
            if(constant.equals(n.getTextContent())){
                return this.nodes;
            }
        }
        return new LinkedList<>();
    }

    /* This function visits the filter condition within parentheses */
    @Override
    public LinkedList<Node> visitParenthesizedFilter(XQueryGrammarParser.ParenthesizedFilterContext ctx) {
        return visit(ctx.f());
    }

    /* This function checks for logical AND operation between 2 filter conditions
    Returns True:context node if both are True, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitAndFilter(XQueryGrammarParser.AndFilterContext ctx) {
        /* If any filter returns an empty list, we return an empty list as the overall condition evaluates
        to False */
        if(visit(ctx.f(0)).isEmpty() || visit(ctx.f(1)).isEmpty()){
            return new LinkedList<>();
        }
        return this.nodes;
    }

    /* This function checks for logical OR operation between 2 filter conditions
    Returns True:context node if one or both filters are True, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitOrFilter(XQueryGrammarParser.OrFilterContext ctx) {
        /* If both the filters return an empty list, we return an empty list as the overall condition evaluates
        to False */
        if(visit(ctx.f(0)).isEmpty() && visit(ctx.f(1)).isEmpty()){
            return new LinkedList<>();
        }
        return this.nodes;
    }

    /* This function checks for logical NOT operation
    Returns True:context node if the filter returns False, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitNotFilter(XQueryGrammarParser.NotFilterContext ctx) {
        // If the filter to be evaluated within NOT returns False (empty list), we return the current context node
        if(visit(ctx.f()).isEmpty()){
            return this.nodes;
        }
        return new LinkedList<>();
    }
}