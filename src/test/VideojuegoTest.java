package test;

import java.time.LocalDate;

import videojuegos.TipoGenero;
import videojuegos.TipoPlataforma;
import videojuegos.Videojuego;

public abstract class VideojuegoTest {

	public static void main(String[] args) {
		Videojuego v1 = new Videojuego("Grande Theaf Auto", LocalDate.of(2009,4,5), TipoGenero.ACTION,9.87 , true);
		Videojuego v2 = new Videojuego("Fornite", LocalDate.of(2018,5,7), 300,TipoPlataforma.PLAYSTATION_4, TipoGenero.MASSIVELY_MULTIPLAYER, "Steam, AppStore, PlayStore, Amazon Games", "Manejo fácil, Buen sistema de conexión, Rápido Enlace",6.00, false);
		Videojuego v3 = new Videojuego("Valoran", LocalDate.of(2019,1,17), 350,TipoPlataforma.PC, TipoGenero.FIGHTING, "Steam, Amazon Games", "Gratuito, Comunidad Grande",7.00, false);
		Videojuego v4 = new Videojuego("Zelda The Breath of the Wild", LocalDate.of(2018,8,22), 358,TipoPlataforma.NINTENDO_SWITCH, TipoGenero.CASUAL, "Nintendo Store", "Historia que te atrapa, Mundo abierto, Innovador",7.16, false);
		Videojuego v5 = new Videojuego("Stardew Valley", LocalDate.of(2014,12,27), 459,TipoPlataforma.PC, TipoGenero.INDIE, "Steam, Android, PlayStore, Amazon Games, Xbox Store, AppStore", "Relajante, Buena Banda Sonora, Muchas opciones para el gusto de cada uno", 9.18, true);
		Videojuego v6 = new Videojuego("Cooking Mama", LocalDate.of(2006,3,30), TipoGenero.EDUCATIONAL,10.00 , true);
		Videojuego v7 = new Videojuego("Cooking Mama", LocalDate.of(2006,3,30), TipoGenero.EDUCATIONAL,10.00 , true);
		
		//Probamos los métodos get
		//System.out.println(v1.getIniciales());
		//System.out.println(v2.getNombre());
		//System.out.println(v2.getTags());
		//System.out.println(v2.getTiendas());
		//System.out.println(v2.getFechaLanzamiento());
		//System.out.println(v2.getGenero());
		//System.out.println(v2.getPlataforma());
		//System.out.println(v2.getPuntuacion10());
		//System.out.println(v2.getPuntuacion500());
		//System.out.println(v2.getTop());
		//System.out.println(v5.getNumeroTiendas());
		
		//Probamos los métodos set
		//v3.setNombre("Valorant");
		//v3.setFechaLanzamiento(LocalDate.of(2018, 1, 17));
		//v3.setPuntuacion500(450);
		//v3.setPlataforma(TipoPlataforma.LINUX);
		//v3.setGenero(TipoGenero.SHOOTER);
		//v3.setPuntuacion10(9.00);
		//v3.setTiendas("Valorant Store");
		//v3.setTags("Gratuito, Adictivo");
		//v3.setTop(true);
		
		//Vemos si saltan las restricciones 
		//v4.setPuntuacion10(5.67);
		//v6.setTop(false);
		//v6.setFechaLanzamiento(null);
		//v4.setPuntuacion500(-3);
		
		//Utilizamos el equals primero en dos iguales y despues en diferente
		//System.out.println(v6.equals(v7));
		//System.out.println(v4.equals(v5));
		
		//Revisamos si se cumple el orden natural
		//System.out.println(v5.compareTo(v2));
		
		//Usamos el formato cadena 
		//System.out.println(v5.toString());
		

	}

}
