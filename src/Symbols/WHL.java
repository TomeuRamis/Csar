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
public class WHL extends SimboloBase{
    
    EXPR expresion;
    INSTS instruccion;
    
    //Comprueba expr sea un booleano
    public WHL(WHL1 whl1, WHL2 whl2){
       super("WHL");
       
       g.addEdge(this, whl1);
       g.addEdge(this, whl2);

    }
}
