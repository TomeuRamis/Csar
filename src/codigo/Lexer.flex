package codigo;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
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
int | bool | char { return new Symbol(sym.Tipo, yychar, yyline, yytext());}
const {return new Symbol(sym.Const, yychar, yyline, yytext());}
if { return new Symbol(sym.If, yychar, yyline, yytext());}
else { return new Symbol(sym.Else, yychar, yyline, yytext());} 
while { return new Symbol(sym.While, yychar, yyline, yytext());}
void { return new Symbol(sym.Void, yychar, yyline, yytext());}
in { return new Symbol(sym.In, yychar, yyline, yytext());} 
out { return new Symbol(sym.Out, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
"def" {return new Symbol(sym.Def, yychar, yyline, yytext());}
"return" {return new Symbol(sym.Return, yychar, yyline, yytext());}
"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
( "+" | "-" | "*" | "/" | "%" ) {return new Symbol(sym.Op_aritmetico, yychar, yyline, yytext());}
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}
( ">" | "<" | "==" | "!=" | "=>" | "=<" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}
(true | false) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}
";" {return new Symbol(sym.PuntoYComa, yychar, yyline, yytext());}
"," {return new Symbol(sym.Coma, yychar, yyline, yytext());}
"(" {return new Symbol(sym.A_par, yychar, yyline, yytext());}
")" {return new Symbol(sym.C_par, yychar, yyline, yytext());}
"{" {return new Symbol(sym.A_llave, yychar, yyline, yytext());}
"}" {return new Symbol(sym.C_llave, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Id, yychar, yyline, yytext());}
\"([^\\\"]|\\.)*\" {return new Symbol(sym.String, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

