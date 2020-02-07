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
public class ASIGNACION extends SimboloBase{
    EXPRP expresionp;
    
    codigo.TablaSimbolos.Tipo tipo;
    public ASIGNACION(EXPRP exprp){
        super("ASIGNACION");
        
        tipo = exprp.tipo;
        
        g.addEdge(this, exprp);
    }
    
    public ASIGNACION(){
        super("λ");
    }
}
