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
    
    public OPERADOR(String v, int i,int left, int right) {
        super("OPERADOR",left,right);
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
        
        g.addEdge(this, new SimboloBase(v));
    }
    
    public enum tOperador{tAritmetico, tRelacional,tLogico}
}
