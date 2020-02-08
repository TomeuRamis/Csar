/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author tomeu
 */
public class FUNC1 extends SimboloBase {

    codigo.TablaSimbolos.Tipo tipo;
    String id;

    public FUNC1(DEFINICION def, String id, PARAMS params, codigo.TablaSimbolos ts) {
        super("FUNC1");

        tipo = def.tipo;
        this.id = id;

        if (!ts.add(id, def.tipo, codigo.TablaSimbolos.Mvp.dproc)) {
            //ERROR
            System.out.println("ERROR: " + id + " ya ha sido definido en este ámbito.");
        } else if (params.idParams.size() != params.tipos.size()) {
            //ERROR
            System.out.println("ERROR: el numero de ids de parametros y el numeor de tipos no coinciden para la función " + id);
        } else {

            ts.entraBloque();
            
            for (int i = 0; i < params.idParams.size(); i++) {
                ts.ponerParam(id, params.idParams.get(i), params.tipos.get(i));
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
