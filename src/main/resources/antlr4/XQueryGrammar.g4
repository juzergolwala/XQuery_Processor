grammar XQueryGrammar;
import XPathGrammar;

//Rules
xq
    :   VARIABLE                                                                #XqueryVariable
    |   STRING                                                                  #XqueryStringConstant
    |   ap                                                                      #XqueryAbsolutePath
    |   LPR xq RPR                                                              #ParenthesizedXquery
    |   xq '/'  rp                                                              #XqueryRelativePath
    |   xq ',' xq                                                               #XqueryConcat
    |   xq '//' rp                                                              #XqueryAll
    |   '<' IDENTIFIER '>' '{' xq '}' '</' IDENTIFIER '>'                       #XqueryTag
    |   'join' '(' xq ',' xq ',' joinAttributes ',' joinAttributes ')'          #XQueryJoin
    |   letClause xq                                                            #XqueryLetClause
    |   forClause letClause? whereClause? returnClause                          #XqueryFLWR
    ;

forClause
    :   'for' VARIABLE 'in' xq (',' VARIABLE 'in' xq)*
    ;

letClause
    :   'let' VARIABLE ':=' xq (',' VARIABLE ':=' xq)*
    ;

whereClause
    :   'where' cond
    ;

returnClause
    :   'return' xq
    ;

joinAttributes
    :   '[' (IDENTIFIER (',' IDENTIFIER)*)? ']'
    ;

cond
    :   xq '=' xq                                                               #ConditionValueEqualitySym
    |   xq 'eq' xq                                                              #ConditionValueEqualityWord
    |   xq '==' xq                                                              #ConditionIdentityEqualitySym
    |   xq 'is' xq                                                              #ConditionIdentityEqualityWord
    |   'empty' '(' xq ')'                                                      #ConditionEmpty
    |   'some' VARIABLE 'in' xq (',' VARIABLE 'in' xq)* 'satisfies' cond        #ConditionSome
    |   '(' cond ')'                                                            #ParenthesizedCondition
    |   cond 'and' cond                                                         #ConditionAnd
    |   cond 'or' cond                                                          #ConditionOr
    |   'not' cond                                                              #ConditionNot
    ;

//Tokens
VARIABLE: '$' IDENTIFIER;