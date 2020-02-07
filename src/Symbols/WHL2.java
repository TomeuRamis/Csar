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
public class WHL2 extends SimboloBase {

    public WHL2(INSTS instruccion, codigo.TablaSimbolos ts) {
        super("WHL2");

        ts.salBloque();
        
        g.addEdge(this, instruccion);
        g.addEdge(this, new SimboloBase("}"));
    }
}
