/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import codigo.idInstrucciones;

/**
 *
 * @author Juan
 */
public class EXPRP extends SimboloBase {

    EXPRP expresionP;
    OPERADOR operador;
    EXPR expresion;
    int r;

    codigo.TablaSimbolos.Tipo tipo;

    public EXPRP(EXPR exp) {
        super("EXPRP", exp.fila, exp.columna);
        r = exp.r;
        tipo = exp.tipo;

        g.addEdge(this, exp);

        //no genera (creo)
    }

    public EXPRP(EXPRP exprp, OPERADOR operador, EXPR expr) {
        super("EXPRP", exprp.fila, exprp.columna);
        /*
          El tipo de la expresion será el tipo de las expresiones
          Se debe comprobar que ambas expresiones tengan tipos compatibles y que
          el operador se pueda utilizar con ese tipo de datos.
         */
        if (exprp.tipo != expr.tipo) { //Los tipos no coinciden
            this.tipo = codigo.TablaSimbolos.Tipo.tNull;
            //ERROR
            codigo.FrmPrincipal.notificarError("Error semántico: Operacion entre los tipos incompatibles " + exprp.tipo + " y " + expr.tipo + " en linea: " + (exprp.fila + 1));
        } else {
            if (exprp.tipo == codigo.TablaSimbolos.Tipo.tInt) { //Son numeros
                //Operadores relacionales
                //Operadores aritmeticos
                if (operador.tOp == OPERADOR.tOperador.tLogico) {
                    //ERROR
                    codigo.FrmPrincipal.notificarError("Error semántico: Operador incompatible en linea: " + (exprp.fila + 1));
                } else if (operador.tOp == OPERADOR.tOperador.tRelacional) {
                    tipo = codigo.TablaSimbolos.Tipo.tBool;

                    idInstrucciones op = idInstrucciones.NEG; //PALCEHOLDER
                    switch (operador.operador) {
                        case "==":
                            op = idInstrucciones.IFEQ;
                            break;
                        case "!=":
                            op = idInstrucciones.IFNE;
                            break;
                        case "<":
                            op = idInstrucciones.IFLT;
                            break;
                        case "=<":
                            op = idInstrucciones.IFLE;
                            break;
                        case "=>":
                            op = idInstrucciones.IFGE;
                            break;
                        case ">":
                            op = idInstrucciones.IFGT;
                            break;
                        default:
                            codigo.FrmPrincipal.notificarError("Error semántico: algo esta roto en EXPRP.java");
                            break;
                    }
                    int e1 = C3D.nuevaEtiqueta();
                    int e2 = C3D.nuevaEtiqueta();
                    int t = C3D.nuevaVar(tipo);
                    C3D.genera(op.ordinal(), exprp.r, expr.r, e1);
                    C3D.genera(idInstrucciones.COPY.ordinal(), 0, true, -1, t);
                    C3D.genera(idInstrucciones.GOTO.ordinal(), -1, -1, e2);
                    C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e1);
                    C3D.genera(idInstrucciones.COPY.ordinal(), -1, true, -1, t);
                    C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e2);
                    this.r = t; //estoy llorando

                } else {
                    tipo = codigo.TablaSimbolos.Tipo.tInt;
                    int op = -1;
                    switch (operador.operador) {
                        case "+":
                            op = 1; //ADD
                            break;
                        case "-":
                            op = 2; //SUB
                            break;
                        case "*":
                            op = 3; //PROD
                            break;
                        case "/":
                            op = 4; //DIV
                            break;
                        case "%":
                            op = 5; //MOD
                            break;
                        default:
                            codigo.FrmPrincipal.notificarError("Error semántico: algo esta roto en EXPRP.java");
                            break;
                    }
                    int t = C3D.nuevaVar(tipo);
                    C3D.genera(op, exprp.r, expr.r, t);
                    this.r = t;
                }
            }
            if (exprp.tipo == codigo.TablaSimbolos.Tipo.tString) { //Son strings
                //Operadores relacionales (Comparacion y diferencia)
                if (!operador.operador.equals("==") && !operador.operador.equals("!=") && !operador.operador.equals("+")) {
                    //ERROR
                    codigo.FrmPrincipal.notificarError("Error semántico: Operador incompatible en linea: " + (exprp.fila + 1));
                } else if (operador.tOp == OPERADOR.tOperador.tRelacional) {
                    tipo = codigo.TablaSimbolos.Tipo.tBool;
                } else {
                    tipo = codigo.TablaSimbolos.Tipo.tString;
                }
            }

            if (exprp.tipo == codigo.TablaSimbolos.Tipo.tBool) { //Son booleanos
                //Operadores relacionales (Comparacion y diferencia)
                //Operadores logicos
                if (operador.tOp != OPERADOR.tOperador.tLogico && !operador.operador.equals("==") && !operador.operador.equals("!=")) {
                    //ERROR
                    codigo.FrmPrincipal.notificarError("Error semántico: Operador incompatible en linea: " + (exprp.fila + 1));
                } else if (operador.operador.equals("==") || operador.operador.equals("!=")) {

                    tipo = codigo.TablaSimbolos.Tipo.tBool;

                    idInstrucciones op = idInstrucciones.NEG; //PALCEHOLDER
                    switch (operador.operador) {
                        case "==":
                            op = idInstrucciones.IFEQ;
                            break;
                        case "!=":
                            op = idInstrucciones.IFNE;
                            break;
                        default:
                            codigo.FrmPrincipal.notificarError("Error semántico: algo esta roto en EXPRP.java");
                            break;
                    }
                    int e1 = C3D.nuevaEtiqueta();
                    int e2 = C3D.nuevaEtiqueta();
                    int t = C3D.nuevaVar(tipo);
                    C3D.genera(op.ordinal(), exprp.r, expr.r, e1);
                    C3D.genera(idInstrucciones.COPY.ordinal(), 0, true, -1, t);
                    C3D.genera(idInstrucciones.GOTO.ordinal(), -1, -1, e2);
                    C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e1);
                    C3D.genera(idInstrucciones.COPY.ordinal(), -1, true, -1, t);
                    C3D.genera(idInstrucciones.SKIP.ordinal(), -1, -1, e2);
                    this.r = t;

                } else {
                    tipo = codigo.TablaSimbolos.Tipo.tBool;
                    idInstrucciones op = idInstrucciones.NEG; //PALCEHOLDER
                    switch (operador.operador) {
                        case "&&":
                            op = idInstrucciones.AND;
                            break;
                        case "||":
                            op = idInstrucciones.OR;
                            break;
                        default:
                            codigo.FrmPrincipal.notificarError("Error semántico: algo esta roto en EXPRP.java");
                            break;
                    }
                    int t = C3D.nuevaVar(tipo);
                    C3D.genera(op.ordinal(), exprp.r, expr.r, t);
                    this.r = t;
                }

            }
        }

        g.addEdge(this, exprp);
        g.addEdge(this, operador);
        g.addEdge(this, expr);
    }
}
