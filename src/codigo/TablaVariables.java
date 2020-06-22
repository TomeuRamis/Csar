
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class TablaVariables {
    
    public int nv = -1;
    ArrayList<Variable> TV = new ArrayList<>();
    
    public int nuevaVar(){
        nv = nv + 1;
        TV.add(new Variable());
        return nv;
    }
    
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < TV.size(); i++){
            res += "\n" + TV.get(i).toString();
        }
        return res;
    }
}

class Variable{
    
    public Variable(){
    }
    
    @Override
    public String toString(){
        return "";
    }
}
