/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author tomeu
 */
public class Traductor {
    
    private Codigo3D c3d;
    
    public Traductor(){}
    
    public String traducir(Codigo3D c3d, TablaSimbolos ts){
        String res = "";
        declarar(c3d.TV,ts);
        ArrayList<Instruccion3D> cod = c3d.getCodigo();
        for(Instruccion3D inst : cod){
            switch(inst.cod){
                case 0://COPY
                    res = traduceCOPY(inst);
                    break;
                case 1://ADD
                    res = traduceADD(inst);
                    break;
                case 2://SUB
                    res = traduceSUB(inst);
                    break;
                case 3://PROD
                    res = traducePROD(inst);
                    break;
                case 4://DIV
                    res = traduceDIV(inst);
                    break;
                case 5://MOD
                    res = traduceMOD(inst);
                    break;
                case 6://AND
                    res = traduceAND(inst);
                    break;
                case 7://OR
                    res = traduceOR(inst);
                    break;
                case 8://SKIP
                    res = traduceSKIP(inst);
                    break;
                case 9://IFEQ
                    res = traduceIFEQ(inst);
                    break;
                case 10://IFNE
                    res = traduceIFNE(inst);
                    break;
                case 11://IFLT
                    res = traduceIFLT(inst);
                    break;
                case 12://IFLE
                    res = traduceIFLE(inst);
                    break;
                case 13://IFGE
                    res = traduceIFGE(inst);
                    break;
                case 14://IFGT
                    res = traduceIFGT(inst);
                    break;
                case 15://PMB
                    res = traducePMB(inst);
                    break;
                case 16://CALL
                    res = traduceCALL(inst);
                    break;
                case 17://RTN
                    res = traduceRTN(inst);
                    break;
                case 18://PARAM_S
                    res = traducePARAM_S(inst);
                    break;
                case 19://GOTO
                    res = traduceGOTO(inst);
                    break;
                case 20://NEG
                    res = traduceNEG(inst);
                    break;
            }
        }
        return res;
    }

    private String traduceCOPY(Instruccion3D inst) {
        String res = "    mov     ";
        
//        if(inst.literal1){
//            res += ",'" + inst.op1 + "'";
//        }else{
//            
//        }
        return res;
    }

    private String traduceADD(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceSUB(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traducePROD(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceDIV(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceMOD(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceAND(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceOR(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceSKIP(Instruccion3D inst) {
        return "e" + inst.dest + ":\n";
    }

    private String traduceIFEQ(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceIFNE(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceIFLT(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceIFLE(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceIFGE(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceIFGT(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traducePMB(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceCALL(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceRTN(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traducePARAM_S(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceGOTO(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceNEG(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void declarar(TablaVariables TV, TablaSimbolos ts) {
        String res = "section .data";
        
        res += "\nsegment .bss";
        for(TablaSimbolos.FilaTD fila : ts.td){
            if(fila.mvp == TablaSimbolos.Mvp.dvar || fila.mvp == TablaSimbolos.Mvp.dconst){
                int cant = getDesp(fila.tipo);
                res += "\n    v" + fila.nv + " resb " + cant;
            }
        }
    }
    
    private String desref(int nv){
        Variable var = c3d.TV.TV.get(nv);
        int desp = 0;
        String ref = "";
        if(var.isp){
        /*  COMO ENCONTRAR PARAMETROS
            1- Encontrar el subprograma de la variable mediante la TV
            2- Por cada variable de la TV que esté en el mismo subprograma y sea un parametro
               sumamos al desplazamiento su ocupación hasta encontrar la buena.
            3- Retornamos el desplazamiento en negativo*/
            int i = 0;
            while(i < nv){
                Variable aux = c3d.TV.TV.get(i);
                if(aux.isp && var.np == aux.np){
                    desp += getDesp(aux.tipo);
                }
            }
            ref = "[ebp+"+ desp +"]";
        }else{
            if(var.np > -1){
            /*  COMO ENCONTRAR VARIABLES LOCALES
                1- Encontrar el subprograma de la variable mediante la TV
                2- Por cada variable de la TV que esté en el mismo subprograma y no sea un parametro
                   sumamos al desplazamiento su ocupación hasta encontrar la buena.
                3- Retornamos el desplazamiento*/
                int i = 0;
                while(i < nv){
                    Variable aux = c3d.TV.TV.get(i);
                    if(!aux.isp && var.np == aux.np){
                        desp += getDesp(aux.tipo);
                    }
                }
                ref = "[ebp-"+ desp +"]";
            }else{
            /*  COMO ENCONTRAR GLOBALES */
                ref = "[v"+ nv +"]";
            }
        }
        return ref;
    }
    
    private int getDesp(TablaSimbolos.Tipo t){
        int cant;
        switch (t) {
            case tBool:
                cant = 1;
                break;
            case tInt:
                cant = 4;
                break;
            default:
                cant = 8;
                break;
        }
        return cant;
    }
}