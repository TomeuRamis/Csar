/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.TablaSimbolos;
import codigo.idInstrucciones;

/**
 *
 * @author Juan
 */
public class DCL extends SimboloBase {

    TYPE tipo;
    ASIGNACION asignacion;
    String id;

    //Comprueba si existe id y compara los tipos de type y asignacion
    public DCL(TYPE tipo, String id, ASIGNACION asignacion, codigo.TablaSimbolos ts) {
        super("DCL", tipo.fila, tipo.columna);

        codigo.TablaSimbolos.FilaTD fTd = ts.consulta(id, codigo.TablaSimbolos.Mvp.dvar);

        if (tipo.tipo != asignacion.tipo && asignacion.tipo != codigo.TablaSimbolos.Tipo.tNull) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: " + id + " los tipos no coinciden. Linea: " + (tipo.fila + 1));
        } else if (!ts.add(id, tipo.tipo, codigo.TablaSimbolos.Mvp.dvar, C3D, false)) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: " + id + " ya esta definido  Linea: " + (tipo.fila + 1));
        } else {
            this.id = id;
            if (asignacion.tipo != codigo.TablaSimbolos.Tipo.tNull) {
                ts.incializaVar(id);
            }
        }

        g.addEdge(this, tipo);
        g.addEdge(this, new SimboloBase(id));
        g.addEdge(this, asignacion);

        if (asignacion.tipo != codigo.TablaSimbolos.Tipo.tNull) {
            fTd = ts.consulta(id, codigo.TablaSimbolos.Mvp.dvar);
            if (fTd != null) {
                C3D.genera(idInstrucciones.COPY.ordinal(), asignacion.r, -1, fTd.nv);
            } else {
                //ERROR
                codigo.FrmPrincipal.notificarError("Error semántico: generación del codigo intermedio incorrecta.");
            }
        }
    }

}
