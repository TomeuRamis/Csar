/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.TablaSimbolos;

/**
 *
 * @author Juan
 */
public class DCL extends SimboloBase{
    TYPE tipo;
    ASIGNACION asignacion;
    String id;
    
    //Comprueba si existe id y compara los tipos de type y asignacion
    public DCL(TYPE tipo, String id, ASIGNACION asignacion, codigo.TablaSimbolos ts) {
        super("DCL");
        
        codigo.TablaSimbolos.FilaTD fTd = ts.consulta(id);
        if(tipo.tipo != asignacion.tipo) {
            //ERROR
            System.out.println("ERROR: " + id + " los tipos no coinciden");
        } else if(!ts.add(id, tipo.tipo, codigo.TablaSimbolos.Mvp.dvar)){
            //ERROR
            System.out.println("ERROR: " + id + "Ya esta definido");
        } else{
            this.id = id;
        }
        
        
    }
    
}
