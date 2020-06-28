/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author tomeu
 */
public class Optimizador {

    Codigo3D c3d;

    public Optimizador(Codigo3D c3d) {
        this.c3d = c3d;
    }

    public Codigo3D optimiza() {
        Codigo3D op_c3d = optimizacion_finestra(c3d);
        return op_c3d;
    }

    public Codigo3D optimizacion_finestra(Codigo3D op_c3d) {

        //8 - Assignacions diferides
        int usosVariables[] = new int[op_c3d.TV.TV.size()];
        int[] valoresVariables = new int[op_c3d.TV.TV.size()];
        boolean[] esLiteral = new boolean[op_c3d.TV.TV.size()];

        for (int i = 0; i < usosVariables.length; i++) {
            usosVariables[i] = 0;
        }
        for (int i = 0; i < esLiteral.length; i++) {
            esLiteral[i] = false;
        }
        //Contamos las apariciones de cada variable
        for (int i = 0; i < op_c3d.codigo.size(); i++) {
            Instruccion3D inst = op_c3d.codigo.get(i);
            /*if (!inst.literal1) {
                usosVariables[inst.op1]++;
            }
            if (!inst.literal2) {
                usosVariables[inst.op2]++;
            }*/
            if (inst.dest != -1) {
                switch (inst.cod) {
                    case 0: //copy
                        usosVariables[inst.dest]++;
                        valoresVariables[inst.dest] = inst.op1;
                        esLiteral[inst.dest] = inst.literal1;
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                        break;
                    default:
                        usosVariables[inst.dest]++;
                        break;
                }
            }
        }
        //Los variables que solo tengan una asignacion seran OPTIMIZADAS
        
        //Esto funciona mal
        /*
        for (int i = 0; i < op_c3d.codigo.size(); i++) { //por cada instruccion de 3d
            Instruccion3D inst = op_c3d.codigo.get(i);

            if (inst.op1 != -1 && !inst.literal1) {
                if (usosVariables[inst.op1] == 1) { //si esta variable solo se asigna una vez se sustituye por el valor al que apunta
                    if (esLiteral[inst.op1]) {
                        inst.op1 = valoresVariables[inst.op1];
                        inst.literal1 = true;
                        if (inst.cod == 0) { //es un copy
                            valoresVariables[inst.dest] = inst.op1;
                            esLiteral[inst.dest] = true;
                        }
                    }
                }
            }
            if (inst.op2 != -1 && !inst.literal2) {
                if (usosVariables[inst.op2] == 1) { //si esta variable solo se asigna una vez se sustituye por el valor al que apunta
                    if (esLiteral[inst.op2]) {
                        inst.op2 = valoresVariables[inst.op2]; 
                        inst.literal2 = true;                    
                        if (inst.cod == 0) { //es un copy
                            valoresVariables[inst.dest] = inst.op2;
                            esLiteral[inst.dest] = true;
                        }
                    }
                }
            }


            /*
            if (inst.cod == 0) { //si la instruccion es un copy
                if (usosVariables[inst.dest] == 1) { //la variable destino solo se asigna usa una vez
                    valoresVariables[inst.dest] = inst.op1; //guardamos el valor que se le asigna
                    esLiteral[inst.dest] = inst.literal1;
                    if (!inst.literal1) {
                        if (valoresVariables[inst.op1] != -1) { //si no es literal y existe un valor anterior, se lo asignamos
                            valoresVariables[inst.dest] = valoresVariables[inst.op1];
                        }
                    }
                    op_c3d.codigo.remove(i);
                }
            }
             
        }
        */
        return op_c3d;
    }
}
