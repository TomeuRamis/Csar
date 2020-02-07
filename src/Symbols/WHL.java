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
public class WHL extends SimboloBase{
    
    EXPR expresion;
    INSTS instruccion;
    
    //Comprueba expr sea un booleano
    public WHL(EXPRP exprp, INSTS instruccion){
       super("WHL");
       if(exprp.tipo != codigo.TablaSimbolos.Tipo.tBool){
           //ERROR
           codigo.FrmPrincipal.notificarError("ERROR: La condicion no es booleana");
       }
       
       g.addEdge(this, new SimboloBase("while"));
       g.addEdge(this, new SimboloBase("("));
       g.addEdge(this, exprp);
       g.addEdge(this, new SimboloBase(")"));
       g.addEdge(this, new SimboloBase("{"));
       g.addEdge(this, instruccion);      
       g.addEdge(this, new SimboloBase("}"));

    }
}
