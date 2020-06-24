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
    int e;
    public DECLS(DECL decl, DECLS decls){
        super("DECLS",decl.fila,decl.columna);
        declaracion = decl;
        declaraciones = decls;
        g.addEdge(this, decl);
        g.addEdge(this, new SimboloBase(";"));
        g.addEdge(this, decls);
        e = decls.e;
    }
    
    public DECLS(){
        super("DECLS");
        g.addEdge(this, new SimboloBase("λ"));
        e = C3D.nuevaEtiqueta();
        C3D.genera(codigo.idInstrucciones.GOTO.ordinal(), -1, -1, e);
    }
}

