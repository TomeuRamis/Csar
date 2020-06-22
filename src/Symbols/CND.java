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

    public CND(CND2 cnd2, ELS els) {
        super("CND", cnd2.fila, cnd2.columna);

        this.insts = cnd2.insts;

        g.addEdge(this, cnd2);
        g.addEdge(this, els);

        C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, cnd2.efi);
    }

}
