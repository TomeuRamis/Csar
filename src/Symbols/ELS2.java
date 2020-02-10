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
public class ELS2 extends SimboloBase{
    
    INSTS insts;
    
    public ELS2(INSTS insts, codigo.TablaSimbolos ts){
        super("ELS2",insts.fila,insts.columna);
        
        this.insts = insts;
        
        ts.salBloque();
        
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
    }
    
}
