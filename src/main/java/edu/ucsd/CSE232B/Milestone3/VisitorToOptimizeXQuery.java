package edu.ucsd.CSE232B.Milestone3;

//Import required libraries
import edu.ucsd.CSE232B.parsers.XQueryGrammarParser;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
   This class rewrites input Xquery by using join optimizations.
   A subset of Xqueries which follow the specification as below can be rewritten using join optimizations:

   XQuery
        ::= ’for’ V1 ’in’ Path1’,’ ..., Vn ’in’ Pathn
            ’where’ Cond ’return’ Return

    Path
        ::= (’doc(’FileName’)’|Var) Sep n1 Sep ... Sep nm
        |   (’doc(’FileName’)’|Var) Sep n1 Sep ... Sep ’text()’

    Sep
        ::= ’/’
        |   ’//’

    Return
        ::= Var
        |   Return ’,’ Return
        |   ’<’n’>’ Return ’</’n’>’
        |   Path

    Cond
        ::= (Var|Constant) ’eq’ (Var|Constant)
        |   Cond ’and’ Cond

    Constant
        ::= StringLiteral

   This class extends the VisitorToSerializeXquery class which returns the string representation of the query by
   visiting the abstract syntax tree.
 */

public class VisitorToOptimizeXQuery extends VisitorToSerializeXQuery{

    /* These represent the states the optimizer can be in. The states pertaining to For, Where, Return are checks
    that validate that the input query conforms to the subset grammar which can be rewritten using join optimizations.
    Optimize state is when the optimizer is rewriting the input query and Rewrite return is when the optimized query
    is being returned to the calling function as a string representation */
    private enum CURRENT_STATE{
        INITIAL_STATE, CHECK_FOR_STATE, CHECK_WHERE_STATE, CHECK_RETURN_STATE, OPTIMIZE_STATE,
        REWRITE_RETURN_STATE
    }

    /* Metadata information which will be utilized by the optimizer at each stage of the rewriting phase */
    private class MetadataInfo {

        //Flag indicating whether the query can be optimized
        boolean optimizationFlag = true;

        //Current state of the optimizer which will be set to Initial state at the start
        CURRENT_STATE state = CURRENT_STATE.INITIAL_STATE;

        //Map of variable name to the Xquery associated with it
        HashMap<String, String> variables = new HashMap<>();

        /* This maps the dependencies of every variable in the for clause, i.e. the (key,value) pair
        represents (child,parent) and the parent for root is set as null  */
        HashMap<String, String> variableParentMapping = new HashMap<>();

        //Map from root variable of every independent component, to variables directly or indirectly dependent on it
        LinkedHashMap<String, LinkedList<String>> variableDependencies = new LinkedHashMap<>();

        /* Cyclic map of equalities in the query i.e. for every equality of form $v1=$v2, the equalities for $v1
        would contain $v2 and the equalities for $v2 would contain $v1 */
        HashMap<String, HashSet<String>> variableEqualities = new HashMap<>();

        /* Map of variable equalities, i.e. for variables having restrictions of the form
        'Some constant' = $v1 or $v1 = 'Some constant', $v1 will have mapping to 'Some constant' */
        HashMap<String, LinkedList<String>> variableRestrictions = new HashMap<>();

        /* List of equalities comprising only of string constants i.e. 'Some constant 1' = 'Some constant 2' */
        LinkedList<String> stringEqualities = new LinkedList<>();

        /* List of variables which have been added to the join optimizations in the rewritten query */
        LinkedList<String> variablesJoined = new LinkedList<>();
    }

    //Create a metadata object which will hold the required information at every stage of rewriting the query
    private MetadataInfo information;

    //Constructor to create a new object of Metadata information class
    public  VisitorToOptimizeXQuery() {
        information = new MetadataInfo();
    }

