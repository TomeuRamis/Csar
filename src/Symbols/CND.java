/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author Juan
 */
public class CND extends SimboloBase {

    INSTS insts;

    public CND(CND1 cnd1, CND2 cnd2) {
        super("CND", cnd1.fila, cnd1.columna);

        this.insts = cnd2.insts;

        g.addEdge(this, cnd1);
        g.addEdge(this, cnd2);

        C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, cnd1.e);
    }

}
