
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaProcedimientos {
    public int np;
    ArrayList<Procedimiento> TP;
    
    public TablaProcedimientos(){
        np = -1;
        TP = new ArrayList<>();
    }
    
    public int nuevoProcedimiento(){
        np = np + 1;
        TP.add(new Procedimiento());
        return np;
    }
    
    public void setEtiquetaP(int n, int e){
        TP.get(n).setEtiqueta(e);
    }
    
    public void incrementarNParams(int n){
        TP.get(n).incrementarNParams();
    }

    void llenaTP(TablaVariables TV) {
        for(Variable var : TV.TV){
            if(var.np > -1){
                Procedimiento proc = TP.get(var.np);
                if(!var.isp){
                    int ocu;
                    switch(var.tipo.ordinal()){
                        case 0: //Bool
                            ocu = 1;
                            break;
                        case 1: //String
                            ocu = 8;
                            break;
                        case 2: //Int
                            ocu = 4;
                            break;
                        default:
                            ocu = -10000;
                    }
                    proc.ocupacion += ocu;
                }
            }
        }
    }
    
    @Override
    public String toString(){
        String res = "TABLA PROCEDIMIENTOS";
        for(int i = 0; i < TP.size(); i++){
            res += "\nnp: " + i + " " + TP.get(i);
        }
        return res;
    }
}

class Procedimiento{
    int etiqueta, ocupacion, nParam; 
    
    Procedimiento(){
        nParam = 0;
        ocupacion = 0;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public void incrementarNParams(){
        nParam++;
    }
    
    @Override
    public String toString(){
        return "Etiqueta: "+etiqueta + "\tNParams: " + nParam + "\tOcupacion: " + ocupacion;
    }
}