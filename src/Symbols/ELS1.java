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
public class ELS1 extends SimboloBase{
    
    public ELS1(codigo.TablaSimbolos ts, int left) throws Exception{
        super("ELS1");
        
        ts.salBloque();
        try {
            ts.entraBloque();
        } catch (Exception ex) {
            codigo.FrmPrincipal.notificarError("Error: Profundidad de ámbito máxima excedida, overflow de la tabla de símbolos en linea "+left);
            throw new Exception();
        }
        
        g.addEdge(this, new SimboloBase("else"));
        g.addEdge(this, new SimboloBase("{"));
    }
}
