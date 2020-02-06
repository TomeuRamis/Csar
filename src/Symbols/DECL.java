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
    
    public DECL(DCL dcl, boolean con, codigo.TablaSimbolos ts){
        super("DECL");
        
        if(con){
            codigo.TablaSimbolos.FilaTD f = ts.consulta(dcl.id);
            f.mvp = codigo.TablaSimbolos.Mvp.dconst;
        }
    }
}
