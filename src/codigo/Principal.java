
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {
    public static void main(String[] args) {
        
        generarArchivos();
        try {
            if (Files.exists(Paths.get("src/codigo/Cooper.java"))) {
                Files.delete(Paths.get("src/codigo/Cooper.java"));
            }
            if (Files.exists(Paths.get("src/codigo/sym.java"))) {
                Files.delete(Paths.get("src/codigo/sym.java"));
            }
            Files.move(
                    Paths.get("Cooper.java"),
                    Paths.get("src/codigo/Cooper.java")
            );
            Files.move(
                    Paths.get("sym.java"),
                    Paths.get("src/codigo/sym.java")
            );
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
