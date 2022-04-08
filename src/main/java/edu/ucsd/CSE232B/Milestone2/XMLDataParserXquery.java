package edu.ucsd.CSE232B.Milestone2;

// Import required libraries
import edu.ucsd.CSE232B.Milestone1.XMLDataParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public class XMLDataParserXquery extends XMLDataParser{

    // Creating document to add nodes
    private Document doc;

    // Flag which determines if error logs, if any, are to be printed on the terminal during the execution of XQuery
    private boolean errorLogFlag;

    public XMLDataParserXquery(boolean errorLogFlag) throws ParserConfigurationException {

        // Create document builder factory to create new DOM nodes (element and text nodes)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.doc = builder.newDocument();

        this.errorLogFlag = errorLogFlag;

    }

    // This function will print the error log if the flag is set to True
    public void printError(String errorMessage){
        if(errorLogFlag){
            System.out.println("Error: " + errorMessage);
        }
    }

    /* This function will create a new element node using DOM with given tag name and list of nodes as its
    children */
    public Node makeElement(String tagName, LinkedList<Node> nodes){

        // Create an element node with required tag name
        Element element = doc.createElement(tagName);

        // Append every node in the list of given nodes as the child of the newly created element node
        for(int i=0; i<nodes.size(); i++){
            // Fetch every node from the input list
            Node n = nodes.get(i);

            // Create copy of source node and recursively add subtree of source node as well
            Node c = doc.importNode(n, true);

            if(n.getNodeType()==Node.ATTRIBUTE_NODE){
                element.setAttributeNode((Attr) n );
            }
            else {
                element.appendChild(c);
            }
        }
        return element;
    }

    /* This function will create a new DOM text node with required content */
    public Node makeText(String textValue){

        //Create text node using inbuilt function
        return doc.createTextNode(textValue);
    }

    /* This function will map an input node (tuple) to a String representation of the value of its children
    which are present in the attrs list (i.e. the join attributes list). Return the String representation
    as the key on which joins will be performed */
    public static String keyToNodeAttrMapping(Node node, List<TerminalNode> attrs){
        String keyValue = "";

        //Fetch the children nodes of an input tuple
        NodeList nodes = node.getChildNodes();

        //For every attribute present in the join condition
        for(int i=0; i<attrs.size(); i++){

            //Fetch the node from the list
            TerminalNode attr = attrs.get(i);

            //For every child node of the input tuple
            for(int j=0; j<nodes.getLength();j++){
                Node c = nodes.item(j);

                //If the child node is the join attribute currently in consideration (in the attrs for loop)
                if(c.getNodeName().equals(attr.getText())){
                    try {
                        //Compute the string representation of the child node of tuple which is part of join condition
                        String temp = "";

                        //Fetch all children nodes of the child node part of the join condition
                        LinkedList<Node> outputList = getChildren(c);

                        //Create required objects and set properties to serialize the output nodes
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        transformerFactory.setAttribute("indent-number", 2);
                        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

                        //Serialize each node in the output list and append it to the temp string
                        for (int k = 0; k < outputList.size(); k++) {
                            Node n = outputList.get(k);
                            StringWriter strWriter = new StringWriter();
                            transformer.transform(new DOMSource(n), new StreamResult(strWriter));
                            temp += strWriter.toString().trim() + "\n";
                        }

                        //Append the serialized list of nodes (string representation) to the final key
                        keyValue+=temp;
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

        //Return the key value which is a String representation of all the join attributes for an input node (tuple)
        return keyValue;
    }
}