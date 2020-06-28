/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;
import static codigo.idInstrucciones.*;
/**
 *
 * @author Juan
 */
public class RET extends SimboloBase{
    
    codigo.TablaSimbolos.Tipo tipo;
    
    public RET(EXPRP exprp) {
        super("RET",exprp.fila,exprp.columna);
        tipo = exprp.tipo;
        
        g.addEdge(this, new SimboloBase("return"));
        g.addEdge(this, exprp);
        
        C3D.genera(codigo.idInstrucciones.RTN.ordinal(), exprp.r, -1, C3D.TP.np);
    }
    
    
}
