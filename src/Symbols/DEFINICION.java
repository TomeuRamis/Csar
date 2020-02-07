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
public class DEFINICION extends SimboloBase{
    TYPE type;
    codigo.TablaSimbolos.Tipo tipo;
    
    public DEFINICION(TYPE ty) {
        super("DEFINICION");
        tipo = ty.tipo;
        
        g.addEdge(this, ty);
    }
    
    //Se trata de un procedimiento
    public DEFINICION(){
        super("DEFINICION");
        tipo = codigo.TablaSimbolos.Tipo.tNull;
        
        SimboloBase d = new SimboloBase("void");
        g.addEdge(this, d);
    }
    
}
