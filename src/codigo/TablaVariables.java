
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaVariables {
    
    public int nv = -1;
    ArrayList<Variable> TV = new ArrayList<>();
    
    public int nuevaVar(codigo.TablaSimbolos.Tipo tipo){
        nv = nv + 1;
        TV.add(new Variable(tipo));
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
    
    public Variable(codigo.TablaSimbolos.Tipo tipo){
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return "Tipo: "+tipo;
    }
}
