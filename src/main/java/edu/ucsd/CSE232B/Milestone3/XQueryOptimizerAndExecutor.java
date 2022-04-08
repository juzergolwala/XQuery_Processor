package edu.ucsd.CSE232B.Milestone3;

//Import required libraries
import edu.ucsd.CSE232B.parsers.XQueryGrammarLexer;
import edu.ucsd.CSE232B.parsers.XQueryGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class XQueryOptimizerAndExecutor {

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException {

        //Fetch the path of file containing the query to be rewritten from command line argument
        Path queryFile = Path.of(args[0]);
        String xmlQuery = null;

        //Read file contents (query)
        try {
            xmlQuery = Files.readString(queryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Parse the query into an XQuery Tree using XQueryGrammar and ANTLR4 generated classes
        Begin Xquery execution from the root context by invoking visit method on root node of the
        parse tree to obtain a String representation of the query with the variables renamed

        final XQueryGrammarLexer lexer1 = new XQueryGrammarLexer(CharStreams.fromString(xmlQuery));
        final CommonTokenStream tokens1 = new CommonTokenStream(lexer1);
        final XQueryGrammarParser parser1 = new XQueryGrammarParser(tokens1);
        final ParseTree tree1 = parser1.xq();
        final VisitorToRenameVariables visitor1 = new VisitorToRenameVariables();
        final String renamedVariablesQuery = visitor1.visit(tree1);*/


        //Terminate execution if number of command line arguments are less than 2
        if(args.length < 2){
            System.out.println("Incorrect number of arguments!");
            System.exit(0);
        }

        String finalQuery = null;

        //Flag to check if query is to be rewritten
        if(args[1].toLowerCase().equals("true")) {

            /* Parse the input query into an XQuery Tree using XQueryGrammar and ANTLR4 generated classes
            Begin Xquery execution from the root context by invoking visit method on root node of the
            parse tree to obtain a String representation of the query with join optimizations */
            final XQueryGrammarLexer lexer2 = new XQueryGrammarLexer(CharStreams.fromString(xmlQuery));
            final CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
            final XQueryGrammarParser parser2 = new XQueryGrammarParser(tokens2);
            final ParseTree tree2 = parser2.xq();
            final VisitorToOptimizeXQuery visitor2 = new VisitorToOptimizeXQuery();
            finalQuery = visitor2.visit(tree2);

            //Split the file path to get name of the input Xquery file (to append the same to output filename)
            String queryFilePath = args[0];
            String[] temp = queryFilePath.split("/");
            String outputFilePath = "rewritten_queries/optimized_"+temp[temp.length-1];


            //Create output directory (rewritten_queries) if it does not exist and write optimized query to file
            try{
                PrintWriter writer = new PrintWriter(outputFilePath);
                writer.println(finalQuery);
                writer.close();
            }
            catch(Exception e){
                File directory = new File("rewritten_queries");
                directory.mkdir();
                PrintWriter writer = new PrintWriter(outputFilePath);
                writer.println(finalQuery);
                writer.close();
            }
        }

        else {
            finalQuery = xmlQuery;
        }

        //Record time before execution of the query starts
        final long startTime = System.currentTimeMillis();

        //Parse the final query into an XQuery Tree using XQueryGrammar and ANTLR4 generated classes
        final XQueryGrammarLexer lexer = new XQueryGrammarLexer(CharStreams.fromString(finalQuery));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryGrammarParser parser = new XQueryGrammarParser(tokens);

        /* Begin Xquery execution from the root context by invoking visit method on root node of the
        parse tree to obtain a list of output nodes */
        final ParseTree tree = parser.xq();
        final XQueryVisitor visitor = new XQueryVisitor(true);
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

        //Split the file path to get name of the input Xquery file (to append the same to output filename)
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

        //Record time once execution of the query completes
        final long endTime = System.currentTimeMillis();

        //Print the total execution time for the input query
        System.out.println("Total execution time = " + (endTime-startTime) + " milliseconds");
    }
}