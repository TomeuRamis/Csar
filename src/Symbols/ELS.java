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
        super("ELS");
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, cnd);
    }
    
    public ELS(INSTS insts){
        super("ELS");
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, new SimboloBase("{"));
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
    }
    
    public ELS(){
        super("λ");
    }
    
}