    /* This function returns the rewritten query if optimization is possible else it returns the original query */
    @Override
    public String visitXqueryFLWR(XQueryGrammarParser.XqueryFLWRContext ctx) {

        /* If the current state of optimizer is not initial state or the optimization flag is set to false,
        return string representation of visiting the base class XQueryFLWR rule
         */
        if((information.state != CURRENT_STATE.INITIAL_STATE) || (!information.optimizationFlag)){
            information.optimizationFlag = false;
            return super.visitXqueryFLWR(ctx);
        }

        //Check if the input query conforms to the subset of grammar which can be rewritten using joins (for clause)
        information.state = CURRENT_STATE.CHECK_FOR_STATE;
        visit(ctx.forClause());

        /* If optimization flag is set to false after visiting the for clause,
        return string representation of visiting the base class XQueryFLWR rule as query cannot be rewritten */
        if(!information.optimizationFlag){
            return super.visitXqueryFLWR(ctx);
        }

        /* If the FLWR block consists of a let clause, it does not conform to the subset of grammar which can be rewritten
        and hence return string representation of visiting the base class XQueryFLWR rule */
        if(ctx.letClause()!=null){
            information.optimizationFlag = false;
            return super.visitXqueryFLWR(ctx);
        }

        //Check if the input query conforms to the subset of grammar which can be rewritten using joins (where clause)
        information.state = CURRENT_STATE.CHECK_WHERE_STATE;
        if(ctx.whereClause()!=null){
            visit(ctx.whereClause());
        }

        /* If optimization flag is set to false after visiting the where clause,
        return string representation of visiting the base class XQueryFLWR rule as query cannot be rewritten */
        if(!information.optimizationFlag){
            return super.visitXqueryFLWR(ctx);
        }

        //Check if the input query conforms to the subset of grammar which can be rewritten using joins (return clause)
        information.state = CURRENT_STATE.CHECK_RETURN_STATE;
        visit(ctx.returnClause());

        /* If optimization flag is set to false after visiting the return clause,
        return string representation of visiting the base class XQueryFLWR rule as query cannot be rewritten */
        if(!information.optimizationFlag){
            return super.visitXqueryFLWR(ctx);
        }

        //Once validation is complete, begin the rewriting phase
        information.state = CURRENT_STATE.OPTIMIZE_STATE;
        visit((ctx.forClause()));
        if(ctx.whereClause()!=null){
            visit(ctx.whereClause());
        }

        /* If there is only one root node, i.e. there is only one independent block of variables dependent on each other,
        return string representation of visiting the base class XQueryFLWR rule as there is no implicit join */
        if(information.variableDependencies.size() <=1){

            //Restore the metadata information for further processing of input query
            information = new MetadataInfo();

            return super.visitXqueryFLWR(ctx);
        }

        //Begin structuring the rewritten query
        String query = "for $tuple in ";

        //Fetch left FLWR sub-query
        String left = getNextDependency();

        /* While there are still independent components present, we need to evaluate join attributes between the
        components */
        while(!information.variableDependencies.isEmpty()){

            //List of join attributes belonging to the left and right components
            LinkedList<String> leftJoin = new LinkedList<>();
            LinkedList<String> rightJoin = new LinkedList<>();

            //Fetch the list of variables directly/indirectly related to the root of next independent component
            LinkedList<String> rightVars = information.variableDependencies.entrySet().iterator().next().getValue();

            //For variables already added to the rewritten query
            for(String leftVar : information.variablesJoined) {

                //Create a new HashSet for evaluating if there exists a join condition on the variable
                HashSet<String> leftEqualities = information.variableEqualities.getOrDefault(leftVar, new HashSet<>());

                //For every variable in the next independent component
                for(String rightVar :rightVars){

                    /* Check if there is a variable equality (since it is cyclic, we can check only for
                    variables already added to rewritten query */
                    if(leftEqualities.contains(rightVar)){

                        //If there is a variable equality between independent components, there is a join condition
                        leftJoin.add(leftVar.substring(1));
                        rightJoin.add(rightVar.substring(1));

                        //Remove the variable equalities from metadata information
                        information.variableEqualities.get(rightVar).remove(leftVar);
                        information.variableEqualities.get(leftVar).remove(rightVar);
                    }
                }

            }

            // Fetch the right FLWR sub-query
            String right = getNextDependency();

            //Structure the computed lists as a join condition between 2 independent components
            left = "join (\n"+
                    left + ",\n" +
                    right + ",\n" +
                    "[" + String.join(",",leftJoin) + "]," +
                    "[" + String.join(",",rightJoin) + "])";
        }

        //Set state as Rewrite return as string representation of final return clause is to be added
        information.state = CURRENT_STATE.REWRITE_RETURN_STATE;

        //Append the result of visiting return clause to the string representation of query to be returned
        query += left + visit(ctx.returnClause());

        //Restore the metadata information for further parsing of query
        information = new MetadataInfo();

        return  query;
    }

