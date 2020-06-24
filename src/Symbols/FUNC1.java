/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.TablaSimbolos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tomeu
 */
public class FUNC1 extends SimboloBase {

    codigo.TablaSimbolos.Tipo tipo;
    String id;
    int e, nv;

    public FUNC1(DEFINICION def, String id, PARAMS params, codigo.TablaSimbolos ts) {
        super("FUNC1", def.fila, def.columna);

        tipo = def.tipo;
        this.id = id;

        if (!ts.add(id, def.tipo, codigo.TablaSimbolos.Mvp.dproc, C3D)) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: " + id + " ya ha sido definido en este ámbito. Linea: " + (this.fila + 1));
            //System.out.println("Error semántico: " + id + " ya ha sido definido en este ámbito. Linea: "+(this.fila+1));
        } else if (params.idParams.size() != params.tipos.size()) {
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: el número de ids de parametros y el númeor de tipos no coinciden para la función " + id + ". Linea: " + (this.fila + 1));
            //System.out.println("Error semántico: el numero de ids de parametros y el numeor de tipos no coinciden para la función " + id+". Linea: "+(this.fila+1));
        } else {

            try {
                ts.entraBloque();
            } catch (Exception ex) {
                codigo.FrmPrincipal.notificarError("Profundidad de ámbito máxima excedida, overflow de la tabla de símbolos en linea " + this.fila);
            }
            
            e = def.e;
            nv = (ts.consulta(id, TablaSimbolos.Mvp.dproc)).nv;
            C3D.setEtiquetaP(nv, e);
            
            for (int i = 0; i < params.idParams.size(); i++) {
                ts.ponerParam(id, params.idParams.get(i), params.tipos.get(i), C3D);
                C3D.incrementarNParam(nv);
            }

            g.addEdge(this, def);
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, new SimboloBase("("));
            g.addEdge(this, params);
            g.addEdge(this, new SimboloBase(")"));
            g.addEdge(this, new SimboloBase("{"));

            
        }

    }
}
