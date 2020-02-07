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
public class RET extends SimboloBase{
    EXPRP expresionP;
    codigo.TablaSimbolos.Tipo tipo;
    public RET(EXPRP exprp) {
        super("RET");
        tipo = exprp.tipo;
        
        g.addEdge(this, new SimboloBase("return"));
        g.addEdge(this, exprp);
    }
    
    
}
