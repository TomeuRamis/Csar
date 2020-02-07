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
public class FUNCS extends SimboloBase{

    FUNC funcion;
    FUNCS funciones;
           
    public FUNCS(FUNC func, FUNCS funcs) {
        super("FUNCS");
        
        g.addEdge(this, func);
        g.addEdge(this, funcs);
    }
    
    public FUNCS(){
        super("λ");
        g.addEdge(this, new SimboloBase("λ"));
    }
}
