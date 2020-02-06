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
public class OPERADOR {
    
    public OPERADOR(Symbol s) {
        
        System.out.println(s.value);
        System.out.println(s.sym);
    }
    
    public enum Operadores{
        OPSuma
    }
}
