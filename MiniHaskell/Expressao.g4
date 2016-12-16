grammar Expressao;

/* Ponto de entrada do Parser. */
start : expr ;


expr  : left=expr op=('*'|'/') right=expr 	#opExpr 	// Maior prioridade
      | left=expr op=('+'|'-') right=expr 	#opExpr		// Menor prioridade 
      | '(' expr ')'                      	#parenExpr	// Parêntese
      | atomo=NUMERO 			  			#atomExpr
      ;


/* Um numero inteiro ou real. */
NUMERO   : ('0'..'9')+ ('.'('0'..'9')+)? ;


/* Ignorar os "white spaces". */
WHITESPACE    : [ \t\r\n]+ -> skip ;
