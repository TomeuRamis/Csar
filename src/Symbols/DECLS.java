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
public class DECLS extends SimboloBase{
    DECL declaracion;
    DECLS declaraciones;
    public DECLS(DECL decl, DECLS decls){
        super("DECLS");
        
        g.addEdge(this, decl);
        g.addEdge(this, decls);
    }
    
    public DECLS(){
        super("λ");
    }
}
