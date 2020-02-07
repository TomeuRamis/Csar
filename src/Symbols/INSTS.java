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
public class INSTS extends SimboloBase{
    
    INST instruccion;
    INSTS instrucciones;
    
    public INSTS(INST inst, INSTS insts){
        super("INSTS");

        g.addEdge(this, inst);
        g.addEdge(this, insts);
    }
    
    public INSTS(){
        super("INSTS");
        g.addEdge(this, new SimboloBase("λ"));
    }
}
