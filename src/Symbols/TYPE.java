/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java_cup.runtime.Symbol;

/**
 *
 * @author Juan
 */
public class TYPE extends SimboloBase {
    codigo.TablaSimbolos.Tipo tipo;
    
    //Comprovamos la cadena t y la convertimos al enumerado Tipo
    public TYPE(String t, int left, int right){
        super("TYPE",left,right);
        
        switch(t){
            case("bool"):
                tipo = codigo.TablaSimbolos.Tipo.tBool;
                break;
            case ("int"):
                tipo = codigo.TablaSimbolos.Tipo.tInt;
                break;
            case ("string"):
                tipo = codigo.TablaSimbolos.Tipo.tString;
                break;
            default:
                //ERROR
                codigo.FrmPrincipal.notificarError("Error semántico: el tipo "+t+" no exsiste. Linea: "+(left+1));
                break;
        }
        
        g.addEdge(this, new SimboloBase(t));
    }
}
