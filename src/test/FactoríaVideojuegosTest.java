package test;

import videojuegos.FactoriaVideojuegos;
import videojuegos.Videojuegos;

public class FactoríaVideojuegosTest {
	public static void main(String[] args) {
		testCreacionVideojuegos1();
		testCreacionVideojuegos2();
	}
	
	
	//Probamos el leerVideojuegosConParseo  
	public static void  testCreacionVideojuegos1(){
			System.out.println("\nTEST de la creacion de videojuegos con leerVideojuegosConParseo");
			try {
				Videojuegos videojuegos = FactoriaVideojuegos.leerVideojuegosConParseo("data/Proyecto Videojuegos CSV.csv");
				for(int i=20;i<40;i++) {	
				
					System.out.println("\n\nVIDEOJUEGO " +i+": "+ videojuegos.get(i));	
				}
			} catch(Exception e) {
				System.out.println("Excepción capturada:\n   " + e );	
			}
		}

	//Probamos el leerVideojuegos
	public static void  testCreacionVideojuegos2(){
		System.out.println("\nTEST de la creacion de videojuegos con leerVideojuegos");
		try {
			Videojuegos videojuegos = FactoriaVideojuegos.leerVideojuegos("data/Proyecto Videojuegos CSV.csv");
			for(int i=60;i<70;i++) {	
			
				System.out.println("\n\nVIDEOJUEGO " +i+": "+ videojuegos.get(i));	
			}
		} catch(Exception e) {
			System.out.println("Excepción capturada:\n   " + e );	
		}
	}
	
}
