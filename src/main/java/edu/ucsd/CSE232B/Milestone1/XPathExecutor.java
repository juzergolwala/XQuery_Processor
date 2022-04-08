package edu.ucsd.CSE232B.Milestone1;

//Import required libraries
import edu.ucsd.CSE232B.parsers.XPathGrammarLexer;
import edu.ucsd.CSE232B.parsers.XPathGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class XPathExecutor {

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException {

        //Fetch the path of file containing the query to be tested from command line argument
        Path queryFile = Path.of(args[0]);
        String xmlQuery = null;

        //Read file contents (query)
        try {
            xmlQuery = Files.readString(queryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parse the query into an XPath Tree using XPathGrammar and ANTLR4 generated classes
        final XPathGrammarLexer lexer = new XPathGrammarLexer(CharStreams.fromString(xmlQuery));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XPathGrammarParser parser = new XPathGrammarParser(tokens);

        /* Begin XPath query execution from the root context by invoking visit method on root node of the
        parse tree to obtain a list of output nodes */
        final ParseTree tree = parser.ap();
        final XPathVisitor visitor = new XPathVisitor();
        final LinkedList<Node> outputList = visitor.visit(tree);

        //Maintain a string to store serialized output
        String output = "<OUTPUT>\n";

        try {

            //Create required objects and set properties to serialize the output nodes
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformerFactory.setAttribute("indent-number", 2);
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //Serialize each node in the output list and append it to the final output string
            for (int i = 0; i < outputList.size(); i++) {
                Node n = outputList.get(i);
                StringWriter strWriter = new StringWriter();
                transformer.transform(new DOMSource(n), new StreamResult(strWriter));
                output += strWriter.toString().trim()+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        output+="</OUTPUT>";

        //Split the file path to get name of the input XPath query file (to append the same to output filename)
        String queryFilePath = args[0];
        String[] temp = queryFilePath.split("/");
        String outputFilePath = "output_data/output_"+temp[temp.length-1];

        //Create output directory (output_data) if it does not exist and write serialized output to file
        try{
            PrintWriter writer = new PrintWriter(outputFilePath);
            writer.println(output);
            writer.close();
        }
        catch(Exception e){
            File directory = new File("output_data");
            directory.mkdir();
            PrintWriter writer = new PrintWriter(outputFilePath);
            writer.println(output);
            writer.close();
        }
    }
}