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
public class WHL1 extends SimboloBase {

    int e;
    int efi;

    public WHL1(EXPRP exprp, M m, codigo.TablaSimbolos ts) throws Exception {
        super("WHL1", exprp.fila, exprp.columna);

        if (exprp.tipo != codigo.TablaSimbolos.Tipo.tBool) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: La condicion no es booleana. Linea: " + (this.fila + 1));
        }

        try {
            ts.entraBloque();
        } catch (Exception ex) {
            codigo.FrmPrincipal.notificarError("Error: Profundidad de ámbito máxima excedida, overflow de la tabla de símbolos en linea " + this.fila);
            throw new Exception();
        }

        g.addEdge(this, new SimboloBase("while"));
        g.addEdge(this, m);
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
        g.addEdge(this, new SimboloBase("{"));

        this.efi = C3D.nuevaEtiqueta();
        C3D.genera(idInstrucciones.IFEQ.ordinal(), 0, true, exprp.r, false, efi, true);
        this.e = m.e;

    }
}
