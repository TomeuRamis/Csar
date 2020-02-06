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
public class ASIGNACION {
    EXPRP expresion;
    
    public String asignacion;
    public ASIGNACION(EXPRP exprp){
        this.asignacion = exprp.expresion;
    }
}
