
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaProcedimientos {
    int np;
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
    int etiqueta, nParam; 
    
    Procedimiento(){
        nParam = 0;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public void incrementarNParams(){
        nParam++;
    }
    
    @Override
    public String toString(){
        return "Etiqueta: "+etiqueta + " NParams: " + nParam;
    }
}