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
public class IO extends SimboloBase{
    
    EXPRP expresion;
    
    public IO(String id, codigo.TablaSimbolos ts) {
        super("IO");
        
        codigo.TablaSimbolos.FilaTD fTd = ts.consulta(id);
        if(fTd == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("ERROR: " + id + " no esta definido");
        }
        
        g.addEdge(this, new SimboloBase("in"));
        g.addEdge(this, new SimboloBase("("));
        SimboloBase i = new SimboloBase(id);
        g.addEdge(this, new SimboloBase(")"));
        g.addEdge(this, i);
    }
    
    public IO(EXPRP exprp){
        super("IO");
        
        g.addEdge(this, new SimboloBase("out"));
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
    }
    
}
