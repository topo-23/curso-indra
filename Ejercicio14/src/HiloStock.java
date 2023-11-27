import java.util.ArrayList;
import java.util.Scanner;

public class HiloStock implements Runnable {
	private ArrayList<Producto> stock;
    private ControladorFinanciero controlador;
    private Scanner sc;

    public HiloStock(ControladorFinanciero controlador) {
    	this.controlador = controlador;
        stock = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    @Override
    public void run() {
    	System.out.println("Ingreso de información de stock para al menos 5 productos:");
        for (int i = 0; i < 2; i++) {
            Producto producto = new Producto();

            System.out.println("Producto " + (i + 1));
            System.out.print("Detalle: ");
            producto.setDetalle(sc.nextLine());

            System.out.print("Color: ");
            producto.setColor(sc.nextLine());

            System.out.print("Peso: ");
            producto.setPeso(Double.parseDouble(sc.nextLine()));

            System.out.print("Precio: ");
            producto.setPrecio(Double.parseDouble(sc.nextLine()));

            System.out.print("Unidades vendidas: ");
            producto.setUnidadesVendidas(Integer.parseInt(sc.nextLine()));

            System.out.print("Fecha de elaboración: ");
            producto.setFechaElaboracion(sc.nextLine());

            System.out.print("Fecha de vencimiento: ");
            producto.setFechaVencimiento(sc.nextLine());

            stock.add(producto);
        }

        controlador.setProductos(stock);
    }
}