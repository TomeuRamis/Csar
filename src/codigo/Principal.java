/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) {
        
        generarArchivos();
    }
    public static void generarArchivos(){
        String rutaLexico = "src/codigo/Lexer.flex";
        String rutaSintax = "src/codigo/Sintax.cup";

        JFlex.Main.generate(new File(rutaLexico));
        String[] sintax = {"-parser", "Cooper", rutaSintax};
        try {
            java_cup.Main.main(sintax);
        } catch (Exception ex) {
            System.out.println("Error: "+ex);
        } 
        
    }
}
