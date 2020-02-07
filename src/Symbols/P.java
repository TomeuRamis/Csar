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
    
    public P(P1 p1, P2 p2){
        super("P");
        
        System.out.println("Fin del análisis");

        g.addEdge(this, p1);
        g.addEdge(this, p2);
        
        this.imprimirArbol();
    }
}
