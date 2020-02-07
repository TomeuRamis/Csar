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
public class INST extends SimboloBase {
    
    ASIG asignacion;
    WHL mientras;
    DCL declaracion;
    CND condicion;
    IO io;
    CALL llamada;
    RET retorno;
    
    public INST(Object o){
        super("INST");
        
        g.addEdge(this, (SimboloBase) o); //Ojo que esto es un poco cutre
    }
}
