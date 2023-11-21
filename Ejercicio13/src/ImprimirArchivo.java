import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImprimirArchivo implements Runnable {
    private Ciudad ciudad;

    public ImprimirArchivo(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void run() {
        try {
            FileWriter archivo = new FileWriter("DirectorioCiudades/"+ ciudad.nombre + ".txt");
            PrintWriter pw = new PrintWriter(archivo);

            pw.println("Ciudad: " + ciudad.nombre);
            pw.println("Cantidad de habitantes: " + ciudad.habitantes);
            pw.println("Superficie: " + ciudad.superficie);
            pw.println("Proyección habitantes 2030: " + ciudad.calcularProyeccionHabitantes());
            pw.println("Superficie ocupada: " + ciudad.calcularSuperficieOcupada());

            archivo.close();
            System.out.println("Archivo " + ciudad.nombre + ".txt generado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
