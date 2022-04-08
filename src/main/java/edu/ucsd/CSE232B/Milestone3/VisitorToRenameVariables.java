package edu.ucsd.CSE232B.Milestone3;

//Import required libraries
import edu.ucsd.CSE232B.parsers.XQueryGrammarParser;
import java.util.HashMap;

/*
   This class renames variables as v1,v2....vn to ensure that there are no duplicate variable names in the query
   which is to be optimized, and it follows the subset of Xquery specification which can be optimized using joins.

   This class extends the VisitorToSerializeXquery class which returns the string representation of the query by
   visiting the abstract syntax tree.
 */
public class VisitorToRenameVariables extends VisitorToSerializeXQuery{

    //This integer will hold the variable number to be appended to each variable name
    private int variableNumber;

    //This is the prefix used for each variable name
    private String prefixOfVariables;

    //This is the prefix for undefined variables, i.e. variables not defined in for, let or some(condition) clause
    private String prefixForUndefinedVariables;

    //This maps the name of original variable to the latest used variable name of form 'vi'
    private HashMap<String, String> variables;

    public VisitorToRenameVariables() {
        this.variableNumber = 1;
        this.prefixOfVariables = "$v";
        this.prefixForUndefinedVariables = "$Undefined";
        this.variables = new HashMap<>();
    }

    /* This function returns a new variable name to the calling function */
    private String getNextVariableName() {
        String variableName = prefixOfVariables + variableNumber;
        variableNumber++;
        return variableName;
    }

    /* This function returns a new undefined variable name to the calling function */
    private String getNextUndefinedVariable() {
        String variableName = prefixForUndefinedVariables + variableNumber;
        variableNumber++;
        return variableName;
    }

    /* This function fetches and returns the new variable name from original variable name */
    private String getVariableName(String variable) {

        //If variable is already defined it will be present in the HashMap
        if(variables.containsKey((variable))){
            return variables.get(variable);
        }

        //If variable is not previously defined, return an undefined variable
        return getNextUndefinedVariable();
    }

    /* This function fetches and returns the string representation of new variable name for a
     variable used in the Xquery */
    @Override
    public String visitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx) {
        return getVariableName(ctx.VARIABLE().getText());
    }

    /* This function visits the base XqueryLetClause to fetch the string representation of visiting the rule
    XQueryLetClause. In addition, the HashMap of original to new variable name mapping is used to rename the variables
    in the final string representation */
    @Override
    public String visitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx) {
        //Create a temporary map of variable names
        HashMap<String, String> tmp = new HashMap<>(this.variables);

        //Fetch the string representation of the visiting rule
        String query = super.visitXqueryLetClause(ctx);

        //Restore the map of variables for further parsing of query (abstract syntax tree)
        this.variables = tmp;

        return query;
    }

    /* This function visits the base XQueryFLWR to fetch the string representation of visiting the rule
    XQueryFLWR. In addition, the HashMap of original to new variable name mapping is used to rename the variables
    in the final string representation */
    @Override
    public String visitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx) {
        //Create a temporary map of variable names
        HashMap<String, String> tmp = new HashMap<>(this.variables);

        //Fetch the string representation of the visiting rule
        String query = super.visitXqueryFLWR(ctx);

        //Restore the map of variables for further parsing of query (abstract syntax tree)
        this.variables = tmp;

        return query;
    }

    /* This function populates the mapping of variables as new variables are introduced, and returns the string
    representation of visiting the for clause with variables being renamed */
    @Override
    public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        String query = " for ";

        //For every variable in the for clause
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            //Fetch a new variable name for every variable declared in the for clause
            String var = getNextVariableName();

            //Fetch the string representation of the Xquery associated with it
            String xQuery = visit(ctx.xq(i));

            //Populate the map of variables with original to new variable mapping
            variables.put(ctx.VARIABLE(i).getText(), var);

            //Append to the string representation to be returned
            query+= var + " in " + xQuery;

            //If we have not reached the last variable in the for clause, add a comma to the string representation
            if(i!= (ctx.VARIABLE().size()-1)){
                query+= ",";
            }
        }
        return query;
    }

    /* This function populates the mapping of variables as new variables are introduced, and returns the string
    representation of visiting the let clause with variables being renamed */
    @Override
    public String visitLetClause(XQueryGrammarParser.LetClauseContext ctx) {
        String query = " let ";

        //For every variable in the let clause
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            //Fetch a new variable name for every variable declared in the let clause
            String var = getNextVariableName();

            //Fetch the string representation of the Xquery associated with it
            String xQuery = visit(ctx.xq(i));

            //Populate the map of variables with original to new variable mapping
            variables.put(ctx.VARIABLE(i).getText(), var);

            //Append to the string representation to be returned
            query+= var + ":=" + xQuery;

            //If we have not reached the last variable in the let clause, add a comma to the string representation
            if(i!= (ctx.VARIABLE().size()-1)){
                query+= ",";
            }
        }

        return query;
    }

    /* This function populates the mapping of variables as new variables are introduced, and returns the string
    representation of visiting the rule ConditionSome with variables being renamed */
    @Override
    public String visitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx) {
        //Create a temporary map of variable names
        HashMap<String, String> tmp = new HashMap<>(this.variables);
        String query = " some ";

        //For every variable introduced in the some condition
        for(int i=0; i<ctx.VARIABLE().size(); i++){

            //Fetch a new variable name for every variable declared in the some condition
            String var = getNextVariableName();

            //Fetch the string representation of the Xquery associated with it
            String xQuery = visit(ctx.xq(i));

            //Populate the map of variables with original to new variable mapping
            variables.put(ctx.VARIABLE(i).getText(), var);

            //Append to the string representation to be returned
            query+= var + " in " + xQuery;

            //If we have not reached the last variable in the some condition, add a comma to the string representation
            if(i!= (ctx.VARIABLE().size()-1)){
                query+= ",";
            }
        }

        /* Append to the string representation to be returned by visiting and fetching the string representation of the
        condition */
        query+= " satisfies " + visit(ctx.cond());

        //Restore the map of variables for further parsing of query (abstract syntax tree)
        this.variables = tmp;

        return query;

    }
}