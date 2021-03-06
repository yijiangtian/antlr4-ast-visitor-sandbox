grammar Expr;
@header {
package de.zeigermann.compilerSandbox.parser;

import de.zeigermann.compilerSandbox.ast.*;
import de.zeigermann.compilerSandbox.ast.Number;

}

@lexer::header {
package de.zeigermann.compilerSandbox.parser;
}

start returns [Expression expr]
  : expr
      { expr = $expr.expr; }
    EOF
  ;

expr returns [Expression expr]
  : left=mulExpr 
    ((operator='+'|operator='-') right=expr
      { expr = new Operation($operator.text, $left.expr, $right.expr); }
    | 
      { expr = $left.expr; }
    )
  ;

mulExpr returns [Expression expr]
  : left=atom 
    ((operator='*'|operator='/') right=mulExpr
      { expr = new Operation($operator.text, $left.expr, $right.expr); }
    | 
      { expr = $left.expr; }
    )
  ;

atom returns [Expression expr]
   : value=INT { expr = new Number($value.text); }
   | '(' expr ')' { expr = $expr.expr; }
   ;

INT	:	('0'..'9')+
	;

WS  :   (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;}
    ;    
