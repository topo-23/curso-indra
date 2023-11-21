
public class Ciudad {
    String nombre;
    int habitantes;
    double superficie;

    public Ciudad(String nombre, int habitantes, double superficie) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.superficie = superficie;
    }

    public double calcularProyeccionHabitantes() {
        return habitantes * 0.90;
    }

    public double calcularSuperficieOcupada() {
        return superficie + 10000;
    }
}
