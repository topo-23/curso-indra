import java.text.ParseException;
import java.util.Date;

public class Prestamo {
    private Date fechaSolicitud;
    private Date fechaEntregaEstipulada;
    private Libro libro;
    private Usuario usuario;


    public Prestamo(Libro libro, Usuario usuario, Date fechaSolicitud, Date fechaEntregaEstipulada) throws ParseException {
        this.libro = libro;
        this.usuario = usuario;
        
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEntregaEstipulada = fechaEntregaEstipulada;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Date getFechaEntregaEstipulada() {
        return fechaEntregaEstipulada;
    }

    public int calcularDiasAtraso() {
        Date hoy = new Date();
        long diff = hoy.getTime() - fechaEntregaEstipulada.getTime();
        return (int) (diff / (24 * 60 * 60 * 1000));
    }

    public String estadoPrestamo() {
        int diasAtraso = calcularDiasAtraso();
        if (diasAtraso > 0 && diasAtraso <= 10) {
            return "EN REGLA";
        } else {
            return "VENCIDO";
        }
    }

    public double calcularDineroAdeudado() {
        int diasAtraso = calcularDiasAtraso();
        if (diasAtraso > 0) {
            return diasAtraso * 1; 
        } else {
            return 0;
        }
    }

    public boolean clienteMoroso() {
        return estadoPrestamo().equals("VENCIDO");
    }

}

