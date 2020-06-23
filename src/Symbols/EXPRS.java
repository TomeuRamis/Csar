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
    
    ArrayList<Integer> pparams;
    
    ArrayList<codigo.TablaSimbolos.Tipo> tipos = new ArrayList<>();
         
    public EXPRS(EXPRP exprp) {
        super("EXPRS",exprp.fila,exprp.columna);
        
        tipos.add(exprp.tipo);  
        
        g.addEdge(this, exprp);
        
        pparams = new ArrayList<>();
        pparams.add(exprp.r);
    }
    
    public EXPRS(EXPRP exprp, EXPRS exprs){
        super("EXPRS",exprp.fila,exprp.columna);
        
        tipos.add(exprp.tipo);
        tipos.addAll(exprs.tipos); //Cuidado, es muy importante el orden en que se añaden
    
        g.addEdge(this, exprp);
        g.addEdge(this,new SimboloBase(","));
        g.addEdge(this, exprs);
        
        this.pparams = exprs.pparams;
        this.pparams.add(exprp.r);
    }
    
}
