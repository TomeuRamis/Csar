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
public class DECL extends SimboloBase {
    public DECL(String type, String id, String asig){
        super("DECL", id);
        System.out.println("Objeto de tipo "+type+" con identificador "+id+" con valor asignado "+asig);
        imprimirArbol();
    }
}
