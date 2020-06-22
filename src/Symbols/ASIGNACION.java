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
    int r;
    codigo.TablaSimbolos.Tipo tipo;
    
    public ASIGNACION(EXPRP exprp){
        super("ASIGNACION",exprp.fila,exprp.columna);
        
        tipo = exprp.tipo;
        
        g.addEdge(this, new SimboloBase("="));
        g.addEdge(this, exprp);
        
        r = exprp.r;
    }
    
    public ASIGNACION(){
        super("λ");
        
        tipo = codigo.TablaSimbolos.Tipo.tNull;
    }
}
