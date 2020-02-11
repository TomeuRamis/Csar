package codigo;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
T = [áàéèíìóòúùÁÀÉÈÍÌÓÒÚÙñçüÑÇÜ]
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+
%{
    private string tokens = "";
    
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);
    }
    private Symbol symbol (int type){
        return new Symbol (type, yyline, yycolumn);
    }
%}
%%
int | bool | string {tokens+="<tipo>"; return symbol(sym.Tipo, yytext());}
const { tokens+="<tipo>"; return symbol(sym.Const, yytext());}
if { tokens+="<tipo>"; return symbol(sym.If, yytext());}
else { tokens+="<tipo>"; return symbol(sym.Else, yytext());} 
while { tokens+="<tipo>"; return symbol(sym.While, yytext());}
void { tokens+="<tipo>"; return symbol(sym.Void, yytext());}
in { tokens+="<tipo>"; return symbol(sym.In, yytext());} 
out { tokens+="<tipo>"; return symbol(sym.Out, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"main" { tokens+="<tipo>"; return symbol(sym.Main, yytext());}
"def" { tokens+="<tipo>"; return symbol(sym.Def, yytext());}
"return" { tokens+="<tipo>"; return symbol(sym.Return, yytext());}
"=" { tokens+="<tipo>"; return symbol(sym.Igual, yytext());}
( "+" | "-" | "*" | "/" | "%" ) { tokens+="<tipo>"; return symbol(sym.Op_aritmetico, yytext());}
( "&&" | "||" ) { tokens+="<tipo>"; return symbol(sym.Op_logico, yytext());}
( ">" | "<" | "==" | "!=" | "=>" | "=<" ) { tokens+="<tipo>"; return symbol(sym.Op_relacional, yytext());}
(true | false) { tokens+="<tipo>"; return symbol(sym.Op_booleano, yytext());}
";" { tokens+="<tipo>"; return symbol(sym.PuntoYComa, yytext());}
"," { tokens+="<tipo>"; return symbol(sym.Coma, yytext());}
"(" { tokens+="<tipo>"; return symbol(sym.A_par, yytext());}
")" { tokens+="<tipo>"; return symbol(sym.C_par, yytext());}
"{" { tokens+="<tipo>"; return symbol(sym.A_llave, yytext());}
"}" { tokens+="<tipo>"; return symbol(sym.C_llave, yytext());}
({L}|{T})({L}|{D}|{T})* { tokens+="<tipo>"; return symbol(sym.Id, yytext());}
\"([^\\\"]|\\.)*\" { tokens+="<tipo>"; return symbol(sym.String, yytext());}
("(-"{D}+")")|{D}+ { tokens+="<tipo>"; return symbol(sym.Numero, yytext());}
 . {FrmPrincipal.notificarError("Error léxico: "+yytext()+" en linea: "+(yyline+1)+" columna: "+(yycolumn+1));}