    /* This function returns the string representation of the next FLWR expression sub-query to used in join */
    private String getNextDependency() {

        //Fetch the root of an independent component
        String root = information.variableDependencies.entrySet().iterator().next().getKey();

        /* Remove the root from the metadata object and fetch nodes directly/indirectly related to it,
        i.e. nodes that are part of one component (FLWR block in rewriting) */
        LinkedList<String> variables = information.variableDependencies.remove(root);

        //Begin the structure of FLWR sub-query
        String query = "\nfor\n";

        //Linked list to store the variables in for clause of the independent component (FLWR sub-query)
        LinkedList<String> forVariables = new LinkedList<>();

        //For every variable in the independent component
        for(int i=0; i< variables.size();i++){

            //Fetch the variable name
            String var = variables.get(i);

            //Add the variable along with the Xquery path associated with it to the forVariables linked list
            forVariables.add(var + " in "+information.variables.get(var));
        }

        //Append each entry in forVariables with a comma and new line to the string representation of query to be returned
        query += String.join(",\n", forVariables);

        //Linked list to store where conditions for the independent component
        LinkedList<String> whereConditions = new LinkedList<>();

        //Add all the equalities in stringEqualities of Metadata to the linked list whereConditions
        whereConditions.addAll(information.stringEqualities);

        //For every variable in the independent component
        for(int i=0; i<variables.size();i++){

            //Fetch the variable name
            String var = variables.get(i);

            /* Fetch all restrictions on variable from Metadata, i.e. restrictions of the form $v1 = 'Some constant'
            or 'Some constant' = $v1  */
            LinkedList<String> restrictions = information.variableRestrictions.getOrDefault(var,new LinkedList<>());

            //For every restriction in the restrictions linked list
            for(int j=0; j< restrictions.size();j++){

                //Add the restriction to the whereConditions linked list
                whereConditions.add(var + " = " + restrictions.get(j));
            }
            //Remove the mapping of variable from the Metadata, as the restriction (value equality) has been added
            information.variableRestrictions.remove(var);
        }

        /* Check if there are any equalities between variables within an independent component of FLWR sub-query */
        //For every variable in the independent component
        for(int i=0; i<variables.size();i++){

            //Fetch the variable name
            String left = variables.get(i);

            //For every variable in the independent component
            for(int  j=0; j<variables.size();j++){

                //Fetch the variable name
                String right = variables.get(j);

                //if there is a variable equality within the independent component, add it to the whereConditions list
                if(information.variableEqualities.getOrDefault(left, new HashSet<>()).contains(right)){
                    whereConditions.add(left + " = " +right);

                    //Remove the cyclic mapping of variable equality from the metadata information
                    information.variableEqualities.get(left).remove(right);
                    information.variableEqualities.get(right).remove(left);
                }

            }
        }

        //Append each entry in whereConditions with an 'and' to the string representation of query to be returned
        if(!whereConditions.isEmpty()){
            query+= "\nwhere " + String.join(" and ",whereConditions);
        }

        // Return part of the FLWR sub-query
        query+= "\nreturn ";

        //List which will hold tags for every variable in the independent component
        LinkedList<String> returnVariables = new LinkedList<>();

        //For every variable in the independent component
        for(int i=0; i<variables.size();i++){

            //Fetch variable name
            String var = variables.get(i);

            //Fetch variable name (without $ sign)
            String variableName = var.substring(1);

            //Create tag representation for every variable
            returnVariables.add("<" + variableName + ">{" + var + "}</" +variableName + ">");
        }

        /* Append each entry in returnVariables with a comma and new line to the string representation of query
        to be returned */
        query += " <tuple>{\n" + String.join(",\n",returnVariables) + "\n}</tuple>";

        //Add the list of variables to the metadata information as they have been incorporated in the rewriting
        information.variablesJoined.addAll(variables);

        return query;
    }

