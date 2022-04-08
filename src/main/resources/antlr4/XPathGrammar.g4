grammar XPathGrammar;

@header {
package edu.ucsd.CSE232B.parsers;
}

//Rules
ap
    :   docName '/' rp                  #XpathChildren
    |   docName '//' rp                 #XpathAll
    ;

docName
    :   DOC LPR STRING RPR              #DocumentName
    ;

rp
    :   IDENTIFIER                      #TagName
    |   '*'                             #WildCard
    |   '.'                             #CurrentContext
    |   '..'                            #ParentOfContext
    |   'text()'                        #GetText
    |   '@' IDENTIFIER                  #AttributeName
    |   LPR rp RPR                      #ParenthesizedRP
    |   rp '/' rp                       #ChildrenRP
    |   rp '//' rp                      #DescendantsRP
    |   rp '[' f ']'                    #FilterRP
    |   rp ',' rp                       #ConcatRP
    ;

f
    :   rp                              #FilteredRP
    |   rp '=' rp                       #ValueEqualitySym
    |   rp 'eq' rp                      #ValueEqualityWord
    |   rp '==' rp                      #IdentityEqualitySym
    |   rp 'is' rp                      #IdentityEqualityWord
    |   rp '=' STRING                   #ConstantEquality
    |   LPR f RPR                       #ParenthesizedFilter
    |   f 'and' f                       #AndFilter
    |   f 'or' f                        #OrFilter
    |   'not' f                         #NotFilter
    ;

//Tokens
DOC: D O C;
fragment D: [dD];
fragment O: [oO];
fragment C: [cC];
LPR: '(';
RPR: ')';
STRING: '"' ~('"')* '"';
IDENTIFIER: [a-zA-Z][a-zA-Z_0-9]*;
WS: [ \t\n\r]+ -> skip;