
public class HiloFinanciero implements Runnable {
    private ControladorFinanciero controlador;

    public HiloFinanciero(ControladorFinanciero controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {
        controlador.calcularInformacionFinanciera();
    }

}