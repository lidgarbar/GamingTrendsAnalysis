package test;

import java.time.LocalDate;

import videojuegos.FactoriaVideojuegos;
import videojuegos.TipoGenero;
import videojuegos.TipoPlataforma;
import videojuegos.Videojuego;
import videojuegos.Videojuegos;


public class VideojuegosTest {
	//Cargamos los datos del fichero
	static Videojuegos videojuegos = FactoriaVideojuegos.leerVideojuegos("data/Proyecto Videojuegos CSV.csv");
	
	//Creamos objetos para el constructor 
	private static Videojuego v1 = new Videojuego("Fornite", LocalDate.of(2018,5,7), 300,TipoPlataforma.PLAYSTATION_4, TipoGenero.MASSIVELY_MULTIPLAYER, "Steam, AppStore, PlayStore, Amazon Games", "Manejo fácil, Buen sistema de conexión, Rápido Enlace",6.00, false);
	private static Videojuego v2 = new Videojuego("Valorant", LocalDate.of(2019,1,17), 350,TipoPlataforma.PC, TipoGenero.FIGHTING, "Steam, Amazon Games", "[Gratuito, Comunidad Grande`]",7.00, false);
	private static Videojuego v3 = new Videojuego("Zelda The Breath of the Wild", LocalDate.of(2018,8,22), 358,TipoPlataforma.NINTENDO_SWITCH, TipoGenero.CASUAL, "Nintendo Store", "[Historia que te atrapa, Mundo abierto, Innovador]",7.16, false);
	private static Videojuego v4 = new Videojuego("Stardew Valley", LocalDate.of(2014,12,27), 459,TipoPlataforma.PC, TipoGenero.INDIE, "Steam, Android, PlayStore, Amazon Games, Xbox Store, AppStore", "[Relajante, Buena Banda Sonora, Muchas opciones para el gusto de cada uno]", 9.18, true);
	

	public static void main(String[] args) {
//		testConstructor();
		
//		testCalcularNumeroVideojuegosIntervalo();
//		testVerdaderoSegunIntervaloyPuntuacion();
//		testNumeroVideojuegosTopConInicial();
//		testlistaVideojuegosConTienda();
//		testVerdaderoSegunInicialTopVideojuegos();
//		testVerVideojuegoTag();
		
//		testEliminaTag();
//		testGetMediaVideojuegosPorGenero();
//		testGetPrimerosVideojuegosPlataforma();
//		testIndexadoPoNumeroIniciales();
//		testPlataformaMenosFrecuentePorGenero();
//		testMediaPuntuacionesPorGeneroAño();
//		testVideojuegoMayorPuntuacionPorMes();
//		testVideojuegoMasTiendas();
	}

	
	//Probamos el método añadirVideojuegos
	private static void testConstructor() {
		System.out.println("\nTEST del Constructor del contenedor");
		try {
			videojuegos.añadirVideojuego(v1);
			videojuegos.añadirVideojuego(v2);
			videojuegos.añadirVideojuego(v3);
			videojuegos.añadirVideojuego(v4);

			System.out.println(videojuegos + "\n");
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	//Probamos los métodos secuenciales 1
	private static void testCalcularNumeroVideojuegosIntervalo() {
		System.out.println("\nTEST de calcularNumeroVideojuegosIntervalo");
		try {
			System.out.println("VIDEOJUEGOS EN EL INTERVALO: " +  videojuegos.calcularNumeroVideojuegosIntervalo(LocalDate.of(2001,12,3), LocalDate.of(2016,10,10)));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e );	
		}
	}
	
	private static void testVerdaderoSegunIntervaloyPuntuacion(){
		System.out.println("\nTEST de verdaderoSegunIntervaloyPuntuacion");
		try {
			System.out.println("¿SE CUMPLE?: " + videojuegos.verdaderoSegunIntervaloyPuntuacion(LocalDate.of(1999,2,3), LocalDate.of(2006,1,10), 3 ));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testNumeroVideojuegosTopConInicial(){
		System.out.println("\nTEST de numeroVideojuegosTopConInicial");
		try {
			System.out.println("VIDEOJUEGOS TOP CON INICIAL: " + videojuegos.numeroVideojuegosTopConInicial("G"));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testlistaVideojuegosConTienda(){
		System.out.println("\nTEST de listaVideojuegosConTienda");
		try {
			System.out.println("VIDEOJUEGOS CON LA TIENDA: " + videojuegos.listaVideojuegosConTienda("Steam"));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}

	private static void testVerdaderoSegunInicialTopVideojuegos(){
		System.out.println("\nTEST de verdaderoSegunInicialMejoresVideojuegos");
		try {
			System.out.println("VIDEOJUEGOS VERDADEROS POR LA INICIAL: " + videojuegos.verdaderoSegunInicialTopVideojuegos("O", "A", "E", 1));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testVerVideojuegoTag(){
		System.out.println("\nTEST de verVideojuegoTag");
		try {
			System.out.println("VIDEOJUEGO CON EL TAG: \n" + videojuegos.verVideojuegoTag("'Steam Achievements'"));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}

	//Probamos los Métodos Secuenciales 2 
	private static void testEliminaTag() {
		System.out.println("\nTEST de eliminaTag");
		try {
			System.out.println("ELIMINADO EL TAG EN: " );
			videojuegos.eliminaTag("'City Builder'");
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e );	
		}
	}
	
	private static void testGetMediaVideojuegosPorGenero() {
		System.out.println("\nTEST de getMediaVideojuegosPorGenero");
		try {
			System.out.println("MEDIA VIDEOJUEGOS POR GENERO: " +  videojuegos.getMediaVideojuegosPorGenero());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e );	
		}
	}
	
	private static void testGetPrimerosVideojuegosPlataforma() {
		System.out.println("\nTEST de getPrimerosVideojuego");
		try {
			System.out.println("PRIMEROS VIDEOJUEGOS: " + videojuegos.getPrimerosVideojuegosPlataforma(2, TipoPlataforma.ANDROID));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testIndexadoPoNumeroIniciales() {
		System.out.println("\nTEST de indexadoPorNumeroIniciales");
		try {
			System.out.println("VIDEOJUEGOS POR NUMERO INICIALES: " + videojuegos.indexadoPorNumeroIniciales());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testPlataformaMenosFrecuentePorGenero() {
		System.out.println("\nTEST de plataformaMenosFrecuentePorGenero");
		try {
			System.out.println("PLATAFORMA MENOS FRECUENTE: " + videojuegos.plataformaMenosFrecuentePorGenero(TipoGenero.PLATFORMER));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testMediaPuntuacionesPorGeneroAño(){
		System.out.println("\nTEST de mediaPuntuacionesPorGeneroAño");
		try {
			System.out.println("MEDIA DE: " + videojuegos.mediaPuntuacionesPorGeneroAño(TipoGenero.FAMILY));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testVideojuegoMayorPuntuacionPorMes(){
		System.out.println("\nTEST de videojuegoMayorPuntuacionPorMes");
		try {
			System.out.println("MEJORES VIDEOJUEGOS POR MES: " + videojuegos.videojuegoMayorPuntuacionPorMes());
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
	
	private static void testVideojuegoMasTiendas(){
		System.out.println("\nTEST de videojuegoMasTiendas");
		try {
			System.out.println("VIDEOJUEGO CON MAS TIENDAS: " + videojuegos.videojuegoMasTiendas("'Atmospheric'"));
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e);	
		}
	}
}
	

	
