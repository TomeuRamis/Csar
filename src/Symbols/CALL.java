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

public class CALL extends SimboloBase {
    EXPRS expresiones;
    codigo.TablaSimbolos.Tipo tipo;
    
    public CALL(String id, codigo.TablaSimbolos ts) {
        super("CALL");
        
        codigo.TablaSimbolos.FilaTD d = ts.consulta(id);
        if(d == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("ERROR: el subprograma "+id+" no ha sido definicdo.");
        } else if(d.mvp != codigo.TablaSimbolos.Mvp.dproc ){
            //ERROR
            codigo.FrmPrincipal.notificarError("ERROR: "+id+" no es un subprograma.");
        } else if(d.first !=-1){
            //ERROR
            codigo.FrmPrincipal.notificarError("ERROR: "+id+" debe tener parámetros.");         
        } else{
            tipo = d.tipo;
            
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, new SimboloBase("("));
            g.addEdge(this, new SimboloBase(")"));
        }
    }
    
    public CALL(String id, EXPRS exprs, codigo.TablaSimbolos ts) {
        super("CALL");

        codigo.TablaSimbolos.FilaTD d = ts.consulta(id);
        if(d == null){
            //ERROR
            System.out.println("ERROR: el subprograma "+id+" no ha sido definicdo.");
        } else if(d.mvp != codigo.TablaSimbolos.Mvp.dproc ){
            //ERROR
            System.out.println("ERROR: "+id+" no es un subprograma.");
        } else if(d.first == -1){
            //ERROR
            System.out.println("ERROR: "+id+" no debe tener parámetros.");
        } else{
            codigo.TablaSimbolos.FilaTE fTe = ts.getFilaTE(d.first);
            for(int i =0; i < exprs.tipos.size(); i++){
                
                if(fTe != null){
                    if(fTe.tipo != exprs.tipos.get(i)){
                        //ERROR
                        System.out.println("ERROR: tipo incorrecto del parámetro "+(i+1)+" en la llamda al subprograma "+id);
                        break;
                    }
                } else {
                    //ERROR
                    System.out.println("ERROR: hay demasiados parámetros en "+id);
                    break;
                }
                
                fTe = ts.getFilaTE(fTe.first);
                
            }
            if(fTe != null){
                //ERROR
                System.out.println("ERROR: faltan parámetros en la llamda a "+id);
            }
            tipo = d.tipo;
            
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, new SimboloBase("("));
            g.addEdge(this, exprs);
            g.addEdge(this, new SimboloBase(")"));
        }
    }
    
}
