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
    public enum Tipo{
        tBool, tString, tInt, tNull
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
    
    public void add(String nombre,Tipo t, Mvp mvp){
        FilaTD filatd = consulta(nombre);
        if(filatd != null){
            if(filatd.np != n){
                ta[n]++;
                te.get(ta[n]).nombre = filatd.nombre;
                te.get(ta[n]).tipo = filatd.tipo;
                te.get(ta[n]).np = filatd.np;
                te.get(ta[n]).mvp = filatd.mvp;
            }
        }
        FilaTD nuevaFila = new FilaTD(nombre, t, n,mvp);
        td.add(nuevaFila);
    }
    
    public void ponerParam(String idproc, String idparam, Tipo tipo){
        FilaTD fproc = consulta(idproc);
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
        te.get(nou).tipo = tipo;
        te.get(nou).first = -1;
        te.get(nou).mvp = null;
        if(pp == -1){
            fproc.first = nou;
            
        }else{
            te.get(pp).first = nou;
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
        public String nombre;
        public Tipo tipo;
        //Object valor;
        public int np;
        public int first;
        public Mvp mvp;
        
        public FilaTD(String n, Tipo t, int amb, Mvp mvp){
            nombre = n;
            tipo = t;
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


