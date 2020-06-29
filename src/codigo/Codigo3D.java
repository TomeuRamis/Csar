package codigo;

import codigo.idInstrucciones.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Codigo3D {

    int ne = 0;
    public TablaVariables TV = new TablaVariables();
    public TablaProcedimientos TP = new TablaProcedimientos();
    ArrayList<Instruccion3D> codigo;

    public Codigo3D() {
        codigo = new ArrayList<>();
    }

    public void genera(int cod, int op1, int op2, int dest) {
        codigo.add(new Instruccion3D(cod, op1, op2, dest));
    }

    public void genera(int cod, int op1, boolean literal, int op2, boolean literal2, int dest) {
        codigo.add(new Instruccion3D(cod, op1, literal, op2, literal2, dest));
    }
    
    public void genera(int cod, int op1, boolean literal, int op2, boolean literal2, int dest, boolean esunw) {
        codigo.add(new Instruccion3D(cod, op1, literal, op2, literal2, dest, esunw));
    }

    public ArrayList<Instruccion3D> getCodigo() {
        return codigo;
    }

    public int nuevaEtiqueta() {
        return ne++;
    }

    public int nuevaVar(codigo.TablaSimbolos.Tipo tipo, int np, boolean isp) {
        return TV.nuevaVar(tipo, np, isp);
    }

    public int nuevoProcedimiento() {
        return TP.nuevoProcedimiento();
    }

    public void setEtiquetaP(int n, int e) {
        TP.setEtiquetaP(n, e);
    }

    public void incrementarNParam(int n) {
        TP.incrementarNParams(n);
    }

    public void llenaTP() {
        TP.llenaTP(TV);
    }

    public void reset() {
        ne = 0;
        TV = new TablaVariables();
        TP = new TablaProcedimientos();
        codigo = new ArrayList<>();
    }

    public void imprimir(String path) {

        String c3d = toString();
        Writer writer;
        try {
            writer = new FileWriter(path);
            writer.write(c3d);
            writer.close();
        } catch (IOException ex) {
        }
    }

    @Override
    public String toString() {
        String res = "Codigo \t Operando 1 \t Operando 2 \t Destino";
        for (int i = 0; i < codigo.size(); i++) {
            res += "\n" + codigo.get(i).toString();
        }

        res += "\n\n-----------------------------\nNV: " + TV.nv + "\n";
        res += TV.toString();
        res += "\n------------------------------\nNP: " + TP.np + "\n";
        res += TP.toString();
        return res;
    }
}

class Instruccion3D {

    int cod, op1, op2, dest;
    boolean literal1 = false;
    boolean literal2 = false;
    boolean esunwhile = false;

    public Instruccion3D(int cod, int op1, int op2, int dest) {
        this.cod = cod;
        this.op1 = op1;
        this.op2 = op2;
        this.dest = dest;
    }

    public Instruccion3D(int cod, int op1, boolean literal1, int op2, boolean literal2, int dest) {
        this.cod = cod;
        this.op1 = op1;
        this.op2 = op2;
        this.dest = dest;
        this.literal1 = literal1;
        this.literal2 = literal2;
    }
    
    public Instruccion3D(int cod, int op1, boolean literal1, int op2, boolean literal2, int dest, boolean esW) {
        this.cod = cod;
        this.op1 = op1;
        this.op2 = op2;
        this.dest = dest;
        this.literal1 = literal1;
        this.literal2 = literal2;
        this.esunwhile = esW;
    }

    @Override
    public String toString() {
        String op1 = "", op2 = "";
        if (!literal1) {
            op1 += "v";
        }
        if(!literal2){
            op2 += "v";
        }
        op1 += this.op1;
        op2 += this.op2;
        String res = "";
        switch (cod) {
            case 0://COPY
                res = "v" + dest + " = " + op1;
                break;
            case 1://ADD
                res = "v" + dest + " = " + op1 + " + " + op2;
                break;
            case 2://SUB
                res = "v" + dest + " = " + op1 + " - " + op2;
                break;
            case 3://PROD
                res = "v" + dest + " = " + op1 + " * " + op2;
                break;
            case 4://DIV
                res = "v" + dest + " = " + op1 + " / " + op2;
                break;
            case 5://MOD
                res = "v" + dest + " = " + op1 + " % " + op2;
                break;
            case 6://AND
                res = "v" + dest + " = " + op1 + " && " + op2;
                break;
            case 7://OR
                res = "v" + dest + " = " + op1 + " || " + op2;
                break;
            case 8://SKIP
                res = "et" + dest + " : skip";
                break;
            case 9://IFEQ
                res = "if " + op1 + "=" + op2 + " goto et" + dest;
                break;
            case 10://IFNE
                res = "if " + op1 + "!=" + op2 + " goto et" + dest;
                break;
            case 11://IFLT
                res = "if " + op1 + "<" + op2 + " goto et" + dest;
                break;
            case 12://IFLE
                res = "if " + op1 + "<=" + op2 + " goto et" + dest;
                break;
            case 13://IFGE
                res = "if " + op1 + ">=" + op2 + " goto et" + dest;
                break;
            case 14://IFGT
                res = "if " + op1 + ">" + op2 + " goto et" + dest;
                break;
            case 15://PMB
                res = "pmb p" + dest;
                break;
            case 16://CALL
                if(this.op1 != -1){
                    res = "call p"+dest + " "+op1;
                }else{
                    res = "call p" + dest;
                }
                break;
            case 17://RTN
                if (this.op1 != -1) {
                    res = "rtn p" + dest + " " + op1;
                } else {
                    res = "rtn p" + dest;
                }
                break;
            case 18://PARAM_S
                res = "param_s " + op1;
                break;
            case 19://GOTO
                res = "goto et" + dest;
                break;
            case 20: //IN
                res += "in v" + dest;
                break;
            case 21: //OUT
                res += "out v" + dest;
                break;
            case 22://NEG
                res += "v"+dest + " = -" + op1;
                break;
            case 23: //MULTP2
                res += "v"+dest + " = "+op1+" <- "+op2;
                break;
            case 24: //DIVP2
                res += "v" +dest + " = "+op1+" -> "+op2;
                break;
        }
        return res;
        //return idInstrucciones.values()[cod] + "\t" + op1 + "\t" + op2 + "\t" + dest;
    }

}
