package videojuegos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import fp.utiles.Checkers;

public class Videojuego implements Comparable<Videojuego> {
	
	//Atributos
	
	private String nombre;
	private LocalDate fechaLanzamiento;
	private Integer puntuacion500;
	private TipoPlataforma plataforma;
	private TipoGenero genero;
	private String tiendas;
	private String tags;
	private Double puntuacion10;
	private Boolean top;
	
	//Constructores
	
	public Videojuego(String nombre, LocalDate fechaLanzamiento, TipoGenero genero, Double puntuacion10, Boolean top) {
		super();
		Checkers.check("La puntuación de un juego debe ser siempre positiva", puntuacion10>=0);
		Checkers.checkNoNull(fechaLanzamiento);
		this.nombre = nombre;
		this.fechaLanzamiento = fechaLanzamiento;
		this.genero = genero;
		this.puntuacion10 = puntuacion10;
		this.top = top;
	}

	public Videojuego(String nombre, LocalDate fechaLanzamiento, Integer puntuacion500, TipoPlataforma plataforma,
			TipoGenero genero, String tiendas, String tags, Double puntuacion10, Boolean top) {
		super();
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
		this.nombre = nombre;
		this.fechaLanzamiento = fechaLanzamiento;
		this.puntuacion500 = puntuacion500;
		this.plataforma = plataforma;
		this.genero = genero;
		this.tiendas = tiendas;
		this.tags = tags;
		this.puntuacion10 = puntuacion10;
		this.top = top;
	}
	
	
		public Videojuego(String s) {
		super();
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
		
		this.nombre = nombre;
		this.fechaLanzamiento = fechaLanzamiento;
		this.puntuacion500 = puntuacion500;
		this.plataforma = plataforma;
		this.genero = genero;
		this.tiendas = tiendas;
		this.tags = tags;
		this.puntuacion10 = puntuacion10;
		this.top = top;
	}
	//Propiedades Derivadas

	public List<String> getIniciales() {
		List<String> listainiciales = new LinkedList<>();
		StringTokenizer Palabras = new StringTokenizer(nombre);
		while (Palabras.hasMoreTokens()) {
			  String iniciales = Palabras.nextToken();
			  listainiciales.add(iniciales.substring(0,1));
			}
		return listainiciales;
	}
	
	public Integer getAñoLanzamiento() {
		return fechaLanzamiento.getYear();
	}
	
	public Integer getNumeroTiendas() {
		return tiendas.split(",").length;
	}
	
	//Getters 

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public Integer getPuntuacion500() {
		return puntuacion500;
	}

	public TipoPlataforma getPlataforma() {
		return plataforma;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public String getTiendas() {
		return tiendas;
	}

	public String getTags() {
		return tags;
	}

	public Double getPuntuacion10() {
		return puntuacion10;
	}

	public Boolean getTop() {
		return top;
	}

	//Setters
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		Checkers.checkNoNull(fechaLanzamiento);
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public void setPuntuacion500(Integer puntuacion500) {;
		Checkers.check("La puntuación de valor máximo 500 debe ser proporcional a la puntuación de valor máximo 10"+ "\nError dado con la puntuacion500 = " + puntuacion500 + ", puntuacion10 = " + Math.round(puntuacion10*50),
				puntuacion500 == Math.round(puntuacion10*50));
		Checkers.check("La puntuación de un juego debe ser siempre positiva" +"\nError dado con la puntuacion500 = "+ puntuacion500, puntuacion10>=0 && puntuacion500 >= 0);
		this.puntuacion500 = puntuacion500;
	}

	public void setPlataforma(TipoPlataforma plataforma) {
		this.plataforma = plataforma;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public void setTiendas(String tiendas) {
		this.tiendas = tiendas;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setPuntuacion10(Double puntuacion10) {
		Checkers.check("La puntuación de valor máximo 500 debe ser proporcional a la puntuación de valor máximo 10"+ "\nError dado con la puntuacion500 = " + puntuacion500 + ", puntuacion10 = " + Math.round(puntuacion10*50),
				puntuacion500 == Math.round(puntuacion10*50));
		Checkers.check("La puntuación de un juego debe ser siempre positiva"+ "\nError dado con la puntuacion10 = "+ puntuacion10, puntuacion10>=0 && puntuacion500 >= 0);
		this.puntuacion10 = puntuacion10;
	}

	public void setTop(Boolean top) {
		if (top==true) {
			Checkers.check("Top solo vale true cuando la puntuación es mayor a 8.00/400" + "\nError dado con la puntuacion10 = " + puntuacion10 + ", puntuacion500 = " + puntuacion500+ ". El top vale "+top, 
					puntuacion10>=8 && puntuacion500 >= 400);
		}else { 
			Checkers.check("Top solo vale false cuando la puntuación es menor a 8.00/400" + "\nError dado con la puntuacion10 = " + puntuacion10 + ", puntuacion500 = " + puntuacion500 +". El top vale "+top, 
				puntuacion10<=8 && puntuacion500 <= 400);
		}
		this.top = top;
	}

	//Hashcode y equals 

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaLanzamiento == null) ? 0 : fechaLanzamiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		if (fechaLanzamiento == null) {
			if (other.fechaLanzamiento != null)
				return false;
		} else if (!fechaLanzamiento.equals(other.fechaLanzamiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
	}
	
	//Orden Natural 

	public int compareTo(Videojuego o) {
		int r;
		r = this.nombre.compareTo(o.getNombre());
		if (r==0) {
			r = this.fechaLanzamiento.compareTo(o.getFechaLanzamiento());
			if (r==0) {
				r = this.tags.compareTo(o.getTags());
			}
		}
		return r;
	}
	
	//ToString 

	public String toString() {
		return "El Videojuego " + "'"+nombre+"'" + ", estrenado el día " + fechaLanzamiento.getDayOfMonth() + " de " + 
				fechaLanzamiento.getMonth()+ " en el año " + fechaLanzamiento.getYear() + " tiene las siguientes carácterísticas:\n"
				+"=================================================================================\n"+
				"*Puntuación sobre 500 = "+puntuacion500 + "\n*Puntuación sobre 10 = " + puntuacion10
				+ "\n*Plataforma disponible = " + plataforma + "\n*Género del juego = " + genero
				+"\n*El juego está en el top de la aplicación = "+ top
				+ "\n=================================================================================\n" 
				+"Las tiendas en las que está disponible son las siguientes:\n" + 
				"*"+tiendas+ "\n=================================================================================\n"+
				"Los tags del juego son:\n"  + "*"+tags;
	}
	
	
	
	
	
	
	
	

}
