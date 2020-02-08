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
public class ASIG extends SimboloBase{
    EXPRP expresionp;
    
    //Consulta si existe id y compara los tipos de id y exprp
    public ASIG(String id, EXPRP exprp, codigo.TablaSimbolos ts){
        super("ASIG",exprp.fila,exprp.columna);
        
        codigo.TablaSimbolos.FilaTD fTd = ts.consulta(id);
        if(fTd == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: " + id + "no existe. Linea: "+(exprp.fila+1));
        } else if(fTd.tipo != exprp.tipo){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: " + id +" los tipos son inconpatibles. Linea: "+(exprp.fila+1));
        }
        
        g.addEdge(this, new SimboloBase(id));
        g.addEdge(this, new SimboloBase("="));
        g.addEdge(this, exprp);
        
        
    }
}
