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
public class P {
    DECL declaraciones;
    INSTS instrucciones;
    FUNCS funciones;
    public P(Object v){
        //super(sym, value);
        System.out.println(v);
        System.out.println(((Symbol)v).value);
        System.out.println(((Symbol)v).sym);
        //System.out.println(value);
    }
}
