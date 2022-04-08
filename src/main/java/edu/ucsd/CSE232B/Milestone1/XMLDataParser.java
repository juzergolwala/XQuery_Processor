package edu.ucsd.CSE232B.Milestone1;

//Import required libraries
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class XMLDataParser {

    /* This function creates a DOM tree of the input XML file and returns the root node of the tree */
    public static LinkedList<Node> getRootNode(String filepath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        LinkedList<Node> nodes = new LinkedList<>();
        try {

            //Fetch the file path of input data and remove extra quotes
            File xmlFilePath = new File(filepath.substring(1,filepath.length()-1));

            //Create the DOM tree of the XML file
            DocumentBuilder builder = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            Document doc = builder.parse(xmlFilePath);
            doc.getDocumentElement().normalize();
            nodes.add(doc);

        } catch (Exception e) {
            return new LinkedList<>();
        }
        return nodes;
    }

    /* This function returns unique nodes by identity from the input list of nodes */
    public static LinkedList<Node> getUniqueNodes(List<Node> nodes){
        LinkedList<Node> uniqueNodes = new LinkedList<>();

        for(int i=0; i<nodes.size(); i++){
            //Check if node already exists in output list (uniqueness by identity)
            if(!(uniqueNodes.contains(nodes.get(i)))){
                uniqueNodes.add(nodes.get(i));
            }
        }
        return uniqueNodes;
    }

    /* This function returns children of an input node from the DOM tree */
    public static LinkedList<Node> getChildren(Node parent){
        LinkedList<Node> childNodes = new LinkedList<>();

        //Fetch children nodes using inbuilt method of DOM
        NodeList children = parent.getChildNodes();

        //Add each child node to the output list
        for(int i=0; i<children.getLength(); i++){
            childNodes.add(children.item(i));
        }
        return childNodes;
    }

    /* This function returns all children and its descendants including the node itself for
    each node in the input list */
    public static LinkedList<Node> descendantsOrSelf(List<Node> nodes){
        //Output list
        LinkedList<Node> toReturn = new LinkedList<>();

        //This list will hold all nodes to be traversed in the DOM tree
        LinkedList<Node> toPoll = new LinkedList<>();

        //Initially add input nodes to both the lists
        toReturn.addAll(nodes);
        toPoll.addAll(nodes);

        /* Keep traversing the tree to get all descendants until there are no more nodes to be explored, i.e.
        we reach the leaf of DOM tree */
        while(!(toPoll.isEmpty())){
            Node N = toPoll.poll();
            LinkedList<Node> childrenOfN = XMLDataParser.getChildren(N);
            toPoll.addAll(childrenOfN);
            toReturn.addAll(childrenOfN);
        }
        return toReturn;
    }

    /* This function returns the parent node of an input node */
    public static LinkedList<Node> getParent(Node child){
        LinkedList<Node> nodes = new LinkedList<>();
        Node parent;

        /* If the node in consideration is an attribute node, its parent would be the element node in which
        it is mentioned */
        if(child.getNodeType()==Node.ATTRIBUTE_NODE){
            parent = ((Attr) child).getOwnerElement();
        }
        else{
            //Fetch parent node of a child using inbuilt method of DOM
            parent = child.getParentNode();
        }
        nodes.add(parent);
        return nodes;
    }

    /* This function returns the name of the tag in XML file of a given node in DOM tree */
    public static String getTagName(Node N){
        return N.getNodeName();
    }

    /* This function returns the text values of a given input node from DOM tree */
    public static LinkedList<Node> getTextNodes(Node N){
        LinkedList<Node> nodes = new LinkedList<>();

        //Fetch children of input node from DOM tree
        LinkedList<Node> children = XMLDataParser.getChildren(N);

        for(int i=0; i<children.size(); i++) {
            Node child = children.get(i);
            //If child node is a text node and is not empty, we add its value to the output list
            if(child.getNodeType()==Node.TEXT_NODE && (child.getTextContent() != null) &&
                    (!(child.getTextContent().isEmpty()))){
                nodes.add(child);
            }
        }
        return nodes;
    }

    /* This function returns the attributes of a given input node */
    public static LinkedList<Node> getAttributes(Node N, String attrName){
        LinkedList<Node> nodes = new LinkedList<Node>();

        //If a node is not an element node, we cannot check for its attributes
        if(N.getNodeType()!=Node.ELEMENT_NODE){
            return nodes;
        }

        //Downcast the input node to an element type
        Element ele = (Element) N;

        //Check if the element has an attribute with the attribute name specified in input
        if(ele.hasAttribute(attrName)){
            nodes.add(ele.getAttributeNode(attrName));
        }

        return nodes;
    }

    /* This function returns an input node as a singleton list */
    public static LinkedList<Node> returnList(Node N){
        LinkedList<Node> nodes = new LinkedList<>();
        if(N != null){
            nodes.add(N);
        }
        return nodes;
    }

    /* This function checks if there exists any node equal in value from 2 input lists
    Returns True if it finds any such node, else it Returns False */
    public static boolean existsEqualNode(LinkedList<Node> left, LinkedList<Node> right){
        for(int i=0; i<left.size(); i++){
            for(int j=0; j<right.size(); j++){

                //Check for value equality using inbuilt method of DOM
                if(left.get(i).isEqualNode(right.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    /* This function checks if there exists any node equal in identity from 2 input lists
    Returns True if it finds any such node, else it Returns False */
    public static boolean existsSameNode(LinkedList<Node> left, LinkedList<Node> right){
        for(int i=0; i<left.size(); i++){
            for(int j=0; j<right.size(); j++){

                //Check for identity equality using inbuilt method of DOM
                if(left.get(i).isSameNode(right.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
}