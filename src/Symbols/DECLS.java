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
        super("DECLS",decl.fila,decl.columna);
        declaracion = decl;
        declaraciones = decls;
        g.addEdge(this, decl);
        g.addEdge(this, new SimboloBase(";"));
        g.addEdge(this, decls);
    }
    
    public DECLS(){
        super("DECLS");
        g.addEdge(this, new SimboloBase("λ"));
    }
    public void gest(){
        if(declaraciones != null){
            declaracion.gest();
            declaraciones.gest();
        }
    }
}

