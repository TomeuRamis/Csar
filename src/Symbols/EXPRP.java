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

    public String expresion;
    public EXPRP(EXPR exp) {
        super("EXPRP", exp.expresion);
        this.expresion = exp.expresion;
        
        g.addVertex("EXPRP");
        g.addVertex("EXPR");
        g.addEdge("EXPRP", "EXPR");
    }
}
