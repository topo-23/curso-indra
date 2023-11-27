
public class HiloVista implements Runnable {
    private Vista vista;
    private ControladorFinanciero controlador;

    @Override
    public void run() {
        //vista.mostrarMenu();
    	vista.mostrarInformacion();
    }


    public HiloVista(Vista vista) {
        this.controlador = vista.getControlador();
        this.vista = vista;
    }

    public void mostrarInformacionFinanciera() {
        System.out.println("Información Financiera:");

        if (controlador.getGananciaBruta() == 0) {
            controlador.calcularInformacionFinanciera();
        }

        System.out.println("Ganancia Bruta: " + controlador.getGananciaBruta());
        System.out.println("Ganancia Neta: " + controlador.getGananciaNeta());
        System.out.println("Pérdida Proyectada: " + controlador.getPerdidaProyectada());
    }
}
