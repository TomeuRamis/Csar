/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java_cup.runtime.Symbol;

/**
 *
 * @author davidcan
 */
public class TablaSimbolos {
    
    private final int profMax = 16;
    
    ArrayList<FilaTD> td;
    ArrayList<FilaTE> te;
    int[] ta = new int[profMax];
    int n;
    
    
    public void reset(){
        n = 0;
        td.clear();
        te.clear();
        ta[n] = 0;
    }
    
    public FilaTD consulta(String id){
        int i = 0;
        while(!id.equals(td.get(i).nombre)){
            i++;
        }
        /*if(i > td.size()-1){
            return null;
        }else{
            return td.get(i);
        }*/
        return (i > td.size()-1) ? null : td.get(i);
    }
    
    public void add(Symbol s){
        FilaTD filatd = consulta((String)s.value);
        if(filatd != null){
            if(filatd.np != n){
                ta[n]++;
                te.get(ta[n]).nombre = filatd.nombre;
                te.get(ta[n]).tipo = filatd.tipo;
                te.get(ta[n]).np = filatd.np;
            }
        }
        FilaTD nuevaFila = new FilaTD(s,n);
        td.add(nuevaFila);
    }
    
    public void ponerParam(String idproc, String idparam, int d){
        FilaTD fproc = consulta(idproc);
        if(fproc.tipo != )
    }
    
    public void entraBloque(){
        n++;
        ta[n] = ta[n-1];
    }
    
    public void salBloque(){
        int lini,lfin;
        lini = ta[n];
        n--;
        lfin = ta[n];
        while(lini > lfin){
            FilaTE filate = te.get(lini);
            if(filate.np != -1){
                String id = filate.nombre;
                FilaTD filatd = consulta(id);
                filatd.tipo = filate.tipo;
                filatd.np = filate.np;
                filatd.first = filate.first;
            }
            lini--;
        }
    }
    
    public class FilaTD{
        String nombre;
        int tipo;
        //Object valor;
        int np;
        int first;
        
        public FilaTD(Symbol s, int amb){
            nombre = (String)s.value;
            tipo = s.sym;
            //valor = s.value;
            np = amb;
        }
        public FilaTD(FilaTD f){
            nombre = f.nombre;
            tipo = f.tipo;
            //valor = f.valor;
            np = f.np;
        }
        
    }
    public class FilaTE extends FilaTD{
        int refTD;
        //Utiliza el campo first heredado de FilaTD como campo next
        public FilaTE(FilaTD f, int ref){
            super(f);
            refTD = ref;
        }
    }
    
    public class Llamada{
        String nombre;
        ArrayList<Symbol> parametros;
        
        public Llamada(String n){
            nombre = n;
            parametros = new ArrayList<>();
        }  
        
        public void addParam(Symbol s){
            parametros.add(s);
        }
        
    }
}


