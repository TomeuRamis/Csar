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
public class CND2 extends SimboloBase{
    
    INSTS insts;
    
    public CND2(INSTS insts, ELS els, codigo.TablaSimbolos ts){
        super("CND2",insts.fila,insts.columna);
        
        this.insts = insts;
        
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
        g.addEdge(this, els);
    }
}
