package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_ÑñÇçüÜ]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int | bool | char { lexeme=yytext(); return Tipo};
const {return Const;}
if { return If;}
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/Ignore/}
"//". {/Ignore/}
"main" {return Main;}
"def" {return Def;}
"return" {return Return;}
"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"" {return Multiplicacion;}
"/" {return Division;}
";" {return PuntoYComa;}
"(" {return a_par;}
")" {return c_par;}
"{" {return a_cor;}
"}" {return c_cor;}
{L}({L}|{D}) {lexeme=yytext(); return Id;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}