/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.TablaSimbolos;

/*
 * @author Juan
 */
public class LITERAL extends SimboloBase {
    TablaSimbolos.Tipo tipo;
    
    public LITERAL(TablaSimbolos.Tipo t) {
       super("LITERAL");
       this.tipo = t;
       
       SimboloBase tip = new SimboloBase(tipo.toString());
       g.addEdge(this, tip);
    }
    
}
