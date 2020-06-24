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
public class CND1 extends SimboloBase {

    int e; //etiqueta

    public CND1(EXPRP exprp, codigo.TablaSimbolos ts) throws Exception {
        super("CND1", exprp.fila, exprp.columna);

        if (exprp.tipo != codigo.TablaSimbolos.Tipo.tBool) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: La condicion no es booleana. Linea: " + (exprp.fila + 1));
        }

        try {
            ts.entraBloque();
        } catch (Exception ex) {
            codigo.FrmPrincipal.notificarError("Error: Profundidad de ámbito máxima excedida, overflow de la tabla de símbolos en linea " + this.fila);
            throw new Exception();
        }

        g.addEdge(this, new SimboloBase("if"));
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
        g.addEdge(this, new SimboloBase("{"));

        this.e = C3D.nuevaEtiqueta();
        C3D.genera(idInstrucciones.IFEQ.ordinal(), 0, true, exprp.r, e);
    }
}
