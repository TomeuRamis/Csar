/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author tomeu
 */
public class M extends SimboloBase {
    
    int e;
    
    public M(int i){
        super("M");
        switch(i){
            case 1: //Marcador de whl1
                e = C3D.nuevaEtiqueta();
                C3D.genera(idInstrucciones.SKIP.ordinal(),-1,-1,e);
                break;
            default:
                break;
        }
    }
    
    
}
