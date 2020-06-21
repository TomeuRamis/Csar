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
    int valor;
    
    public LITERAL(TablaSimbolos.Tipo t, String l,int left,int right) {
        super("LITERAL",left,right);
        this.tipo = t;
        switch(t.ordinal()){
            case 0://tBool
                if(l.equals("true")){
                    valor = -1;
                } else {
                    valor = 0;
                }
                break;
            case 1://tString
                //Jaja Lol
                break;
            case 2://tInt
                valor = Integer.parseInt(l);
                break;     
       }
       g.addEdge(this, new SimboloBase(l));
    }
    
}
