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
public class PARAM extends SimboloBase{

    TYPE type;
    codigo.TablaSimbolos.Tipo tipo;
    String idParam;
    
    //Guardamos el tipo y el id para poder añadirlo más arriba
    public PARAM(TYPE t, String id) {
        super("PARAM");
        tipo = t.tipo;
        idParam = id;      
        
        SimboloBase i = new SimboloBase(id);
        g.addEdge(this, t);
        g.addEdge(this, i);
    }
    
}
