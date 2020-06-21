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
public class DECL extends SimboloBase {
    DCL declaracion;
    boolean con;
    public DECL(DCL dcl, boolean con, codigo.TablaSimbolos ts){
        super("DECL",dcl.fila,dcl.columna);
        this.con = con;
        declaracion = dcl;
        if(con){
            codigo.TablaSimbolos.FilaTD f = ts.consulta(dcl.id, codigo.TablaSimbolos.Mvp.dvar);
            f.mvp = codigo.TablaSimbolos.Mvp.dconst;
            
            g.addEdge(this, new SimboloBase("const"));
        }
        
        g.addEdge(this, dcl);
    }
    
    public void gest(){
        if(con){
            //generar CONSTANTE
        }
        //declaracion.gest();
    }
}
