
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaVariables {
    
    public int nv = -1;
    ArrayList<Variable> TV = new ArrayList<>();
    
    public int nuevaVar(codigo.TablaSimbolos.Tipo tipo, int np, boolean isp){
        nv = nv + 1;
        TV.add(new Variable(tipo,np,isp));
        return nv;
    }
    
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < TV.size(); i++){
            res += "\n" + i + ": " + TV.get(i).toString();
        }
        return res;
    }
}

class Variable{
    
    codigo.TablaSimbolos.Tipo tipo;
    int np; // -1: Global, -2: Local del Main
    boolean isp;
    
    public Variable(codigo.TablaSimbolos.Tipo tipo, int np, boolean isp){
        this.tipo = tipo;
        this.np = np;
        this.isp = isp;
    }
    
    @Override
    public String toString(){
        return "Tipo: "+tipo+"\tNP: " + np + "\tIsParam: " + isp;
    }
}
