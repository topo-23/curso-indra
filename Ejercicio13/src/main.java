import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el nombre de la ciudad:");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el número de habitantes:");
            int habitantes = Integer.parseInt(sc.nextLine());

            System.out.println("Ingrese la superficie:");
            double superficie = Double.parseDouble(sc.nextLine());

            Ciudad ciudad = new Ciudad(nombre, habitantes, superficie);

            Thread generarDirectorio = new Thread(new GenerarDirectorio());
            Thread imprimirArchivo = new Thread(new ImprimirArchivo(ciudad));

            generarDirectorio.start();
            imprimirArchivo.start();
        }

        sc.close();
    }
}