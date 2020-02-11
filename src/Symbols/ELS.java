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
public class ELS extends SimboloBase{
    INSTS instrucciones;
    
    public ELS(ELS3 els3, CND cnd, codigo.TablaSimbolos ts) {
        super("ELS",cnd.fila,cnd.columna);
        
        this.instrucciones = cnd.insts;
        
        g.addEdge(this, els3);
        g.addEdge(this, cnd);
    }
    
    public ELS(ELS1 els1, ELS2 els2){
        super("ELS",els2.fila,els2.columna);
        
        this.instrucciones = els2.insts;
        
        g.addEdge(this, els1);
        g.addEdge(this, els2);
        
    }
    
    public ELS(codigo.TablaSimbolos ts){
        super("λ");
        ts.salBloque();
    }
    
}
