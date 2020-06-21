
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaProcedimientos {
    int np = -1;
    ArrayList<Procedimiento> TP;
    public int nuevoProcedimiento(){
        np = np + 1;
        TP.add(new Procedimiento());
        return np;
    }
    
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < TP.size(); i++){
            res += "\n" + TP.get(i).toString();
        }
        return res;
    }
}

class Procedimiento{
    int etiqueta, nParam;
    
    Procedimiento(){
        
    }
    
    @Override
    public String toString(){
        return "";
    }
}