    /* This function populates required data structures used in rewriting phase of the query and returns
    the string representation of the query by visiting the ForClause rule of base class */
    @Override
    public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {

        /* If the optimizer is not in the rewriting phase, return the string representation obtained by visiting
        the base class' ForClause rule */
        if (information.state != CURRENT_STATE.OPTIMIZE_STATE){
            return super.visitForClause(ctx);
        }

        //When the optimizer is in rewriting phase, for every variable in the for clause perform required computations
        for (int i = 0; i<ctx.VARIABLE().size(); i++) {

            //Fetch the variable name from abstract syntax tree
            String variableName = ctx.VARIABLE(i).getText();

            //Fetch the string representation of Xquery associated with it
            String variableQuery = visit(ctx.xq(i));

            //Add the variable, Xquery mapping
            information.variables.put(variableName, variableQuery);

            //If the variable is not undefined
            if (!variableQuery.startsWith("$Undefined") && variableQuery.startsWith("$")) {

                //From the Xquery associated to the variable, fetch the Xpath
                String parentVariable = variableQuery.split("/")[0];

                //Add the map of variable to its parent
                information.variableParentMapping.put(variableName, parentVariable);

                //Declare root for current variable as the parent
                String rootVariable = parentVariable;

                //Recursively get parent of parent, until we reach the root of the independent component
                while (information.variableParentMapping.get(rootVariable) != null) {
                    //Assign parent of parent as root
                    rootVariable = information.variableParentMapping.get(rootVariable);
                }

                //Add variable to list of variables directly/indirectly dependent on the root of the independent component
                information.variableDependencies.get(rootVariable).add(variableName);

            }
            //If current variable is the root itself
            else {
                //Add the mapping of root to its parent (null)
                information.variableParentMapping.put(variableName, null);

                //Create a linked list of variables
                LinkedList<String> variables = new LinkedList<>();

                /* Add root to the linked list of variables and add mapping to list of variables directly/indirectly
                dependent on the root */
                variables.add(variableName);
                information.variableDependencies.put(variableName, variables);
            }
        }

        return super.visitForClause(ctx);
    }

    /* This function returns the string representation of the variable along the path of current context in the
     abstract syntax tree (based on the state of the optimizer) */
    @Override
    public String visitXqueryVariable(XQueryGrammarParser.XqueryVariableContext ctx) {
        String variable = super.visitXqueryVariable(ctx);

        /* If the state is Rewrite return, i.e. the query has been rewritten, the variable would be represented as
        '$tuple/v1/*' in the return clause */
        if (information.state == CURRENT_STATE.REWRITE_RETURN_STATE){

            //Drop the $ sign from variable name
            String variableName = variable.substring(1);

            variable = "$tuple/" + variableName + "/*";
        }
        return variable;
    }

