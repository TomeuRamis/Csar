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
public class ELS1 extends SimboloBase{
    
    public ELS1(codigo.TablaSimbolos ts){
        super("ELS1");
        
        ts.entraBloque();
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, new SimboloBase("{"));
    }
}
