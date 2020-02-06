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
public class EXPRP extends SimboloBase {

    EXPRP expresionP;
    OPERADOR operador;
    EXPR expresion;
    
    public String expr;
    public EXPRP(EXPR exp) {
        super("EXPRP", exp.expr);
        this.expr = exp.expr;
        
        g.addVertex("EXPRP");
        g.addVertex("EXPR");
        g.addEdge("EXPRP", "EXPR");
    }
}
