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
public class SimboloBase extends ComplexSymbol {

    private static int idAutoIncrement = 0;
    static Graph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

    public SimboloBase(String variable, String valor) {
        super(variable, idAutoIncrement, valor);
        idAutoIncrement++;
    }

    public void imprimirArbol() {
        
        ComponentNameProvider<String> vertexIdProvider = new ComponentNameProvider<String>()
        {
            public String getName(String uri)
            {
                return uri;
            }
        };
       
        GraphExporter<String, DefaultEdge> exporter
                = new DOTExporter<>(vertexIdProvider,null,null );
        Writer writer;
        try {
            writer = new FileWriter("Arbol sintactico.dot");
            try {
                exporter.exportGraph(g, writer);
            } catch (ExportException ex) {
                Logger.getLogger(SimboloBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(writer.toString());
        } catch (IOException ex) {
            Logger.getLogger(SimboloBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
