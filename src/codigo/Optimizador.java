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

        boolean cambios = false;

        do {
            cambios = false;
            //2 - brancaments sobre brancaments
            for (int i = 0; i < op_c3d.codigo.size(); i++) {
                Instruccion3D inst = op_c3d.codigo.get(i);
                if ((inst.cod >= 9 && inst.cod <= 14) || inst.cod == 19) {
                    for (int j = 0; j < op_c3d.codigo.size(); j++) {
                        Instruccion3D aux = op_c3d.codigo.get(j);
                        if (aux.cod == 8 && inst.dest == aux.dest) {
                            if (op_c3d.codigo.get(j + 1).cod == 19) {
                                inst.dest = op_c3d.codigo.get(j + 1).dest;
                                cambios = true;
                            }
                        }
                    }
                }
            }

            //4 - operacions constants
            for (int i = 0; i < op_c3d.codigo.size(); i++) {
                Instruccion3D inst = op_c3d.codigo.get(i);
                if (inst.literal1 && inst.literal2) {
                    int val;
                    switch (inst.cod) {
                        case 1:
                            val = inst.op1 + inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 2:
                            val = inst.op1 - inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 3:
                            val = inst.op1 * inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 4:
                            val = inst.op1 / inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 5:
                            val = inst.op1 % inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 6:
                            val = inst.op1 & inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 7:
                            val = inst.op1 | inst.op2;
                            inst.cod = 0;
                            inst.op1 = val;
                            inst.op2 = -1;
                            inst.literal2 = false;
                            cambios = true;
                            break;
                        case 9:
                            if (inst.op1 == inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        case 10:
                            if (inst.op1 != inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        case 11:
                            if (inst.op1 < inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        case 12:
                            if (inst.op1 <= inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        case 13:
                            if (inst.op1 >= inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        case 14:
                            if (inst.op1 > inst.op2) {
                                inst.cod = 19;
                                inst.op1 = -1;
                                inst.op2 = -1;
                                inst.literal1 = false;
                                inst.literal2 = false;
                            }else{
                               op_c3d.codigo.remove(i);
                            }
                            cambios = true;
                            break;
                        default:
                            break;
                    }
                }
            }

            //7 - normalitzacio d'operacions commutatives
            for (int i = 0; i < op_c3d.codigo.size(); i++) {
                Instruccion3D inst = op_c3d.codigo.get(i);
                switch (inst.cod) {
                    case 1:
                    case 3:
                    case 6:
                    case 7:
                        if (!inst.literal1 && inst.literal2) {
                            int aux = inst.op1;
                            boolean auxb = inst.literal1;
                            inst.op1 = inst.op2;
                            inst.literal1 = inst.literal2;
                            inst.op2 = aux;
                            inst.literal2 = auxb;
                            cambios = true;
                        } else if (!inst.literal1 && !inst.literal2) {
                            if (inst.op1 > inst.op2) {
                                int aux = inst.op1;
                                boolean auxb = inst.literal1;
                                inst.op1 = inst.op2;
                                inst.literal1 = inst.literal2;
                                inst.op2 = aux;
                                inst.literal2 = auxb;
                                cambios = true;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

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
                if (!inst.literal1 && inst.op1 != -1) {
                    usosVariables[inst.op1]++;
                }
                if (!inst.literal2 && inst.op2 != -1) {
                    usosVariables[inst.op2]++;
                }
                /*if (inst.dest != -1) {
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
            }*/
            }

            for (int i = 0; i < usosVariables.length; i++) {
                if (usosVariables[i] == 1) {
                    Instruccion3D inst = null;

                    for (int j = 0; j < op_c3d.codigo.size(); j++) {
                        Instruccion3D aux = op_c3d.codigo.get(j);
                        switch (aux.cod) {
                            case 20: //ignoramos las instrucciones que no nos gustan
                            case 21:
                            case 8:
                            case 15:
                            case 19:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                                break;
                            default:
                                if (aux.dest == i) {
                                    inst = aux;
                                }
                                break;
                        }
                        if (aux.cod < 9 || aux.cod > 14) { //ignoramos si es un if para evitar problemas con los whiles
                            if (inst != null && ((!aux.literal1 && aux.op1 == i) || (!aux.literal2 && aux.op2 == i))) {
                                if (aux.cod == 0 && inst.cod == 0) {//ambos son copy
                                    aux.op1 = inst.op1;
                                    aux.literal1 = inst.literal1;
                                    op_c3d.codigo.remove(inst);
                                    cambios = true;
                                } else if (aux.cod == 0) {//aux es copy
                                    aux.cod = inst.cod;
                                    aux.op1 = inst.op1;
                                    aux.literal1 = inst.literal1;
                                    aux.op2 = inst.op2;
                                    aux.literal2 = inst.literal2;
                                    op_c3d.codigo.remove(inst);
                                    cambios = true;
                                } else if (inst.cod == 0) { //inst es copy
                                    if (!aux.literal1 && aux.op1 == i) {
                                        aux.op1 = inst.op1;
                                        aux.literal1 = inst.literal1;
                                    } else if (!aux.literal2 && aux.op2 == i) {
                                        aux.op2 = inst.op1;
                                        aux.literal2 = inst.literal1;
                                    }
                                    op_c3d.codigo.remove(inst);
                                    cambios = true;
                                }
                            }
                        }
                    }
                }
            }

        } while (cambios);
        return op_c3d;
    }

}
