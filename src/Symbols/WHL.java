/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author Juan
 */
public class WHL extends SimboloBase{
    
    EXPR expresion;
    INSTS instrucciones;
    
    //Comprueba expr sea un booleano
    public WHL(WHL1 whl1, WHL2 whl2){
       super("WHL",whl1.fila,whl1.columna);
       
       this.instrucciones = whl2.insts;
       g.addEdge(this, whl1);
       g.addEdge(this, whl2);

       C3D.genera(idInstrucciones.GOTO.ordinal(),-1, -1, whl1.e);
       C3D.genera(idInstrucciones.SKIP.ordinal(),-1, -1, whl1.efi);
    }
}
