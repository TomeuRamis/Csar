/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author Juan
 */
public class EXPRP extends SimboloBase {

    EXPRP expresionP;
    OPERADOR operador;
    EXPR expresion;
    
    codigo.TablaSimbolos.Tipo tipo;

    public EXPRP(EXPR exp) {
        super("EXPRP");
        
        tipo = exp.tipo;
        
        g.addEdge(this, exp);
    }
    
    public EXPRP(EXPRP exprp, OPERADOR operador, EXPR expr){
        super("EXPRP");
        /*
          El tipo de la expresion será el tipo de las expresiones
          Se debe comprobar que ambas expresiones tengan tipos compatibles y que
          el operador se pueda utilizar con ese tipo de datos.
        */
        if(exprp.tipo != expr.tipo){ //Los tipos no coinciden
            this.tipo = codigo.TablaSimbolos.Tipo.tNull;
            //ERROR
            codigo.FrmPrincipal.notificarError("ERROR: Operacion entre los tipos incompatibles "+exprp.tipo+" y "+expr.tipo);
        }else{
            if(exprp.tipo == codigo.TablaSimbolos.Tipo.tInt){ //Son numeros
                //Operadores relacionales
                //Operadores aritmeticos
                if(operador.tOp == OPERADOR.tOperador.tLogico){
                    //ERROR
                    System.out.println("ERROR: Operador incompatible");
                } else if(operador.tOp == OPERADOR.tOperador.tRelacional){
                    tipo = codigo.TablaSimbolos.Tipo.tBool;
                } else {
                    tipo = codigo.TablaSimbolos.Tipo.tInt;
                }
            }
            if(exprp.tipo == codigo.TablaSimbolos.Tipo.tString){ //Son strings
                //Operadores relacionales (Comparacion y diferencia)
                if(!operador.operador.equals("==") && !operador.operador.equals("!=") && !operador.operador.equals("+")){
                    //ERROR
                    System.out.println("ERROR: Operador incompatible");
                } else if(operador.tOp == OPERADOR.tOperador.tRelacional){
                    tipo = codigo.TablaSimbolos.Tipo.tBool;
                } else {
                    tipo = codigo.TablaSimbolos.Tipo.tString;
                }
            }
                
            if(exprp.tipo == codigo.TablaSimbolos.Tipo.tBool){ //Son booleanos
                //Operadores relacionales (Comparacion y diferencia)
                //Operadores logicos
                if(operador.tOp != OPERADOR.tOperador.tLogico && !operador.operador.equals("==") && !operador.operador.equals("!=")){
                    //ERROR
                    System.out.println("ERROR: Operador incompatible");
                }else {
                    tipo = codigo.TablaSimbolos.Tipo.tBool;
                }
            }
        }
        
        g.addEdge(this, exprp);
        g.addEdge(this, operador);
        g.addEdge(this, expr);
    }
}