    /* This function returns the string representation of visiting value equality condition by visiting and fetching
    the string representation of xq1 and xq2, In addition, it populates the required data structures which are
    utilized in rewriting the query using join optimizations */
    @Override
    public String visitConditionValueEqualityWord(XQueryGrammarParser.ConditionValueEqualityWordContext ctx) {

        //If the current state is optimize state, i.e. the query is being rewritten
        if (information.state == CURRENT_STATE.OPTIMIZE_STATE){

            //Fetch string representation of the left condition (xq1) and right condition (xq2)
            String leftExpression = visit(ctx.xq(0));
            String rightExpression = visit(ctx.xq(1));

            /* If both the expressions are variables, i.e. the condition is of the form $v1=$v2, we add a cyclic mapping
            to the variable equalities for both the variables */
            if (leftExpression.startsWith("$") && rightExpression.startsWith("$")){
                information.variableEqualities.putIfAbsent(leftExpression, new HashSet<>());
                information.variableEqualities.get(leftExpression).add(rightExpression);
                information.variableEqualities.putIfAbsent(rightExpression, new HashSet<>());
                information.variableEqualities.get(rightExpression).add(leftExpression);
            }

            /* If only the left expression is a variable, i.e. the condition is of the form $v1='Some constant',
            we add a restriction in the variableRestrictions mapping */
            else if (leftExpression.startsWith("$")){
                information.variableRestrictions.putIfAbsent(leftExpression, new LinkedList<>());
                information.variableRestrictions.get(leftExpression).add(rightExpression);
            }

            /* If only the right expression is a variable, i.e. the condition is of the form 'Some constant'=$v1,
            we add a restriction in the variableRestrictions mapping */
            else if (rightExpression.startsWith("$")){
                information.variableRestrictions.putIfAbsent(rightExpression, new LinkedList<>());
                information.variableRestrictions.get(rightExpression).add(leftExpression);
            }

            /* If none of the expressions are variables, the condition is added to stringEqualities mapping */
            else {
                information.stringEqualities.add(leftExpression + " = " + rightExpression);
            }
        }

        //Return the string representation of visiting the base class' ConditionValueEqualityWord rule
        return super.visitConditionValueEqualityWord(ctx);
    }


