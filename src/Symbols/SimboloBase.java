/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;


import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
/**
 *
 * @author Juan
 */
public class SimboloBase extends ComplexSymbol{
    private static int idAutoIncrement = 0;
    
    public SimboloBase(String variable, String valor) {
        super(variable, idAutoIncrement, valor);
        idAutoIncrement++;
    }

}
