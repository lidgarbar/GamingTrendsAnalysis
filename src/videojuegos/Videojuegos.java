package videojuegos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Videojuegos {
	
	//Atributo
	private SortedSet<Videojuego> videojuegos;

	//Constructor vacio
	public Videojuegos() {
		videojuegos = new TreeSet<Videojuego>();
	}
	
	//Getter
	public String get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//M�todo a�adir objeto
	public void a�adirVideojuego(Videojuego videojuego) {
		this.videojuegos.add(videojuego);
	}
	
	//ToString
	public String toString() {
		String s = "VIDEOJUEGOS:\n";
		for (Videojuego v : videojuegos) {
			s += v + "\n";
		}
		return s;
	}

	//M�todos secuenciales 1 (terminado)
	public Long calcularNumeroVideojuegosIntervalo(LocalDate a�o1, LocalDate a�o2) {
		return videojuegos.stream()
				.filter(x->x.getFechaLanzamiento().isAfter(a�o1) && x.getFechaLanzamiento().isBefore(a�o2))
				.map(Videojuego::getNombre)
				.distinct()
				.count();
	}
	
	public Boolean verdaderoSegunIntervaloyPuntuacion(LocalDate a�o1, LocalDate a�o2, Integer puntuacion) {
		return videojuegos.stream()
				.anyMatch(x-> x.getPuntuacion500()>puntuacion &&
						x.getFechaLanzamiento().isAfter(a�o1) &&
						x.getFechaLanzamiento().isBefore(a�o2));
	}
	
	public Long numeroVideojuegosTopConInicial(String A) {
		return videojuegos.stream()
				.filter(x->x.getTop().equals(true))
				.filter(x->x.getIniciales().get(0).equals(A))
				.count();
	}
	
	public List<String> listaVideojuegosConTienda(String tienda) {
		return videojuegos.stream()
				.filter(x->x.getTiendas().contains(tienda))
				.map(x->x.getNombre())
				.distinct()
				.collect(Collectors.toList());
	}
	
	public Boolean verdaderoSegunInicialTopVideojuegos(String letra1, String letra2, String letra3,Integer n) {
		return videojuegos.stream()
				.filter(x->x.getTop().equals(true))
				.limit(n)
				.anyMatch(x->x.getIniciales().contains(letra1) || x.getIniciales().contains(letra2) || x.getIniciales().contains(letra3));
	}
	
	public Videojuego verVideojuegoTag(String tag) {
		return videojuegos.stream()
				.filter(x-> x.getTags().contains(tag))
				.findAny()
				.get();
	}
	
	//M�todos Secuenciales 2 
	public void eliminaTag(String tag) {
		videojuegos.stream()
		.filter(x->x.getTags().contains(tag))
		.peek(x->x.getTags().replace(tag, " "))
		.forEach(x->System.out.println(x.getNombre()));
	}
	
	public Map<TipoGenero, Double> getMediaVideojuegosPorGenero(){			
		return videojuegos.stream()
				.collect(Collectors.groupingBy(Videojuego::getGenero, Collectors.averagingInt(Videojuego::getPuntuacion500)));
	}
	
	public List<String> getPrimerosVideojuegosPlataforma(Integer n, TipoPlataforma plataforma){
		Comparator<Videojuego> comparadorpuntuacion=Comparator.comparing(Videojuego::getPuntuacion10);
		return videojuegos.stream()
				.filter(x->x.getPlataforma().equals(plataforma))
				.sorted(comparadorpuntuacion.reversed())
				.limit(n)
				.map(x->x.getNombre())
				.collect(Collectors.toList());
	}
	
	public SortedMap<Integer, Long> indexadoPorNumeroIniciales(){					
		return videojuegos.stream()
				.collect(Collectors.groupingBy(x->x.getIniciales().size(),TreeMap::new,Collectors.counting()));
	}
	
	
	public TipoPlataforma plataformaMenosFrecuentePorGenero(TipoGenero genero) {
		return videojuegos.stream()
				.filter(x->x.getGenero().equals(genero))
				.collect(Collectors.groupingBy(Videojuego::getPlataforma, Collectors.counting()))
				.entrySet().stream()
				.min(Comparator.comparing(x->x.getValue()))
				.get()
				.getKey();
	}
	
	public Map<Integer, Double> mediaPuntuacionesPorGeneroA�o(TipoGenero genero){
		return videojuegos.stream()
				.filter(x-> x.getGenero().equals(genero))
				.collect(Collectors.groupingBy(Videojuego::getA�oLanzamiento,Collectors.averagingDouble(Videojuego::getPuntuacion10)));
	}
	
	public Map<Month, String> videojuegoMayorPuntuacionPorMes() {
		return videojuegos.stream()
				.collect(Collectors.groupingBy(x->x.getFechaLanzamiento().getMonth()))
				.entrySet().stream()	
				.collect(Collectors.toMap(x-> x.getKey(), 
						x->Collections.max(x.getValue(), Comparator.comparing(Videojuego::getPuntuacion10)).getNombre()));
	}
	
	public String videojuegoMasTiendas(String tag) {
		return videojuegos.stream()
				.filter(x->x.getTags().contains(tag))
				.collect(Collectors.groupingBy(Videojuego::getNombre))
				.entrySet().stream()
				.collect(Collectors.toMap(x-> x.getKey(), 
						x->Collections.max(x.getValue(), Comparator.comparing(Videojuego::getNumeroTiendas)).getTiendas()))
				.entrySet().stream()
				.max(Comparator.comparing(x->x.getValue()))
				.get()
				.getKey();
	}




	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