    /* This function performs similar computations, and returns similar string representation
     as visitConditionValueEqualityWord(). This function is visited when '=' is used instead of 'eq' */
    @Override
    public String visitConditionValueEqualitySym(XQueryGrammarParser.ConditionValueEqualitySymContext ctx) {
        if (information.state == CURRENT_STATE.OPTIMIZE_STATE){
            String leftExpression = visit(ctx.xq(0));
            String rightExpression = visit(ctx.xq(1));

            if (leftExpression.startsWith("$") && rightExpression.startsWith("$")){
                information.variableEqualities.putIfAbsent(leftExpression, new HashSet<>());
                information.variableEqualities.get(leftExpression).add(rightExpression);
                information.variableEqualities.putIfAbsent(rightExpression, new HashSet<>());
                information.variableEqualities.get(rightExpression).add(leftExpression);
            }

            else if (leftExpression.startsWith("$")){
                information.variableRestrictions.putIfAbsent(leftExpression, new LinkedList<>());
                information.variableRestrictions.get(leftExpression).add(rightExpression);
            }

            else if (rightExpression.startsWith("$")){
                information.variableRestrictions.putIfAbsent(rightExpression, new LinkedList<>());
                information.variableRestrictions.get(rightExpression).add(leftExpression);
            }

            else {
                information.stringEqualities.add(leftExpression + " = " + rightExpression);
            }
        }
        return super.visitConditionValueEqualitySym(ctx);
    }


    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryStringConstant(XQueryGrammarParser.XqueryStringConstantContext ctx) {

        /* If the current state is validation of for clause, and this function is visited in evaluation of Xquery
        for a variable declared in for clause, set optimization flag to false as the for clause does not conform
        to the subset of grammar which can be rewritten as join optimizations */
        if (information.state == CURRENT_STATE.CHECK_FOR_STATE){
            information.optimizationFlag = false;
        }

        return super.visitXqueryStringConstant(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryAbsolutePath(XQueryGrammarParser.XqueryAbsolutePathContext ctx) {

        /* If the current state is validation of where clause, and this function is visited in evaluation of Xquery
        for a condition in where clause, set optimization flag to false as the where clause does not conform
        to the subset of grammar which can be rewritten as join optimizations */
        if (information.state == CURRENT_STATE.CHECK_WHERE_STATE){
            information.optimizationFlag = false;
        }

        return super.visitXqueryAbsolutePath(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryConcat(XQueryGrammarParser.XqueryConcatContext ctx) {

        /* If the current state is validation of for or where clause, and this function is visited in evaluation of Xquery
        for a variable declared in for clause or a condition in where clause, set optimization flag to false
        as the for/where clause does not conform to the subset of grammar which can be rewritten as join optimizations */
        if (information.state == CURRENT_STATE.CHECK_FOR_STATE || information.state == CURRENT_STATE.CHECK_WHERE_STATE){
            information.optimizationFlag = false;
        }

        return super.visitXqueryConcat(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryRelativePath(XQueryGrammarParser.XqueryRelativePathContext ctx) {

        /* If the current state is validation of where clause, and this function is visited in evaluation of Xquery
        for a condition in where clause, set optimization flag to false as the where clause does not conform
        to the subset of grammar which can be rewritten as join optimizations */
        if(information.state == CURRENT_STATE.CHECK_WHERE_STATE){
            information.optimizationFlag = false;
        }
        return super.visitXqueryRelativePath(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryAll(XQueryGrammarParser.XqueryAllContext ctx) {

        /* If the current state is validation of where clause, and this function is visited in evaluation of Xquery
        for a condition in where clause, set optimization flag to false as the where clause does not conform
        to the subset of grammar which can be rewritten as join optimizations */
        if (information.state == CURRENT_STATE.CHECK_WHERE_STATE){
            information.optimizationFlag = false;
        }

        return super.visitXqueryAll(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false
    based on the state of the optimizer  */
    @Override
    public String visitXqueryTag(XQueryGrammarParser.XqueryTagContext ctx) {

        /* If the current state is validation of for or where clause, and this function is visited in evaluation of Xquery
        for a variable declared in for clause or a condition in where clause, set optimization flag to false
        as the for/where clause does not conform to the subset of grammar which can be rewritten as join optimizations */
        if((information.state == CURRENT_STATE.CHECK_FOR_STATE) || (information.state == CURRENT_STATE.CHECK_WHERE_STATE)){
            information.optimizationFlag = false;
        }
        return super.visitXqueryTag(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitXQueryJoin(XQueryGrammarParser.XQueryJoinContext ctx) {

        //Set optimization flag to false as queries already consisting of joins cannot be rewritten
        information.optimizationFlag = false;
        return super.visitXQueryJoin(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitXqueryLetClause(XQueryGrammarParser.XqueryLetClauseContext ctx) {

        /* Set optimization flag to false as queries consisting of let clause do not conform to the subset of grammar
        which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitXqueryLetClause(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionIdentityEqualityWord(XQueryGrammarParser.ConditionIdentityEqualityWordContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionIdentityEqualityWord(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionIdentityEqualitySym(XQueryGrammarParser.ConditionIdentityEqualitySymContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionIdentityEqualitySym(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionEmpty(XQueryGrammarParser.ConditionEmptyContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionEmpty(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionSome(XQueryGrammarParser.ConditionSomeContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionSome(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionOr(XQueryGrammarParser.ConditionOrContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionOr(ctx);
    }

    /* This function returns the result of visiting its base class method and sets the optimization flag to false */
    @Override
    public String visitConditionNot(XQueryGrammarParser.ConditionNotContext ctx) {

        /* Set optimization flag to false as queries for which this function is visited as part of whereClause
        do not conform to the subset of grammar which can be rewritten using join optimizations */
        information.optimizationFlag = false;
        return super.visitConditionNot(ctx);
    }
}