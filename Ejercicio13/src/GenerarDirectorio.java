import java.io.File;

public class GenerarDirectorio implements Runnable {
    public void run() {
        System.out.println("Generando directorio...");

        String directorio = "DirectorioCiudades";

        File directorioCiudades = new File(directorio);
        if (!directorioCiudades.exists()) {
            if (directorioCiudades.mkdir()) {
                System.out.println("Directorio creado: " + directorio);
            } else {
                System.out.println("Error al crear el directorio.");
                return;
            }
        } else {
            System.out.println("El directorio ya existe.");
        }
    }
        
   
}