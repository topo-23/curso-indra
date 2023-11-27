import java.util.ArrayList;

public class ControladorFinanciero {

    private ArrayList<Producto> productos;
    private double gananciaBruta;
    private double gananciaNeta;
    private double perdidaProyectada;

    public ControladorFinanciero() {
        this.productos = new ArrayList<>();
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public ArrayList<Producto> getProductos() {
		return productos;
	}

    public void calcularInformacionFinanciera() {
        calcularGananciaBruta();
        calcularGananciaNeta();
        calcularPerdidaProyectada();
    }

    private void calcularGananciaBruta() {
        gananciaBruta = 0;
        for (Producto producto : productos) {
            gananciaBruta += producto.getPrecio() * producto.getUnidadesVendidas();
        }
    }

    private void calcularGananciaNeta() {
        gananciaNeta = gananciaBruta * 0.83;
    }

    private void calcularPerdidaProyectada() {
        perdidaProyectada = gananciaNeta / 12;
    }

    public double getGananciaBruta() {
        return gananciaBruta;
    }

    public double getGananciaNeta() {
        return gananciaNeta;
    }

    public double getPerdidaProyectada() {
        return perdidaProyectada;
    }
}
