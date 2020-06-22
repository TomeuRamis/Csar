/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author tomeu
 */
public class CND2 extends SimboloBase{
    
    INSTS insts;
    CND1 cnd1;
    int efi; 
    
    public CND2(CND1 cnd1, INSTS insts, codigo.TablaSimbolos ts){
        super("CND2",insts.fila,insts.columna);
        
        this.cnd1 = cnd1;
        this.insts = insts;
        
        g.addEdge(this, cnd1);
        g.addEdge(this, insts);
        g.addEdge(this, new SimboloBase("}"));
        
        this.efi = C3D.nuevaEtiqueta();
        C3D.genera(idInstrucciones.GOTO.ordinal(), -1, -1, efi);
        C3D.genera(idInstrucciones.SKIP.ordinal(), -1 , -1, cnd1.e);
        
    }
}
