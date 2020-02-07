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
public class P2 extends SimboloBase{
    
    public P2(INSTS insts, FUNCS funcs, codigo.TablaSimbolos ts){
        super("P2");
        
        ts.salBloque();
        
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
        g.addEdge(this, funcs);
    }
    
}
