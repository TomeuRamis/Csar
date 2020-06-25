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
public class P1 extends SimboloBase{
    DECLS decls;
    FUNCS funcs;
    int e;
    public P1 (DECLS decls, FUNCS funcs, codigo.TablaSimbolos ts, int mainleft) throws Exception{
        super("P1");
        this.decls = decls;
        this.funcs = funcs;
        try {
            ts.entraBloque();
        } catch (Exception ex) {
            codigo.FrmPrincipal.notificarError("Error: Profundidad de ámbito máxima excedida, overflow de la tabla de símbolos en linea "+mainleft);
            throw new Exception();
        }
        
        g.addEdge(this, decls);
        g.addEdge(this, funcs);
        g.addEdge(this, new SimboloBase("main"));
        g.addEdge(this, new SimboloBase("{"));
        
        e = decls.e;
        C3D.genera(codigo.idInstrucciones.SKIP.ordinal(), -1, -1, e);
        C3D.nuevoProcedimiento();
    }
}
