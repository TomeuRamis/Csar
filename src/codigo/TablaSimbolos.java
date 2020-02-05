/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java_cup.runtime.Symbol;

/**
 *
 * @author davidcan
 */
public class TablaSimbolos {
    
    private final int profMax = 16;
    
    ArrayList<FilaTD> td;
    ArrayList<FilaTE> te;
    int[] ta;
    int n;
    public enum Mvp{
        dproc, dconst, dvar
    }
    
    public TablaSimbolos(){
        td = new ArrayList<>();
        te = new ArrayList<>();
        ta = new int[profMax];
        n = 0;
    }
    
    
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
    
    public void add(Symbol s, Mvp mvp){
        FilaTD filatd = consulta((String)s.value);
        if(filatd != null){
            if(filatd.np != n){
                ta[n]++;
                te.get(ta[n]).nombre = filatd.nombre;
                te.get(ta[n]).tipo = filatd.tipo;
                te.get(ta[n]).np = filatd.np;
                te.get(ta[n]).mvp = filatd.mvp;
            }
        }
        FilaTD nuevaFila = new FilaTD(s,n,mvp);
        td.add(nuevaFila);
    }
    
    public void ponerParam(String idproc, String idparam, int d){
        FilaTD fproc = consulta(idproc);
<<<<<<< HEAD
        if(fproc.tipo != dproc ){
            int i = consulta(idproc).first;
            int pp = -1;
            while( i!=-1 && t)
=======
        if(fproc.mvp != Mvp.dproc){
            System.out.println("ERROR");//Error
        }
       
        int i = fproc.first;
        int pp = -1;
        while(i != -1 && !te.get(i).nombre.equals(idparam)){
            pp = i;
            i = te.get(i).first;
        }
        if(i != -1){
            System.out.println("ERROR");
        }
        int nou = ta[n];
        ta[n] = ta[n+1];
        te.get(nou).nombre = idparam;
        te.get(nou).np = -1;
        te.get(nou).tipo = d;
        te.get(nou).first = -1;
        te.get(nou).mvp = null;
        if(pp == -1){
            fproc.first = nou;
            
        }else{
            te.get(pp).first = nou;
>>>>>>> 8d94035b6a794400e0f3e830c1bdc98cb2ee2d7f
        }
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
                filatd.mvp = filate.mvp;
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
        Mvp mvp;
        
        public FilaTD(Symbol s, int amb, Mvp mvp){
            nombre = (String)s.value;
            tipo = s.sym;
            //valor = s.value;
            np = amb;
            this.mvp = mvp;
        }
        public FilaTD(FilaTD f){
            nombre = f.nombre;
            tipo = f.tipo;
            //valor = f.valor;
            np = f.np;
            mvp = f.mvp;
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
   
}


