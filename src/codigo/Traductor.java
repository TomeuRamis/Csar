/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author tomeu
 */
public class Traductor {
    Codigo3D c3d;
    public Traductor(Codigo3D c3d){
        this.c3d = c3d;
        
        traducir();
    }
    

    
    
    public void imprimir(String path){
        String str = this.toString();
        Writer writer;
        try {
            writer = new FileWriter(path);         
            writer.write(str);
            writer.close();
        } catch (IOException ex) {
        }
    }
}
