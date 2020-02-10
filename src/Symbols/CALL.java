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
    
    public CALL(String id, codigo.TablaSimbolos ts,int left, int right) {
        super("CALL",left,right);
        
        codigo.TablaSimbolos.FilaTD d = ts.consulta(id, codigo.TablaSimbolos.Mvp.dproc);
        if(d == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: el subprograma "+id+" no ha sido definicdo. Linea "+(left+1));
        } else if(d.mvp != codigo.TablaSimbolos.Mvp.dproc ){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: "+id+" no es un subprograma. Linea "+(left+1));
        } else if(d.first !=-1){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: "+id+" debe tener parámetros. Linea "+(left+1));         
        } else{
            tipo = d.tipo;
            
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, new SimboloBase("("));
            g.addEdge(this, new SimboloBase(")"));
        }
    }
    
    public CALL(String id, EXPRS exprs, codigo.TablaSimbolos ts, int left, int right) {
        super("CALL", left, right);

        codigo.TablaSimbolos.FilaTD d = ts.consulta(id, codigo.TablaSimbolos.Mvp.dproc);
        if(d == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: el subprograma "+id+" no ha sido definicdo. Linea: "+left);
        } else if(d.mvp != codigo.TablaSimbolos.Mvp.dproc ){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: "+id+" no es un subprograma. Linea: "+left);
        } else if(d.first == -1){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: "+id+" no debe tener parámetros. Linea: "+left);
        } else{
            codigo.TablaSimbolos.FilaTP fTp = ts.getFilaTP(d.first);
            for(int i =0; i < exprs.tipos.size(); i++){
                
                if(fTp != null){
                    if(fTp.tipo != exprs.tipos.get(i)){
                        //ERROR
                        codigo.FrmPrincipal.notificarError("Error semántico: tipo incorrecto del parámetro "+(i+1)+" en la llamda al subprograma "+id+" Linea: "+left);
                        break;
                    }
                } else {
                    //ERROR
                    codigo.FrmPrincipal.notificarError("Error semántico: hay demasiados parámetros en "+id+" Linea: "+left);
                    break;
                }
                
                fTp = ts.getFilaTP(fTp.first);
                
            }
            if(fTp != null){
                //ERROR
                codigo.FrmPrincipal.notificarError("Error semántico: faltan parámetros en la llamda a "+id+" Linea: "+left);
            }
            tipo = d.tipo;
            
            g.addEdge(this, new SimboloBase(id));
            g.addEdge(this, new SimboloBase("("));
            g.addEdge(this, exprs);
            g.addEdge(this, new SimboloBase(")"));
        }
    }
    
}
