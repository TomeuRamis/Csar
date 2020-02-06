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
public class TYPE extends SimboloBase {
    codigo.TablaSimbolos.Tipo tipo;
    
    //Comprovamos la cadena t y la convertimos al enumerado Tipo
    public TYPE(String t){
        super("TYPE");
        
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
                System.out.println("ERROR: el tipo "+t+" no exsiste.");
                break;
        }
    }
}
