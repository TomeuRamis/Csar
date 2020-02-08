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

    public FUNC(FUNC1 func1, FUNC2 func2 ) {
        super("FUNC",func1.fila,func1.columna);

        g.addEdge(this, func1);
        g.addEdge(this, func2);          

    }

}
