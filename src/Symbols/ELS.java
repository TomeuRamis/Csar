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
    
    public ELS(CND cnd) {
        super("ELS",cnd.fila,cnd.columna);
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, cnd);
    }
    
    public ELS(ELS1 els1, ELS2 els2){
        super("ELS",els2.fila,els2.columna);
        
        g.addEdge(this, els1);
        g.addEdge(this, els2);
        
    }
    
    public ELS(){
        super("λ");
    }
    
}
