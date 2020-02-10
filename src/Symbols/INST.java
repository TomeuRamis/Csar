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
public class INST extends SimboloBase {

    RET retorno = null;

    public INST(Object o, boolean pyc) {
        super("INST");
        
        g.addEdge(this, (SimboloBase) o); //Ojo que esto es un poco cutre
        if (pyc) {
            g.addEdge(this, new SimboloBase(";"));
        }
    }

    public INST(CND cnd){
        super("INST");
        
        this.retorno = cnd.insts.retorno;
        
        g.addEdge(this, cnd);
    }
    public INST(WHL whl){
        super("INST");
        
        this.retorno = whl.instrucciones.retorno;
        
        g.addEdge(this, whl);
    }
    public INST(RET ret) {
        super("INST");
        
        this.retorno = ret;

        g.addEdge(this, ret);
        g.addEdge(this, new SimboloBase(";"));
    }
}
