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
public class FUNC extends SimboloBase {

    DEFINICION definicion;
    PARAMS parametros;
    INSTS instrucciones;

    codigo.TablaSimbolos.Tipo tipo;

    public FUNC(DEFINICION def, String id, PARAMS params, INSTS insts, codigo.TablaSimbolos ts) {
        super("FUNC");
        
        tipo = def.tipo;

        if (!ts.add(id, def.tipo, codigo.TablaSimbolos.Mvp.dproc)) {
            //ERROR
            System.out.println("ERROR: " + id + " ya ha sido definido en este ámbito.");
        } else if (params.idParams.size() != params.tipos.size()) {
            //ERROR
            System.out.println("ERROR: el numero de ids de parametros y el numeor de tipos no coinciden para la función " + id);
        } else {
            for (int i = 0; i < params.idParams.size(); i++) {
                ts.ponerParam(id, params.idParams.get(i), params.tipos.get(i));
            }
            
            g.addEdge(this, def);
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, params);
            g.addEdge(this, insts);
        }

    }

}
