import java.io.FileWriter;
import java.io.IOException;

public class Main {

	 public static void main(String[] args) {
		 Pelicula[] peliculas = {
				new Pelicula("Avatar", 100000, 10000, 1000000000, 800000000),
	            new Pelicula("Avengers: Endgame", 90000, 9000, 810000000, 648000000),
	            new Pelicula("Avatar: The Way of Water", 80000, 8000, 640000000, 512000000),
	            new Pelicula("Titanic", 70000, 7000, 490000000, 392000000),
	            new Pelicula("Star Wars: Episode VII - The Force Awakens", 60000, 6000, 360000000, 288000000),
	            new Pelicula("Avengers: Infinity War", 50000, 5000, 250000000, 200000000),
	            new Pelicula("Spider-Man: No Way Home", 40000, 4000, 160000000, 128000000),
	            new Pelicula("Jurassic World", 30000, 3000, 90000000, 72000000),
	            new Pelicula("The Lion King", 20000, 2000, 40000000, 32000000),
	            new Pelicula("The Avengers", 10000, 1000, 10000000, 8000000)
		  };
		 

		 StringBuilder resultado = new StringBuilder();
		 for (Pelicula pelicula : peliculas) {			 
		        resultado.append(proyectarEstimados2023(pelicula));  
	        }
		 
		 generarJenkinsfile(resultado.toString());
	    }
	 
	    public static String proyectarEstimados2023(Pelicula pelicula) {
	        int espectadores2023 = pelicula.getEspectadores2022() / 2;
	        int salas2023 = pelicula.getSalas2022() / 2;
	        double gananciaBruta2023 = pelicula.getGananciaBruta2022() / 2;
	        double gananciaNeta2023 = gananciaBruta2023 * 0.80;

	        String proyeccion2023 = "Proyeccion para " + pelicula.getTitulo() + " en 2023:\n" +
                    "Espectadores estimados en 2023: " + espectadores2023 + "\n" +
                    "Salas estimadas en 2023: " + salas2023 + "\n" +
                    "Ganancia Bruta estimada en 2023: " + gananciaBruta2023 + "\n" +
                    "Ganancia Neta estimada en 2023: " + gananciaNeta2023 + "\n\n";

	       return proyeccion2023;
	    }
	    
	    public static void generarJenkinsfile(String resultado) {
	        String contenidoJenkins = 
	            "pipeline {\n" +
	            "    agent any\n\n" +
	            "    stages {\n" +
	            "        stage('Proyeccion 2023') {\n" +
	            "            steps {\n" +
//	            "                script {\n" +
	            "                    echo \"Proyeccion de peliculas para 2023:\"\n" + resultado +
	           // "                    sh 'javac Pelicula.java'\n" +
	            //"                    sh 'java Pelicula'\n" +
//	            "                }\n" +
	            "            }\n" +
	            "        }\n" +
	            "    }\n\n" +
	            "}\n";

	        try {
	            FileWriter writer = new FileWriter("Jenkinsfile");
	            writer.write(contenidoJenkins);
	            writer.close();
	            System.out.println("Se ha generado exitosamente el Jenkinsfile");
	        } catch (IOException e) {
	            System.out.println("Hubo un error al generar el Jenkinsfile: " + e.getMessage());
	        }
	    }
	    
	    
}
