import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControlCalidadEmpleados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del empleado:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la posición del empleado:");
        String posicion = sc.nextLine();

        System.out.println("Ingrese el sueldo del empleado:");
        double sueldo = sc.nextDouble();

        System.out.println("Ingrese el horario de ingreso del empleado (formato 24h):");
        int horarioIngreso = sc.nextInt();

        double porcentajeDescuento = verificarInfraccion(posicion, horarioIngreso);

        String resultado = "";
        if (porcentajeDescuento > 0) {
            double descuento = sueldo * porcentajeDescuento;
            resultado = nombre + " tiene una infracción de horario. Se le descuenta un " + (porcentajeDescuento * 100) + "% de su sueldo, equivalente a " + descuento + "€";
            System.out.println(resultado);
        } else {
            System.out.println(nombre + " no tiene infracción de horario.");
        }
      
        escribirEnArchivo(resultado);
        
        
    }

    public static double verificarInfraccion(String posicion, int horarioIngreso) {
        double porcentajeDescuento = 0;

        switch (posicion.toLowerCase()) {
            case "ceo":
                if (horarioIngreso != 7) {
                    porcentajeDescuento = 0.01;
                }
                break;
            case "jefe":
                if (horarioIngreso != 8) {
                    porcentajeDescuento = 0.05;
                }
                break;
            case "ingeniero":
                if (horarioIngreso != 9) {
                    porcentajeDescuento = 0.15;
                }
                break;
            case "analista":
                if (horarioIngreso != 9) {
                    porcentajeDescuento = 0.20;
                }
                break;
            case "scrum master":
                if (horarioIngreso != 9) {
                    porcentajeDescuento = 0.10;
                }
                break;
            case "rrhh":
                if (horarioIngreso != 9) {
                    porcentajeDescuento = 0.09;
                }
                break;
            default:
                System.out.println("Posición ingresada no válida.");
        }

        return porcentajeDescuento;
    }
    
    public static void escribirEnArchivo(String resultado) {
        try {
            FileWriter fileWriter = new FileWriter("empleados_con_infracciones.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(resultado);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
