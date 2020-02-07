/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class EXPRS extends SimboloBase{

    EXPRP expresionP;
    EXPRS expresiones;
    
    ArrayList<codigo.TablaSimbolos.Tipo> tipos = new ArrayList<>();
         
    public EXPRS(EXPRP exprp) {
        super("EXPRS");
        
        tipos.add(exprp.tipo);  
        
        g.addEdge(this, exprp);
    }
    
    public EXPRS(EXPRP exprp, EXPRS exprs){
        super("EXPRS");
        
        tipos.add(exprp.tipo);
        tipos.addAll(exprs.tipos); //Cuidado, es muy importante el orden en que se añaden
    
        g.addEdge(this, exprp);
        g.addEdge(this, exprs);
    }
    
}
