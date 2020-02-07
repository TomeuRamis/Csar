/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java_cup.runtime.Symbol;

/**
 *
 * @author Juan
 */
public class P extends SimboloBase{
    DECL declaraciones;
    INSTS instrucciones;
    FUNCS funciones;
    
    public P(DECLS decls, INSTS insts, FUNCS funcs){
        super("P");
        
        System.out.println("Fin del análisis");
        
        g.addEdge(this, decls);
        g.addEdge(this, new SimboloBase("main"));
        g.addEdge(this, new SimboloBase("{"));
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
        g.addEdge(this, funcs);
        
        this.imprimirArbol();
    }
}
