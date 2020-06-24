/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;
import static codigo.idInstrucciones.*;
/**
 *
 * @author Juan
 */
public class EXPR extends SimboloBase{

    CALL llamada;
    LITERAL literal;
    int r;
    codigo.TablaSimbolos.Tipo tipo;
    
    public EXPR(LITERAL l) {
        super("EXPR",l.fila,l.columna);
        literal = l;
        tipo = l.tipo;
        
        
        
        g.addEdge(this, literal);
        
        this.r = C3D.nuevaVar(tipo);
        C3D.genera(COPY.ordinal(), l.valor,true, -1, r);
    }
    
    public EXPR(CALL c){
        super("EXPR",c.fila,c.columna);
        llamada = c;
        tipo = c.tipo;
        
        g.addEdge(this, c);
        
        this.r = C3D.nuevaVar(tipo);
        C3D.genera(COPY.ordinal(), c.r, -1, r);
        
    }
    
    public EXPR(String id, codigo.TablaSimbolos ts,int left, int right){
        super("EXPR",left,right);
        
        codigo.TablaSimbolos.FilaTD d = ts.consulta(id, codigo.TablaSimbolos.Mvp.dvar);
        if (d == null){
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semantico: Variable "+id+" no declarada. Linea: "+(left+1));
        }
        tipo = d.tipo;

        g.addEdge(this, new SimboloBase(id));
        
        //ganemos
        if(d.mvp.ordinal() != 0){ //MVP.dproc = 0 (debería ser siempre true, pero porsiácà)
            r = d.nv;
        }
    }
    
    public EXPR(EXPRP exprp){
        super("EXPR");
        tipo = exprp.tipo;
        
        g.addEdge(this, new SimboloBase("("));
        g.addEdge(this, exprp);
        g.addEdge(this, new SimboloBase(")"));
        
        r = exprp.r;
    }
    
    public void gest(){
        
    }
}
