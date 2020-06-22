
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
        return idInstrucciones.values()[cod] + "\t" + op1 + "\t" + op2 + "\t" + dest;
    }
    
}
