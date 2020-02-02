package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_ÑñÇçüÜ]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    public String lexeme;
%}
%%
int | bool | char { lexeme=yytext(); return Tipo;}
const {return Const;}
if { return If;}
else { return Else;} 
while { return While;}
void { return Void;}
in { return In;} 
out { return Out;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"main" {return Main;}
"def" {return Def;}
"return" {return Return;}
"=" {return Igual;}
( "+" | "-" | "*" | "/" | "%" ) {lexeme=yytext(); return Op_aritmetico;}
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}
( ">" | "<" | "==" | "!=" | "=>" | "=<" ) {lexeme = yytext(); return Op_relacional;}
(true | false) {lexeme = yytext(); return Op_booleano;}
";" {return PuntoYComa;}
"," {return Coma;}
"(" {return a_par;}
")" {return c_par;}
"{" {return a_llave;}
"}" {return c_llave;}
{L}({L}|{D})* {lexeme=yytext(); return Id;}
"'".*."'" {lexeme=yytext(); return String;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}

