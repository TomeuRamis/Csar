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
public class IO extends SimboloBase{
    
    EXPRP expresion;
    
    public IO(String id, codigo.TablaSimbolos ts) {
        super("IO");
        
        codigo.TablaSimbolos.FilaTD fTd = ts.consulta(id);
        if(fTd == null){
            //ERROR
            System.out.println("ERROR: " + id + " no esta definido");
        }
    }
    
    public IO(){
        super("IO");
    }
    
}
