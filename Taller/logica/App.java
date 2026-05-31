package logica;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import dominio.*;
public class App {
	public static Sistema sys = new SistemaImpl();
	public static void main(String[] args) throws FileNotFoundException {
		cargarHechizos();
		cargarMagos();
		mainMenu();
	}
	public static void menuAnalista() {
		Scanner scanner = new Scanner(System.in);
		String opcion = "";
		do {
			System.out.println("=== MENÚ DE ANALISIS ===");
			System.out.println("\n1. Top 10 Mejores Hechizos\r\n"
					+ "2. Top 3 Mejores Magos\r\n"
					+ "3. Mostrar todos los Hechizos\r\n"
					+ "4. Mostrar todos los magos\r\n"
					+ "5. Mostrar todos los Hechizos junto a su puntuacion\r\n"
					+ "6. Mostrar todos los magos junto a su puntuacion\r\n"
					+ "0. Salir");
			System.out.print("> ");
			opcion = scanner.nextLine();
			switch (opcion) {
			case "0":
				System.out.println("Saliendo del menú de Analisis. . .");
				break;
			case "1":
				sys.top10MejoresHechizos();
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			default:
				System.err.println("Opción invalida. Intentalo denuevo.");
				break;
			}
		}while(!opcion.equals("0"));

	}
	
	public static void mainMenu() {
		Scanner scanner = new Scanner(System.in);
		String opcion = "";
		do {
			System.out.println("Bienvenido!");
			System.out.println("Que deseas hacer?");
			System.out.println("1) Acceder a Panel de Administrador");
			System.out.println("2) Acceder a Panel de Analista");
			System.out.println("0) Salir");
			System.out.print("> ");
			opcion = scanner.nextLine();
			switch (opcion) {
			case "1":
				menuAdmin();
				break;
			case "2":
				menuAnalista();
				break;
			
			case "0":
				System.out.println("Hasta luego!");
				break;
				
			default:
				System.err.println("Opción invalida. Intentalo denuevo.");
				break;
			}
			
		}while(!opcion.equals("0"));
		
	}
	
	private static void menuAdmin() {
		
		
	}
	public static void cargarHechizos() throws FileNotFoundException {
		File archivo = new File("Hechizos.txt");
		Scanner lector = new Scanner(archivo);
		
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String tipo = partes[1];
			int daño = Integer.parseInt(partes[2]);
			
			switch (tipo) {
			case "Fuego":
				int duracion = Integer.parseInt(partes[3]);
				Hechizo hechizoFuego = new HechizoFuego(nombre,tipo,daño,duracion);
				sys.añadirHechizo(hechizoFuego);
				break;
			case "Tierra":
				int mejoraDefensa = Integer.parseInt(partes[3]);
				Hechizo hechizoTierra = new HechizoTierra(nombre,tipo,daño,mejoraDefensa);
				sys.añadirHechizo(hechizoTierra);
				break;
			case "Planta":
				String separar = partes[3];
				String[] partesPlanta = separar.split(",");
				int duracionStun = Integer.parseInt(partesPlanta[0]);
				int cantPlantas = Integer.parseInt(partesPlanta[1]);
				Hechizo hechizoPlanta = new HechizoPlanta(nombre,tipo,daño,duracionStun,cantPlantas);
				sys.añadirHechizo(hechizoPlanta);
				break;
			case "Agua":
				String[] partesAgua = partes[3].split(",");
				int cantHeal = Integer.parseInt(partesAgua[0]);
				int presionDelAgua = Integer.parseInt(partesAgua[1]);
				Hechizo hechizoAgua = new HechizoAgua(nombre,tipo,daño,cantHeal,presionDelAgua);
				sys.añadirHechizo(hechizoAgua);
				break;
			}

			
			
		}
		
	}
	
	public static void cargarMagos() throws FileNotFoundException{
		File archivo = new File("Magos.txt");
		Scanner lector = new Scanner(archivo);
		
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombreMago = partes[0];
			
			
			String[] hechizos = partes[1].split("\\|"); 
			ArrayList<Hechizo> hechizosMago = new ArrayList<>();
			
			for (String hechizo : hechizos) {
				hechizosMago.add(sys.buscarHechizo(hechizo));
			}
			sys.añadirMago(hechizosMago, nombreMago);
		}
		
	}
	
}
