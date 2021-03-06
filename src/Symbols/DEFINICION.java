/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author Juan
 */
public class DEFINICION extends SimboloBase{
    codigo.TablaSimbolos.Tipo tipo;
    int e;
    
    public DEFINICION(TYPE ty) {
        super("DEFINICION",ty.fila,ty.columna);
        tipo = ty.tipo;
        
        g.addEdge(this, new SimboloBase("Def"));
        g.addEdge(this, ty);
        
        e = C3D.nuevaEtiqueta();
        C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e);
    }
    
    //Se trata de un procedimiento
    public DEFINICION(int left, int right){
        super("DEFINICION",left,right);
        tipo = codigo.TablaSimbolos.Tipo.tNull;
        
        g.addEdge(this, new SimboloBase("Def"));
        g.addEdge(this, new SimboloBase("void"));
        
        e = C3D.nuevaEtiqueta();
        C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e);
    }
    
}
