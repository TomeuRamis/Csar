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
public class CND1 extends SimboloBase{
    
    public CND1(EXPRP exprp, codigo.TablaSimbolos ts) {
        super("CND1",exprp.fila,exprp.columna);
        
        if(exprp.tipo != codigo.TablaSimbolos.Tipo.tBool){
            //ERROR
            System.out.println("Error semántico: La condicion no es booleana. Linea: "+(exprp.fila+1));
        }
        
        ts.entraBloque();
        
        g.addEdge(this, new SimboloBase("if"));
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
        g.addEdge(this, new SimboloBase("{"));
}
}
