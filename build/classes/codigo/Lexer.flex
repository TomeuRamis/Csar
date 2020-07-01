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
espacio=[ \t\r]+
linea=[\n]+
%{
    private String tokens = "";
    
    public String getTokens(){
        return tokens;
    }
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);
    }
    private Symbol symbol (int type){
        return new Symbol (type, yyline, yycolumn);
    }
%}
%%
int | bool {tokens+="<tipo>"; return symbol(sym.Tipo, yytext());}
const { tokens+="<const>"; return symbol(sym.Const, yytext());}
if { tokens+="<if>"; return symbol(sym.If, yytext());}
else { tokens+="<else>"; return symbol(sym.Else, yytext());} 
while { tokens+="<while>"; return symbol(sym.While, yytext());}
void { tokens+="<void>"; return symbol(sym.Void, yytext());}
in { tokens+="<in>"; return symbol(sym.In, yytext());} 
out { tokens+="<out>"; return symbol(sym.Out, yytext());}
{espacio} {/*Ignore*/}
{linea} {tokens+="\n";}
"//".* {/*Ignore*/}
"main" { tokens+="<main>"; return symbol(sym.Main, yytext());}
"def" { tokens+="<def>"; return symbol(sym.Def, yytext());}
"return" { tokens+="<return>"; return symbol(sym.Return, yytext());}
"=" { tokens+="<igual>"; return symbol(sym.Igual, yytext());}
( "+" | "-" | "*" | "/" | "%" ) { tokens+="<op_aritmetico>"; return symbol(sym.Op_aritmetico, yytext());}
( "&&" | "||" ) { tokens+="<op_logico>"; return symbol(sym.Op_logico, yytext());}
( ">" | "<" | "==" | "!=" | "=>" | "=<" ) { tokens+="<op_relacional>"; return symbol(sym.Op_relacional, yytext());}
(true | false) { tokens+="<booleano>"; return symbol(sym.Op_booleano, yytext());}
";" { tokens+="<p_coma>"; return symbol(sym.PuntoYComa, yytext());}
"," { tokens+="<coma>"; return symbol(sym.Coma, yytext());}
"(" { tokens+="<a_par>"; return symbol(sym.A_par, yytext());}
")" { tokens+="<c_par>"; return symbol(sym.C_par, yytext());}
"{" { tokens+="<a_llave>"; return symbol(sym.A_llave, yytext());}
"}" { tokens+="<c_llave>"; return symbol(sym.C_llave, yytext());}
({L}|{T})({L}|{D}|{T})* { tokens+="<id>"; return symbol(sym.Id, yytext());}
/* \"([^\\\"]|\\.)*\" { tokens+="<string>"; return symbol(sym.String, yytext());} */
("(-"{D}+")")|{D}+ { tokens+="<numero>"; return symbol(sym.Numero, yytext());}
 . { tokens+="<error>"; FrmPrincipal.notificarError("Error léxico: "+yytext()+" en linea: "+(yyline+1)+" columna: "+(yycolumn+1));}

