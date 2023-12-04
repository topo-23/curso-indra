import java.time.LocalDate;
import java.util.Date;

public class EmpleadoMicrosoft implements Empleado {
    private String nombre;
    private String apellido;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String sexo;
    private String ciudad;
    private String posicion;
    private double salarioBase;

	public EmpleadoMicrosoft(String nombre, String apellido, Date fechaIngreso, Date fechaSalida,
            String sexo, String ciudad, String posicion, double salarioBase) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.posicion = posicion;
		this.salarioBase = salarioBase;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase * 0.83;
    }

    @Override
    public boolean rotacionRecomendada() {
        int antiguedad = antiguedadLaboral();
        return posicion.equals("Ingeniero") && antiguedad >= 2;
    }

    @Override
    public int antiguedadLaboral() {
        long diff = fechaSalida.getTime() - fechaIngreso.getTime();
        return (int) (diff / (365 * 24 * 60 * 60 * 1000));
    }
    public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public String getSexo() {
		return sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPosicion() {
		return posicion;
	}

	public double getSalarioBase() {
		return salarioBase;
	}
}
