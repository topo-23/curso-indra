import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        List<Prestamo> prestamos = new ArrayList<>();

        String nombreLibro = null, autor = null, fechaSolicitud = null, fechaEntregaEstipulada = null, estado = null, dni = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        try (BufferedReader br = new BufferedReader(new FileReader("Biblioteca Nacional de España.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	switch (line) {
                case "Nombre":
                    nombreLibro = br.readLine();
                    break;
                case "Autor":
                    autor = br.readLine();
                    break;
                case "Fecha de Solicitud":
                    fechaSolicitud = br.readLine();
                    break;
                case "Fecha de Entrega Estipulada":
                    fechaEntregaEstipulada = br.readLine();
                    break;
                case "Estado:":
                    estado = br.readLine();
                    break;
                case "DNI":
                    dni = br.readLine();
                    Libro libro = new Libro(nombreLibro, autor);
                    Usuario usuario = new Usuario("", dni);
                    prestamos.add(new Prestamo(libro, usuario, dateFormat.parse(fechaSolicitud), dateFormat.parse(fechaEntregaEstipulada)));
            	}
            	
                
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        	Date fechaHoy = new Date();
        	SimpleDateFormat formato = new SimpleDateFormat("dd_MM_yyyy");
            String fecha = formato.format(fechaHoy);
        try (PrintWriter pw = new PrintWriter(new FileWriter("inventario_y_vencimientos_" + fecha + ".txt"))) {
            
            for (Prestamo prestamo : prestamos) {
                pw.println("Nombre: " + prestamo.getLibro().getNombre());
                pw.println("Autor: " + prestamo.getLibro().getAutor());
                pw.println("Fecha de Solicitud: " + prestamo.getFechaSolicitud());
                pw.println("Fecha de Entrega Estipulada: " + prestamo.getFechaEntregaEstipulada());

                int diasAtraso = prestamo.calcularDiasAtraso();
                pw.println("Días de Atraso: " + diasAtraso);

                String estadoPrestamo = prestamo.estadoPrestamo();
                pw.println("Estado de Prestamo: " + estadoPrestamo);

                double dineroAdeudado = prestamo.calcularDineroAdeudado();
                pw.println("Dinero Adeudado: " + dineroAdeudado + " euros");

                boolean clienteMoroso = prestamo.clienteMoroso();
                pw.println("Cliente Moroso: " + (clienteMoroso ? "SI" : "NO"));

                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

