import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestionEmpleados {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        Empleado empleado1 = crearEmpleado();
        empleados.add(empleado1);

        //Empleado empleado2 = crearEmpleado();
        //empleados.add(empleado2); 
            
        escribirArchivoJSON(empleados, "informacion_empleados.json");

    }

    private static Empleado crearEmpleado() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaIngreso = null;
        Date fechaSalida = null;

        System.out.println("Ingrese nombre del empleado:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese apellido del empleado:");
        String apellido = sc.nextLine();
        try {
		    System.out.println("Ingrese fecha de ingreso (Formato: dd-mm-yyyy):");
		    String  fechaIngresoSt = sc.nextLine();
		    fechaIngreso = dateFormat.parse(fechaIngresoSt);
		    
		    System.out.println("Ingrese fecha de salida (Formato: dd-mm-yyyy):");
		    String  fechaSalidaSt = sc.nextLine();			
			fechaSalida = dateFormat.parse(fechaSalidaSt);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

        System.out.println("Ingrese sexo:");
        String sexo = sc.nextLine();

        System.out.println("Ingrese ciudad:");
        String ciudad = sc.nextLine();

        System.out.println("Ingrese posición:");
        String posicion = sc.nextLine();

        System.out.println("Ingrese salario base:");
        double salarioBase = Double.parseDouble(sc.nextLine());
        
        return new EmpleadoMicrosoft(nombre, apellido, fechaIngreso, fechaSalida, sexo, ciudad, posicion, salarioBase);
    }
    
    private static String generarInfoJSON(Empleado empleado) {
        String infoJSON = "{";
        infoJSON += "\"nombre\": \"" + ((EmpleadoMicrosoft)empleado).getNombre() + "\", ";
        infoJSON += "\"apellido\": \"" + ((EmpleadoMicrosoft) empleado).getApellido() + "\", ";
        infoJSON += "\"fechaIngreso\": \"" + ((EmpleadoMicrosoft) empleado).getFechaIngreso() + "\", ";
        infoJSON += "\"fechaSalida\": \"" + ((EmpleadoMicrosoft) empleado).getFechaSalida() + "\", ";
        infoJSON += "\"sexo\": \"" + ((EmpleadoMicrosoft) empleado).getSexo() + "\", ";
        infoJSON += "\"ciudad\": \"" + ((EmpleadoMicrosoft) empleado).getCiudad() + "\", ";
        infoJSON += "\"posicion\": \"" + ((EmpleadoMicrosoft) empleado).getPosicion() + "\", ";
        infoJSON += "\"salarioBase\": " + ((EmpleadoMicrosoft) empleado).getSalarioBase() + "\", ";
        infoJSON += "\"salarioFinal\": " + ((EmpleadoMicrosoft) empleado).calcularSalario() + "\", ";
        infoJSON += "\"antigüedadLaboral\": " + ((EmpleadoMicrosoft) empleado).antiguedadLaboral() + " años \", ";
        infoJSON += "\"Rotación\": " + ((EmpleadoMicrosoft) empleado).rotacionRecomendada() + "}";
        
        return infoJSON;
    }
    
    private static void escribirArchivoJSON(List<Empleado> empleados, String nombreArchivo) {
        StringBuilder infoJSON = new StringBuilder("[");

        for (Empleado empleado : empleados) {
            infoJSON.append(generarInfoJSON(empleado)).append(",");
        }

        if (empleados.size() > 0) {
            infoJSON.deleteCharAt(infoJSON.length() - 1);
        }

        infoJSON.append("]");

        try (FileWriter file = new FileWriter(nombreArchivo)) {
            file.write(infoJSON.toString());
            System.out.println("Información de empleados guardada en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
