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

    public enum Mvp {
        dproc, dconst, dvar
    }

    public enum Tipo {
        tBool, tString, tInt, tNull
    }

    public TablaSimbolos() {
        td = new ArrayList<>();
        te = new ArrayList<>();
        ta = new int[profMax];
        n = 0;
    }

    public void reset() {
        n = 0;
        td.clear();
        te.clear();
        ta[n] = 0;
    }

    /*
    Consulta el id en la tabla de simbolos. Devuelve solo un objeto FilaTD si coincide tanto en ID como en MVP
    */
    public FilaTD consulta(String id, Mvp mvp) {
        int i = 0;

        if (td.isEmpty()) {
            return null;
        }
        while(i < td.size()){
            if(td.get(i).nombre.equals(id) && td.get(i).np != -1){
                if(mvp == Mvp.dproc && td.get(i).mvp != Mvp.dproc){
                    i++;
                } else if(mvp != Mvp.dproc && td.get(i).mvp == Mvp.dproc){
                    i++;
                } else {
                    break;
                } 
            } else{
                i++;
            }
        }
        /*while (i < td.size() && (!id.equals(td.get(i).nombre) || td.get(i).np == -1)) {
            
            i++;
        }*/
        
        /*if(i > td.size()-1){
            return null;
        }else{
            return td.get(i);
        }*/
        return (i > td.size() - 1) ? null : td.get(i);
    }

    public boolean add(String nombre, Tipo t, Mvp mvp) {
        FilaTD filatd = consulta(nombre, mvp);

        if (filatd != null) {
            int posAnterior;
            if (filatd.np != n) {
                ta[n]++;
                posAnterior = td.indexOf(filatd);
                FilaTE nuevaFilaTE = new FilaTE(filatd, posAnterior);
                te.add(nuevaFilaTE);
                td.remove(posAnterior);
                System.out.println(posAnterior);
            } else {
                return false;
            }
            FilaTD nuevaFila = new FilaTD(nombre, t, n, mvp);
            td.add(posAnterior, nuevaFila);
        } else {
            
            /*
            Añade la nuevaFila a la TD en la primera posición con ámbito -1 o al final
            del array list.
            */
            
            FilaTD nuevaFila = new FilaTD(nombre, t, n, mvp);
            int i = 0;
            while(i < td.size() && td.get(i).np != -1){              
                i++;
            }
            if(i> td.size()-1){
                td.add(nuevaFila);
            } else{
                //Sustituimos la posicion de la TD con la nueva fila
                td.get(i).nombre = nuevaFila.nombre;
                td.get(i).tipo = nuevaFila.tipo;
                td.get(i).np = nuevaFila.np;
                td.get(i).first = nuevaFila.first;
                td.get(i).mvp = nuevaFila.mvp;
            }
            
        }
        return true;

    }

    public boolean ponerParam(String idproc, String idparam, Tipo tipo) {
        FilaTD fproc = consulta(idproc, Mvp.dproc);
        if (fproc.mvp != Mvp.dproc) {
            //Error
            System.out.println("ERROR: solo se pueden añadir paràmetros a subprogramas");
            return false;
        }

        int i = fproc.first;
        int pp = -1;
        while (i != -1 && !te.get(i).nombre.equals(idparam)) {
            pp = i;
            i = te.get(i).first;
        }
        if (i != -1) {
            //ERROR
            System.out.println("ERROR en ponerParam de " + idproc);
            return false;
        }
        int nou = ta[n];
        ta[n]++;
        ta[n - 1]++;
        FilaTE fTE = new FilaTE();
        if (nou > te.size() - 1) {
            te.add(nou, fTE);
        }
        te.get(nou).nombre = idparam;
        te.get(nou).np = -1;
        te.get(nou).tipo = tipo;
        te.get(nou).first = -1;
        te.get(nou).mvp = null;
        te.get(nou).refTD = - 1;
        if (pp == -1) {
            fproc.first = nou;

        } else {
            te.get(pp).first = nou;
        }

        this.add(idparam, tipo, Mvp.dvar);
        return true;
    }

    public void entraBloque() {
        n++;
        ta[n] = ta[n - 1];
    }

    public void salBloque() {
        int lini, lfin;
        lini = ta[n];
        n--;
        lfin = ta[n];
        while (lini > lfin) {
            FilaTE filate = te.get(lini - 1);
            if (filate.np != -1) {
                String id = filate.nombre;
                FilaTD filatd = consulta(id, Mvp.dvar);
                filatd.tipo = filate.tipo;
                filatd.np = filate.np;
                filatd.first = filate.first;
                filatd.mvp = filate.mvp;
                te.remove(filate);

            }
            lini--;
        }

        FilaTD filatd;
        for (int i = 0; i < td.size(); i++) {
            filatd = td.get(i);
            if (filatd.np > n) {
                td.get(i).np = -1;
            }
        }
    }

    public FilaTE getFilaTE(int index) {
        return (index > te.size() - 1 || index == -1) ? null : te.get(index);
    }

    public class FilaTD {

        public String nombre;
        public Tipo tipo;
        //Object valor;
        public int np; //Ambito
        public int first;
        public Mvp mvp; //Indica si es una constante, una variable o un subprograma

        public FilaTD(String n, Tipo t, int amb, Mvp mvp) {
            nombre = n;
            tipo = t;
            //valor = s.value;
            np = amb;
            this.mvp = mvp;
            first = -1;
        }

        public FilaTD(FilaTD f) {
            nombre = f.nombre;
            tipo = f.tipo;
            //valor = f.valor;
            np = f.np;
            mvp = f.mvp;
            first = f.first;
        }

        public FilaTD() {
        }

        @Override

        public boolean equals(Object f){
            return this.nombre.equals(((FilaTD)f).nombre) && this.np == ((FilaTD)f).np;
        }
    }

    public class FilaTE extends FilaTD {

        int refTD;

        //Utiliza el campo first heredado de FilaTD como campo next
        public FilaTE(FilaTD f, int ref) {
            super(f);
            refTD = ref;
        }

        public FilaTE() {
            super();
        }

    }

    @Override
    public String toString() {
        String res = "";
        res += "n = " + n + "\n";
        //res += "=======================================================================================\n";
        res += "TD\t\t\t\t\t||\tTE\t\t\t\t\t\t||\tTA\n";
        res += "nombre \t tipo \t np \t first \t mvp \t||\t nombre \t tipo \t np \t first \t mvp \t refTD \t||\t\n";
        //res += "||---------------------------------||------------------------------------------------||\n";
        int i;
        for (i = 0; i < td.size() || i < te.size() || i < ta.length; i++) {
            if (i < td.size()) {
                FilaTD ftd = td.get(i);
                res += "" + ftd.nombre + "\t" + ftd.tipo + "\t" + ftd.np + "\t" + ftd.first + "\t" + ftd.mvp + "\t||";
            } else {
                res += "\t\t\t\t\t||";
            }
            if (i < te.size()) {
                FilaTE fte = te.get(i);
                res += "\t" + fte.nombre + "\t " + fte.tipo + "\t" + fte.np + "\t" + fte.first + "\t" + fte.mvp + "\t" + fte.refTD + "\t||";
            } else {
                res += "\t\t\t\t\t\t\t||";
            }
            if (i < ta.length) {
                res += "\t" + ta[i] + "\n";
            } else {
                res += "\t";
            }
        }
        //res += "=======================================================================================";
        return res;
    }
}
