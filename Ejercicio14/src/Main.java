
public class Main {
    public static void main(String[] args) {

    	ControladorFinanciero controlador = new ControladorFinanciero();
    	Vista vista = new Vista(controlador);
    	
    	Thread hiloStock = new Thread(new HiloStock(controlador));
        Thread hiloFinanciero = new Thread(new HiloFinanciero(controlador));
        Thread hiloVista = new Thread(new HiloVista(vista));

        hiloStock.start();
        try {
			hiloStock.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        hiloFinanciero.start();
        try {
			hiloFinanciero.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        hiloVista.start();      
    }
}