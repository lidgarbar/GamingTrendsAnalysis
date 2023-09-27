package videojuegos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.utiles.Checkers;



public class FactoriaVideojuegos {
	
	//Métodos estáticos
	public static Videojuegos leerVideojuegos(String nombreFichero) {
		Videojuegos res = new Videojuegos();
		try {
			List<String> líneas = Files.readAllLines(Paths.get(nombreFichero));
			líneas.remove(0); // Nos saltamos la línea de cabecera
			for (String línea : líneas) { // for(int i=1;i<líneas.size();i++)
				res.añadirVideojuego(new Videojuego(línea));// uso del constructor a partir de String
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static Videojuegos leerVideojuegosConParseo(String nombreFichero) {
		Videojuegos res = new Videojuegos();
		try {
			List<String> líneas = Files.readAllLines(Paths.get(nombreFichero));
			líneas.remove(0); // Nos saltamos la línea de cabecera
			for (String línea : líneas) { 
				res.añadirVideojuego(parsearVideojuego(línea));// uso del metodo parseo a partir de String
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static Videojuego parsearVideojuego(String s) {
		String[] campos = s.split(";");
		Checkers.check("La línea debe tener 9 campos", campos.length == 9);
		
		String nombre = campos[0].trim();
		//Tenemos que hacer más operaciones para parsear el atributo fecha de Str a LocalDate
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String strfechaLanzamiento = campos[1].trim();
		LocalDate fechaLanzamiento = LocalDate.parse(strfechaLanzamiento, formatter);
		
		Integer puntuacion500 = Integer.valueOf(campos[2].trim()); 
		TipoPlataforma plataforma = TipoPlataforma.valueOf(campos[3].trim());
		TipoGenero genero = TipoGenero.valueOf(campos[4].trim());
		String tiendas = campos[5].trim();
		String tags = campos[6].trim();
		String puntuacion=campos[7].replace(",", ".");
		Double puntuacion10 = Double.valueOf(puntuacion);
		Boolean top = Boolean.valueOf(campos[8].trim());
		
		//Todos los checkers de los atributos
		if (top==true) {
			Checkers.check("Top solo vale true cuando la puntuación es mayor a 8.00/400" + "\nError dado con la puntuacion10 = " + puntuacion10 + ", puntuacion500 = " + puntuacion500+ ". El top vale "+top, 
					puntuacion10>=8 && puntuacion500 >= 400);
		}else { 
			Checkers.check("Top solo vale false cuando la puntuación es menor a 8.00/400" + "\nError dado con la puntuacion10 = " + puntuacion10 + ", puntuacion500 = " + puntuacion500 +". El top vale "+top, 
				puntuacion10<=8 && puntuacion500 <= 400);
		}
		Checkers.checkNoNull(fechaLanzamiento);
		Checkers.check("La puntuación de valor máximo 500 debe ser proporcional a la puntuación de valor máximo 10"+ "\nError dado con la puntuacion500 = " + puntuacion500 + ", puntuacion10 = " + Math.round(puntuacion10*50),
				puntuacion500 == Math.round(puntuacion10*50));
		
		return new Videojuego(nombre, fechaLanzamiento, puntuacion500, plataforma, genero,tiendas,tags,puntuacion10,top);
		
	}
	

}
