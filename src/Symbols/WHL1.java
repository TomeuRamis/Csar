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
public class WHL1 extends SimboloBase {

    public WHL1(EXPRP exprp, codigo.TablaSimbolos ts) {
        super("WHL1");

        if (exprp.tipo != codigo.TablaSimbolos.Tipo.tBool) {
            //ERROR
            System.out.println("ERROR: La condicion no es booleana");
        }
        
        ts.entraBloque();

        g.addEdge(this, new SimboloBase("while"));
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
        g.addEdge(this, new SimboloBase("{"));
    }
}