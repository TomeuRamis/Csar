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
public class CND extends SimboloBase{
    EXPRP expresionp;
    
    //Comprueba que la condicion sea booleana
    public CND(EXPRP exprp, INSTS insts, ELS els) {
        super("CND");
        if(exprp.tipo != codigo.TablaSimbolos.Tipo.tBool){
            //ERROR
            System.out.println("ERROR: La condicion no es booleana");
        }
        
        g.addEdge(this, exprp);
        g.addEdge(this, insts);
        g.addEdge(this, els);
    }
    
}
