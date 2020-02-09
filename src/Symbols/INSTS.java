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
public class INSTS extends SimboloBase{
    
    INST instruccion;
    INSTS instrucciones;
    RET retorno = null;
    
    public INSTS(INST inst, INSTS insts){
        super("INSTS");

        if(inst.retorno != null && insts.retorno != null){
            if(inst.retorno.tipo != insts.retorno.tipo){
                //ERROR
                System.out.println("ERROR: los tipos de dos returns no coinciden. ");
            } else{
                this.retorno = inst.retorno ;
            }
        }else if(inst.retorno != null){
            this.retorno = inst.retorno;
        }else if(insts.retorno != null){
            this.retorno = insts.retorno;
        }
        
        g.addEdge(this, inst);
        g.addEdge(this, insts);
    }
    
    public INSTS(){
        super("INSTS");
        g.addEdge(this, new SimboloBase("λ"));
    }
}
