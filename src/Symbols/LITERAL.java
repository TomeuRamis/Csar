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
    
    public LITERAL(TablaSimbolos.Tipo t, String l) {
       super("LITERAL");
       this.tipo = t;
       
       SimboloBase literal = new SimboloBase(l);
       g.addEdge(this, literal);
    }
    
}
