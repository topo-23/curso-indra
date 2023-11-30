
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese nombre: ");
        String nombre = reader.readLine();

        System.out.print("Ingrese apellido: ");
        String apellido = reader.readLine();

        System.out.print("Ingrese ciudad: ");
        String ciudad = reader.readLine();

        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(reader.readLine());

        System.out.println("Información del usuario:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Edad: " + edad);

        reader.close();
    }
}
