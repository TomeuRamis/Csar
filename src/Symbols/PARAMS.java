/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class PARAMS extends SimboloBase{

    PARAM parametro;
    PARAMSP parametrosP;
    
    ArrayList<codigo.TablaSimbolos.Tipo> tipos;
    ArrayList<String> idParams;
    
    public PARAMS(PARAM param, PARAMSP paramsp) {
        super("PARAMS");
        
        tipos.add(param.tipo);
        tipos.addAll(paramsp.tipos);
        
        idParams.add(param.idParam);
        idParams.addAll(paramsp.idParams);
        
        g.addEdge(this, param);
        g.addEdge(this, paramsp);
    }
    
    public PARAMS(){
        super("λ");
        g.addEdge(this, new SimboloBase("λ"));
    }
    
}
