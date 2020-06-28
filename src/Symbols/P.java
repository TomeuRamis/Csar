/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author Juan
 */
public class P extends SimboloBase{
    
    public P(P1 p1, P2 p2, codigo.TablaSimbolos ts){
        super("P");
        
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output/tablaSimbolos.xls"));
            writer.write(ts.toString());
            writer.close();
            
        } catch (IOException ex) {
            //Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
            codigo.FrmPrincipal.notificarError("ERROR: asegurate de cerrar el archivo de la tabla de simbolos.");
            //System.err.println("ERROR: problema al escribir la tabla de simbolos");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        g.addEdge(this, p1);
        g.addEdge(this, p2);
        
        this.imprimirArbol();
        C3D.llenaTP();
        System.out.println(C3D);
        C3D.imprimir("output/Codigo3Direcciones.txt");
        codigo.Traductor traductor = new codigo.Traductor();
        traductor.traducir("output/CodigoEnsambladorSinOptimizar.asm", C3D);
        
        System.out.println("***************************************************");
        
        codigo.Optimizador optimizador= new codigo.Optimizador(C3D);
        codigo.Codigo3D op_C3D = optimizador.optimiza();
        System.out.println(op_C3D);
        op_C3D.imprimir("output/Codigo3Direcciones.txt");
        traductor.traducir("output/CodigoEnsambladorOptimizado.asm", op_C3D);
        
        C3D.reset();
    }
}
