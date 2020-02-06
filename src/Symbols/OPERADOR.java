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
public class OPERADOR extends SimboloBase{
    String operador;
    tOperador tOp;
    
    public OPERADOR(String v, int i) {
        super("OPERADOR");
        operador = v;
        switch(i){
            case 1:
                tOp = tOperador.tAritmetico;
                break;
            case 2:
                tOp = tOperador.tRelacional;
                break;
            case 3:
                tOp = tOperador.tLogico;
                break;
        }
    }
    
    public enum tOperador{tAritmetico, tRelacional,tLogico}
}
