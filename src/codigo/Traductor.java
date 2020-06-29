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
    boolean imprimirInt = false;
    boolean imprimirBool = false;

    public Traductor() {
    }

    public String traducir(Codigo3D c3d) {
        this.c3d = c3d;

        String res = "";
        res += declarar();
        res += "section .text\n";
        res += "    global _main\n";
        res += "    extern _printf\n";
        res += "    extern _scanf\n";
        res += "_main:\n";
        ArrayList<Instruccion3D> cod = c3d.getCodigo();
        for (Instruccion3D inst : cod) {
            switch (inst.cod) {
                case 0://COPY
                    res += traduceCOPY(inst);
                    break;
                case 1://ADD
                    res += traduceADD(inst);
                    break;
                case 2://SUB
                    res += traduceSUB(inst);
                    break;
                case 3://PROD
                    res += traducePROD(inst);
                    break;
                case 4://DIV
                    res += traduceDIV(inst);
                    break;
                case 5://MOD
                    res += traduceMOD(inst);
                    break;
                case 6://AND
                    res += traduceAND(inst);
                    break;
                case 7://OR
                    res += traduceOR(inst);
                    break;
                case 8://SKIP
                    res += traduceSKIP(inst);
                    break;
                case 9://IFEQ
                    res += traduceIFEQ(inst);
                    break;
                case 10://IFNE
                    res += traduceIFNE(inst);
                    break;
                case 11://IFLT
                    res += traduceIFLT(inst);
                    break;
                case 12://IFLE
                    res += traduceIFLE(inst);
                    break;
                case 13://IFGE
                    res += traduceIFGE(inst);
                    break;
                case 14://IFGT
                    res += traduceIFGT(inst);
                    break;
                case 15://PMB
                    res += traducePMB(inst);
                    break;
                case 16://CALL
                    res += traduceCALL(inst);
                    break;
                case 17://RTN
                    res += traduceRTN(inst);
                    break;
                case 18://PARAM_S
                    res += traducePARAM_S(inst);
                    break;
                case 19://GOTO
                    res += traduceGOTO(inst);
                    break;
                case 20://IN
                    res += traduceIN(inst);
                    break;
                case 21: //OUT
                    res += traduceOUT(inst);
                    break;
                case 22://NEG
                    res += traduceNEG(inst);
                    break;
                case 23:
                    res += traduceMULP2(inst);
                    break;
                case 24:
                    res += traduceDIVP2(inst);
                    break;
            }
        }
        res += "    ret\n";
        if (imprimirInt) {
            res += "printNumber:\n"
                    + "    push    eax\n"
                    + "    push    edx\n"
                    + "    xor     edx,edx\n"
                    + "    cmp     eax, 0\n"
                    + "    jge     l2\n"
                    + "    push    menos\n"
                    + "    call    _printf\n"
                    + "    neg     eax\n"
                    + "    add     esp, 4\n"
                    + "l2:\n"
                    + "    div     dword [const10]\n"
                    + "    test    eax,eax\n"
                    + "    je      l1\n"
                    + "    call    printNumber\n"
                    + "l1:\n"
                    + "    add     edx, '0'\n"
                    + "    mov     [outInt], edx\n"
                    + "    push    outInt\n"
                    + "    call    _printf\n"
                    + "    add     esp,4\n"
                    + "    pop     edx\n"
                    + "    pop     eax\n"
                    + "    ret\n";
        }
        if (imprimirBool) {
            res += "printBool:\n";
            res += "    mov     ebx, 0\n";
            res += "    cmp     ebx, eax\n";
            res += "    je      efalse\n";
            res += "    push    strtrue\n";
            res += "    jmp     eibf\n";
            res += "efalse:\n";
            res += "    push    strfalse\n";
            res += "eibf:\n";
            res += "    call    _printf\n";
            res += "    add     esp,4\n";
            res += "    ret\n";
        }
        return res;
    }

    private String traduceCOPY(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceADD(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    mov     ebx, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    add     eax, ebx\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceSUB(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    mov     ebx, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    sub     eax, ebx\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traducePROD(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    imul    " + desref(inst.op2, inst.literal2) + "\n";;
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceDIV(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    idiv    " + desref(inst.op2, inst.literal2) + "\n";;
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceMOD(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    idiv    " + desref(inst.op2, inst.literal2) + "\n";;
        res += "    mov     " + desref(inst.dest, false) + ", edx\n";
        return res;
    }

    private String traduceAND(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    mov     ebx, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    and     eax, ebx\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceOR(Instruccion3D inst) {
        String res = "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    mov     ebx, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    or      eax, ebx\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        return res;
    }

    private String traduceSKIP(Instruccion3D inst) {
        return "e" + inst.dest + ":\n";
    }

    private String traduceIFEQ(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    je      e" + inst.dest + "\n";
        return res;
    }

    private String traduceIFNE(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    jne     e" + inst.dest + "\n";
        return res;
    }

    private String traduceIFLT(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    jl      e" + inst.dest + "\n";
        return res;
    }

    private String traduceIFLE(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    jle     e" + inst.dest + "\n";
        return res;
    }

    private String traduceIFGE(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    jge     e" + inst.dest + "\n";
        return res;
    }

    private String traduceIFGT(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        res += "    cmp     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    jg      e" + inst.dest + "\n";
        return res;
    }

    private String traducePMB(Instruccion3D inst) {
        String res = "";
        //Igual aquí hay que guardar el stack pointer
        res += "    push    ebp\n";
        res += "    mov     ebp, esp \n";
        int ocupacion = 0;
        int np = inst.dest;
        int tvsize = c3d.TV.TV.size();
        int i = 0;
        Variable aux = c3d.TV.TV.get(i);
        while (i < tvsize && aux.np <= np) {
            aux = c3d.TV.TV.get(i);
            if (!aux.isp && np == aux.np) {
                ocupacion += getDesp(aux.tipo);
            }
            i++;
        }

        res += "    sub     esp, " + ocupacion + "\n";
        return res;
    }

    private String traduceCALL(Instruccion3D inst) {
        String res = "";

        res += "    call    e" + c3d.TP.TP.get(inst.dest).etiqueta + "\n";
        if (inst.op1 != -1) {
            res += "    mov     " + desref(inst.op1, inst.literal1) + ", eax\n";
        }
        return res;
    }

    private String traduceRTN(Instruccion3D inst) {
        String res = "";
        int ocupacion = 0;
        int np = inst.dest;
        int tvsize = c3d.TV.TV.size();
        int i = 0;
        Variable aux = c3d.TV.TV.get(i);
        while (i < tvsize && aux.np <= np) {
            aux = c3d.TV.TV.get(i);
            if (!aux.isp && np == aux.np) {
                ocupacion += getDesp(aux.tipo);
            }
            i++;
        }

        if (inst.op1 != -1) {
            res += "    mov     eax, " + desref(inst.op1, inst.literal1) + "\n";
        }
        res += "    add     esp, " + ocupacion + "\n";
        res += "    pop     ebp\n";
        res += "    ret\n";
        return res;
    }

    private String traducePARAM_S(Instruccion3D inst) {
        String res = "";
        res += "    push    " + desref(inst.op1, inst.literal1) + "\n";
        return res;
    }

    private String traduceGOTO(Instruccion3D inst) {
        String res = "    jmp     e" + inst.dest + "\n";
        return res;
    }

    private String traduceIN(Instruccion3D inst) {
        String res = "";
        String desref = desref(inst.dest, false);
        desref = desref.substring(5);
        res += "    lea     eax, " + desref + "\n";
        res += "    push    eax\n";
        if (c3d.TV.TV.get(inst.dest).tipo == TablaSimbolos.Tipo.tInt) {
            res += "    push    formatInt \n";
        } else if (c3d.TV.TV.get(inst.dest).tipo == TablaSimbolos.Tipo.tString) {
            res += "    push    formatStr \n";
        } else {
            res += "    push    formatInt \n";
        }

        res += "    call    _scanf\n";
        res += "    add     esp, 8\n";
        return res;
    }

    private String traduceOUT(Instruccion3D inst) {
        String res = "";
        if (c3d.TV.TV.get(inst.dest).tipo == TablaSimbolos.Tipo.tInt) {
            imprimirInt = true;
            res += "    mov     eax, " + desref(inst.dest, false) + "\n";
            res += "    call    printNumber\n";
        } else if (c3d.TV.TV.get(inst.dest).tipo == TablaSimbolos.Tipo.tString) {
            res += "    push    " + desref(inst.dest, false) + "\n";
            res += "    call    _printf\n";
        } else {
            imprimirBool = true;
            res += "    mov     eax, " + desref(inst.dest, false) + "\n";
            res += "    call    printBool\n";

        }
        res += "    push    barraN\n";
        res += "    call    _printf\n";
        res += "    add     esp, 4\n";
        return res;
    }

    private String traduceNEG(Instruccion3D inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String traduceMULP2(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        res += "    shl     " + desref(inst.dest, false) + ", " + inst.op1 + "\n";
        return res;
    }

    private String traduceDIVP2(Instruccion3D inst) {
        String res = "";
        res += "    mov     eax, " + desref(inst.op2, inst.literal2) + "\n";
        res += "    mov     " + desref(inst.dest, false) + ", eax\n";
        res += "    shr     " + desref(inst.dest, false) + ", " + inst.op1 + "\n";
        return res;
    }

    private String declarar() {
        String res = "section .data\n";
        res += "    formatInt: db \"%d\", 0 \n";
        res += "    formatStr: db \"%s\", 0 \n";
        res += "    const10:    dd 10\n";
        res += "    outInt:     dd 0\n";
        res += "    strtrue:   db \"true\",0\n";
        res += "    strfalse:  db \"false\",0\n";
        res += "    menos:  db \"-\",0\n";
        res += "    barraN:    db 10,0 \n";
        res += "segment .bss\n";

        for (int i = 0; i < c3d.TV.nv + 1; i++) {
            Variable var = c3d.TV.TV.get(i);
            if (!var.isp && var.np == -1) {
                int cant = getDesp(var.tipo);
                res += "    v" + i + " resb " + cant + "\n";
            }
        }
        return res;
    }

    private String desref(int nv, boolean literal) {

        int desp = 0;
        String ref = "";
        if (literal) {
            ref = "dword " + nv;
        } else {
            Variable var = c3d.TV.TV.get(nv);
            ref += getOperationSize(var.tipo) + " ";
            if (var.isp) {
                /*  COMO ENCONTRAR PARAMETROS
        if(var.isp){
        /*  COMO ENCONTRAR PARAMETROS
            1- Encontrar el subprograma de la variable mediante la TV
            2- Por cada variable de la TV que esté en el mismo subprograma y sea un parametro
               sumamos al desplazamiento su ocupación hasta encontrar la buena.
            3- Retornamos el desplazamiento en negativo*/
                int i = 0;
                while (i < nv) {
                    Variable aux = c3d.TV.TV.get(i);
                    if (aux.isp && var.np == aux.np) {
                        desp += getDesp(aux.tipo);
                    }
                    i++;
                }
                ref += "[ebp+" + (desp + 8) + "]"; //sumamos 4+4 para contabilizar el espacio ocupado por la direccion de retorno y el ebp
            } else {
                if (var.np > -1) {
                    /*  COMO ENCONTRAR VARIABLES LOCALES
                1- Encontrar el subprograma de la variable mediante la TV
                2- Por cada variable de la TV que esté en el mismo subprograma y sea un parametro
                   sumamos al desplazamiento su ocupación hasta encontrar la buena.
                3- Retornamos el desplazamiento en negativo*/
                    int i = 0;
                    while (i < nv) {
                        Variable aux = c3d.TV.TV.get(i);
                        if (!aux.isp && var.np == aux.np) {
                            desp += getDesp(aux.tipo);
                        }
                        i++;
                    }
                    ref += "[ebp-" + (desp + 4) + "]"; //Por el puntero de la pila
                } else {
                    /*  COMO ENCONTRAR GLOBALES */
                    ref += "[v" + nv + "]";
                }
            }
        }
        return ref;
    }

    private int getDesp(TablaSimbolos.Tipo t) {
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

    private String getOperationSize(TablaSimbolos.Tipo t) {
        String opsize;
        switch (t) {
            case tBool:
                opsize = "dword";
                break;
            case tInt:
                opsize = "dword";
                break;
            default:
                opsize = "dword";
                break;
        }
        return opsize;
    }

    public void traducir(String path, Codigo3D c3d) {
        String traduccion = traducir(c3d);
        imprimir(path, traduccion);
    }

    private void imprimir(String path, String traduccion) {
        Writer writer;
        try {
            writer = new FileWriter(path);
            writer.write(traduccion);
            writer.close();
        } catch (IOException ex) {
        }
    }
}
