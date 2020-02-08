/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author tomeu
 */
public class FUNC2 extends SimboloBase{
    
    INSTS insts;
    
    public FUNC2(INSTS insts, codigo.TablaSimbolos ts){
        super("FUNC2");
        this.insts = insts;
        
        ts.salBloque();
        
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
    }
    
}
