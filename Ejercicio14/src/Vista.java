import java.util.ArrayList;

public class Vista {
    private ControladorFinanciero controlador;

    
    public Vista(ControladorFinanciero controlador) {
        this.controlador = controlador;
    }
    
    public ControladorFinanciero getControlador() {
    	return controlador;
    }
    
    public void mostrarMenu() {
        System.out.println("¿Qué información quieres ver?");
        System.out.println("1. Stock");
        System.out.println("2. Información financiera");
    }
    
    public void mostrarInformacion(){
    	mostrarStock();
    	mostrarFinanciero();
    }
    
    
    public void mostrarStock() {
        ArrayList<Producto> stock = controlador.getProductos();

        System.out.println("----------\nInformación del Stock:");
        for (Producto producto : stock) {
            System.out.println("Detalle: " + producto.getDetalle());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Peso: " + producto.getPeso());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Unidades vendidas: " + producto.getUnidadesVendidas());
            System.out.println("Fecha de elaboración: " + producto.getFechaElaboracion());
            System.out.println("Fecha de vencimiento: " + producto.getFechaVencimiento());
            System.out.println("----------------------------------------");
        }
      }  
    
    public void mostrarFinanciero() {
    	
    	System.out.println("----------\nInformación Financiera:");
    	System.out.println("Detalle: " + controlador.getGananciaBruta());
        System.out.println("Color: " + controlador.getGananciaNeta());
        System.out.println("Peso: " + controlador.getPerdidaProyectada());
    }
    

}