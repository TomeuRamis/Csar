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
public class P1 extends SimboloBase{
    
    public P1 (DECLS decls, codigo.TablaSimbolos ts){
        super("P1");
        
        ts.entraBloque();
        
        g.addEdge(this, decls);
        g.addEdge(this, new SimboloBase("main"));
        g.addEdge(this, new SimboloBase("{"));
    }
    
}
