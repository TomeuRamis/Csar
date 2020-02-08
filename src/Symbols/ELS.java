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
public class ELS extends SimboloBase{
    CND condicion;
    INSTS instrucciones;
    
    public ELS(CND cnd, codigo.TablaSimbolos ts) {
        super("ELS");
        
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, cnd);
    }
    
    public ELS(ELS1 els1, ELS2 els2){
        super("ELS");
        
        g.addEdge(this, els1);
        g.addEdge(this, els2);
        
    }
    
    public ELS(codigo.TablaSimbolos ts){
        super("λ");
        ts.salBloque();
    }
    
}
