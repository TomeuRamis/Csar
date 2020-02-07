/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.io.*;

/**
 *
 * @author Juan
 */
public class SimboloBase{

    private static int contador = 0;
    private int id;
    static Graph<SimboloBase, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

    String etiqueta;

    public SimboloBase(String variable) {
        etiqueta = variable;
        id = contador++;
        g.addVertex(this);
    }
    
    public static void resetArbol(){
        g = new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    public void imprimirArbol() {

        ComponentNameProvider<SimboloBase> vertexIdProvider = new ComponentNameProvider<SimboloBase>() {
            public String getName(SimboloBase sb) {
                return "s"+sb.id;
            }
        };

        ComponentNameProvider<SimboloBase> vertexLabelProvider = new ComponentNameProvider<SimboloBase>() {
            public String getName(SimboloBase sb) {
                return sb.etiqueta;
            }
        };

        GraphExporter<SimboloBase, DefaultEdge> exporter
                = new DOTExporter<>(vertexIdProvider, vertexLabelProvider, null);
        Writer writer;

        try {
            writer = new FileWriter("output/Arbol sintactico.dot");
            try {
                exporter.exportGraph(g, writer);
            } catch (ExportException ex) {
                Logger.getLogger(SimboloBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(SimboloBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
