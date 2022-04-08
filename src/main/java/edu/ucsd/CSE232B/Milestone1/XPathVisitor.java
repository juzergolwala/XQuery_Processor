package edu.ucsd.CSE232B.Milestone1;

//Import required libraries
import edu.ucsd.CSE232B.parsers.*;
import org.w3c.dom.Node;
import java.util.LinkedList;

public class XPathVisitor extends XPathGrammarBaseVisitor<LinkedList<Node>>{

    private LinkedList<Node> nodes;

    public XPathVisitor(){
        /* This list will hold the nodes visited during the parsing of XPath query and will be
        returned as output list once the entire query is parsed */
        this.nodes = new LinkedList<>();
    }

    /* This function visits the children nodes of root node of DOM tree reachable through
    the relative path */
    @Override
    public LinkedList<Node> visitXpathChildren(XPathGrammarParser.XpathChildrenContext ctx) {
        //Initially visit node docName in the parse tree to load root of DOM tree in the class' list
        visit(ctx.docName());

        //Fetch and return unique nodes in the relative path from root node in the DOM tree
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp()));
        return this.nodes;
    }

    /* This function visits all the descendants nodes (including root node of DOM tree) reachable through
    the relative path */
    @Override
    public LinkedList<Node> visitXpathAll(XPathGrammarParser.XpathAllContext ctx) {
        // Load the root node of DOM tree to the list by visiting docName and then visit all its dependents
        this.nodes = XMLDataParser.descendantsOrSelf(visit(ctx.docName()));

        // Remove duplicates from the list
        this.nodes = XMLDataParser.getUniqueNodes((visit(ctx.rp())));
        return this.nodes;
    }

    /* This function will load the XML file as a DOM tree (root node) to the list */
    @Override
    public LinkedList<Node> visitDocumentName(XPathGrammarParser.DocumentNameContext ctx) {
        this.nodes = XMLDataParser.getRootNode(ctx.STRING().getText());
        return this.nodes;
    }

    /* This function will fetch children of nodes currently in the list and load those children
    whose tag names are equal to the tag name specified in the relative path */
    @Override
    public LinkedList<Node> visitTagName(XPathGrammarParser.TagNameContext ctx) {
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
    public LinkedList<Node> visitWildCard(XPathGrammarParser.WildCardContext ctx) {
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
    public LinkedList<Node> visitCurrentContext(XPathGrammarParser.CurrentContextContext ctx) {
        return this.nodes;
    }

    /* This function visits the parent nodes of the current list of nodes (i.e. current context nodes) */
    @Override
    public LinkedList<Node> visitParentOfContext(XPathGrammarParser.ParentOfContextContext ctx) {
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
    public LinkedList<Node> visitGetText(XPathGrammarParser.GetTextContext ctx) {
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
    public LinkedList<Node> visitAttributeName(XPathGrammarParser.AttributeNameContext ctx) {
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
    public LinkedList<Node> visitParenthesizedRP(XPathGrammarParser.ParenthesizedRPContext ctx) {
        return visit(ctx.rp());
    }

    /* This function will first visit the relative path on the left of the parsed XPath from current
     context nodes and then continue with the one on the right */
    @Override
    public LinkedList<Node> visitChildrenRP(XPathGrammarParser.ChildrenRPContext ctx) {
        visit(ctx.rp(0));
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp(1)));
        return this.nodes;
    }

    /* This function will visit all the descendants including self of the relative on the left of the XPath
    and then continue processing of the relative path on thr right */
    @Override
    public LinkedList<Node> visitDescendantsRP(XPathGrammarParser.DescendantsRPContext ctx) {
        //Fetch descendants including self of current context nodes using left path on the left
        this.nodes = XMLDataParser.descendantsOrSelf(visit(ctx.rp(0)));

        //Now traverse the tree using the right relative path and fetch the unique nodes
        this.nodes = XMLDataParser.getUniqueNodes(visit(ctx.rp(1)));
        return this.nodes;
    }

    /* This function returns nodes in the relative path of current context nodes which satisfy the filter */
    @Override
    public LinkedList<Node> visitFilterRP(XPathGrammarParser.FilterRPContext ctx) {
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
    public LinkedList<Node> visitConcatRP(XPathGrammarParser.ConcatRPContext ctx) {
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
    public LinkedList<Node> visitFilteredRP(XPathGrammarParser.FilteredRPContext ctx) {
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
    public LinkedList<Node> visitValueEqualitySym(XPathGrammarParser.ValueEqualitySymContext ctx) {
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
    public LinkedList<Node> visitValueEqualityWord(XPathGrammarParser.ValueEqualityWordContext ctx) {
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
    public LinkedList<Node> visitIdentityEqualitySym(XPathGrammarParser.IdentityEqualitySymContext ctx) {
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
    public LinkedList<Node> visitIdentityEqualityWord(XPathGrammarParser.IdentityEqualityWordContext ctx) {
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
    public LinkedList<Node> visitConstantEquality(XPathGrammarParser.ConstantEqualityContext ctx) {
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
    public LinkedList<Node> visitParenthesizedFilter(XPathGrammarParser.ParenthesizedFilterContext ctx) {
        return visit(ctx.f());
    }

    /* This function checks for logical AND operation between 2 filter conditions
    Returns True:context node if both are True, else it will return False:empty list */
    @Override
    public LinkedList<Node> visitAndFilter(XPathGrammarParser.AndFilterContext ctx) {
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
    public LinkedList<Node> visitOrFilter(XPathGrammarParser.OrFilterContext ctx) {
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
    public LinkedList<Node> visitNotFilter(XPathGrammarParser.NotFilterContext ctx) {
        // If the filter to be evaluated within NOT returns False (empty list), we return the current context node
        if(visit(ctx.f()).isEmpty()){
            return this.nodes;
        }
        return new LinkedList<>();
    }
}