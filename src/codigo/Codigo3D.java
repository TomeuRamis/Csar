
package codigo;

import codigo.idInstrucciones.*;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Codigo3D {
    int ne = 0;
    TablaVariables TV = new TablaVariables();
    TablaProcedimientos TP = new TablaProcedimientos();
    ArrayList<Instruccion3D> codigo;
    
    public Codigo3D() {
        codigo = new ArrayList<>();
    }
    
    public void genera(int cod, int op1, int op2, int dest){
        codigo.add(new Instruccion3D(cod, op1, op2, dest));
    }
    
    public int nuevaEtiqueta(){
        return ne++;
    }
    
    public int nuevaVar(){
        return TV.nuevaVar();
    }
    
    public int nuevoProcedimiento(){
        return TP.nuevoProcedimiento();
    }
    
    @Override
    public String toString(){
        String res = "Codigo \t Operando 1 \t Operando 2 \t Destino";
        for(int i = 0; i < codigo.size(); i++){
            res += "\n" + codigo.get(i).toString();
        }        
        return res;
    }
}

class Instruccion3D {
    int cod, op1, op2, dest;

    public Instruccion3D(int cod, int op1, int op2, int dest) {
        this.cod = cod;
        this.op1 = op1;
        this.op2 = op2;
        this.dest = dest;
    }
    
    @Override
    public String toString(){
        String res = "";
        switch(cod){
            case 0://COPY
                res = dest + " = " + op1;
                break;
            case 1://ADD
                res = dest + " = " + op1 + " + " + op2;
                break;
            case 2://SUB
                res = dest + " = " + op1 + " - " + op2;
                break;
            case 3://PROD
                res = dest + " = " + op1 + " * " + op2;
                break;
            case 4://DIV
                res = dest + " = " + op1 + " / " + op2;
                break;
            case 5://MOD
                res = dest + " = " + op1 + " % " + op2;
                break;
            case 6://AND
                res = dest + " = " + op1 + " && " + op2;
                break;
            case 7://OR
                res = dest + " = " + op1 + " || " + op2;
                break;
            case 8://SKIP
                res = dest + " : skip";
                break;
            case 9://IFEQ
                res = "if " + op1 + "=" + op2 + " goto " + dest;
                break;
            case 10://IFNE
                res = "if " + op1 + "!=" + op2 + " goto " + dest;
                break;
            case 11://IFLT
                res = "if " + op1 + "<" + op2 + " goto " + dest;
                break;
            case 12://IFLE
                res = "if " + op1 + "<=" + op2 + " goto " + dest;
                break;
            case 13://IFGE
                res = "if " + op1 + ">=" + op2 + " goto " + dest;
                break;
            case 14://IFGT
                res = "if " + op1 + ">" + op2 + " goto " + dest;
                break;
            case 15://PMB
                res = "pmb " + dest;
                break;
            case 16://CALL
                res = "call " + dest;
                break;
            case 17://RTN
                res = "pmb " + dest;
                break;
            case 18://PARAM_S
                res = "param_s" + dest;
                break;
            case 19://GOTO
                res = "goto " + dest;
                break;
            case 20://NEG
                res = dest + " = -" + op1;
                break;
        }
        return res;
        //return idInstrucciones.values()[cod] + "\t" + op1 + "\t" + op2 + "\t" + dest;
    }
    
}
