package codigo;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
L=[a-zA-Z_ÑñÇçüÜ]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);
    }
    private Symbol symbol (int type){
        return new Symbol (type, yyline, yycolumn);
    }
%}
%%
int | bool | string { return symbol(sym.Tipo, yytext());}
const {return symbol(sym.Const, yytext());}
if { return symbol(sym.If, yytext());}
else { return symbol(sym.Else, yytext());} 
while { return symbol(sym.While, yytext());}
void { return symbol(sym.Void, yytext());}
in { return symbol(sym.In, yytext());} 
out { return symbol(sym.Out, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"main" {return symbol(sym.Main, yytext());}
"def" {return symbol(sym.Def, yytext());}
"return" {return symbol(sym.Return, yytext());}
"=" {return symbol(sym.Igual, yytext());}
( "+" | "-" | "*" | "/" | "%" ) {return symbol(sym.Op_aritmetico, yytext());}
( "&&" | "||" | "!") {return symbol(sym.Op_logico, yytext());}
( ">" | "<" | "==" | "!=" | "=>" | "=<" ) {return symbol(sym.Op_relacional, yytext());}
(true | false) {return symbol(sym.Op_booleano, yytext());}
";" {return symbol(sym.PuntoYComa, yytext());}
"," {return symbol(sym.Coma, yytext());}
"(" {return symbol(sym.A_par, yytext());}
")" {return symbol(sym.C_par, yytext());}
"{" {return symbol(sym.A_llave, yytext());}
"}" {return symbol(sym.C_llave, yytext());}
{L}({L}|{D})* {return symbol(sym.Id, yytext());}
\"([^\\\"]|\\.)*\" {return symbol(sym.String, yytext());}
("(-"{D}+")")|{D}+ {return symbol(sym.Numero, yytext());}
 . {FrmPrincipal.notificarError("Error léxico: "+yytext()+" en linea: "+(yyline+1)+" columna: "+(yycolumn+1));}

