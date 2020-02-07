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
public class EXPR extends SimboloBase{

    CALL llamada;
    LITERAL literal;
    codigo.TablaSimbolos.Tipo tipo;
    
    public EXPR(LITERAL l) {
        super("EXPR");
        literal = l;
        tipo = l.tipo;
        
        g.addEdge(this, literal);
    }
    
    public EXPR(CALL c){
        super("EXPR");
        llamada = c;
        tipo = c.tipo;
        
        g.addEdge(this, c);
    }
    
    public EXPR(String id, codigo.TablaSimbolos ts){
        super("EXPR");
        
        codigo.TablaSimbolos.FilaTD d = ts.consulta(id);
        if (d == null){
            //ERROR
            System.out.println("ERROR: error semantico. Variable "+id+" no declarada.");
        } else{
            tipo = d.tipo;
            
            g.addEdge(this, new SimboloBase(id));
        }
        
        
    }
    
}
