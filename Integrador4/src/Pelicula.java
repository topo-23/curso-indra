
public class Pelicula {
    private String titulo;
	private int espectadores2022;
    private int salas2022;
    private double gananciaBruta2022;
    private double gananciaNeta2022;
    
    public Pelicula(String titulo, int espectadores2022, int salas2022, double gananciaBruta2022, double gananciaNeta2022) {
        this.titulo = titulo;
        this.espectadores2022 = espectadores2022;
        this.salas2022 = salas2022;
        this.gananciaBruta2022 = gananciaBruta2022;
        this.gananciaNeta2022 = gananciaNeta2022;
        
    }
    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEspectadores2022() {
		return espectadores2022;
	}

	public void setEspectadores2022(int espectadores2022) {
		this.espectadores2022 = espectadores2022;
	}

	public int getSalas2022() {
		return salas2022;
	}

	public void setSalas2022(int salas2022) {
		this.salas2022 = salas2022;
	}

	public double getGananciaBruta2022() {
		return gananciaBruta2022;
	}

	public void setGananciaBruta2022(double gananciaBruta2022) {
		this.gananciaBruta2022 = gananciaBruta2022;
	}

	public double getGananciaNeta2022() {
		return gananciaNeta2022;
	}

	public void setGananciaNeta2022(double gananciaNeta2022) {
		this.gananciaNeta2022 = gananciaNeta2022;
	}
}