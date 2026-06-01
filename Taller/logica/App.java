package logica;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import dominio.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class App {
	public static Sistema sys = new SistemaImpl();
	public static void main(String[] args) throws IOException {
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
				sys.top3Magos();
				break;
			case "3":
				sys.mostrarHechizos();
				break;
			case "4":
				sys.mostrarMagos();
				break;
			case "5":
				sys.mostrarHechizosYpuntuacion();
				break;
			case "6":
				sys.mostrarMagosYpuntiacion();
				break;
			default:
				System.err.println("Opción invalida. Intentalo denuevo.");
				break;
			}
			System.out.println("");
		}while(!opcion.equals("0"));
	}
	
	public static void mainMenu() throws IOException {
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
				guardarTxtHechizos();
				guardarTxtMagos();
				break;
				
			default:
				System.err.println("Opción invalida. Intentalo denuevo.");
				break;
			}
			
		}while(!opcion.equals("0"));
		
	}
	
	private static void guardarTxtMagos() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
		for(Mago mago : sys.getListaMagos()) {
			String linea = mago.lineaTxt();
			
			bw.write(linea);
			bw.newLine();
		}
	}
	
	private static void guardarTxtHechizos() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt"));
		for (Hechizo hechizo : sys.getListaHechizos()) {
            String linea = hechizo.lineaTxt(); 
            
            bw.write(linea);
            bw.newLine();
        }
	}
	
	
	private static void menuAdmin() {
		Scanner scanner = new Scanner(System.in);
		String opcion = "";
		
		do {
			System.out.println("=== MENÚ DE ADMINISTRADOR ===\n");
			System.out.println("1. Agregar Mago\r\n"
					+ "2. Modificar Mago\r\n"
					+ "3. Eliminar Mago\r\n"
					+ "4. Agregar Hechizo\r\n"
					+ "5. Modificar Hechizo\r\n"
					+ "6. Eliminar Hechizo\r\n"
					+ "0. Salir");
			System.out.print("> ");
			opcion = scanner.nextLine();
			switch (opcion) {
			case "0":
				System.out.println("Saliendo del menú de Administrador. . .");
				break;
			case "1":
				agregarMago();
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
				System.err.println("Opcion invalida. Intentalo denuevo.");
				break;
			}
			
			System.out.println("");
		}while(!opcion.equals("0"));
		
		
	}
	private static void agregarMago() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== AGREGAR NUEVO MAGO ===");
		System.out.println("Ingrese nombre del nuevo mago: ");
		String nombre = scanner.nextLine();
		/*
		 * ACÁ SE ME OCURRE AGREGAR EL NOMBRE Y LA LISTA DE HECHIZOS AL ARRAYLIST DEL SISTEMA
		 * Y PEDIRLE A LA PERSONA QUE INGRESE LA CANTIDAD DE HECHIZOS QUE QUIERE TENER SU MAGO
		 * Y CUANDO LE PIDAMOS ESO, MOSTRARLE LA CANTIDAD DE HECHIZOS QUE HAY EJ(90)
		 * TIPO: ELIJA CANT DE HECHIZOS (MAX 90)
		 * Y HACER UN CONTROL DE ERROR QUE NO PUEDA ELEJIR NUMEROS NEGATIVOS NI 0 Y TAMPOCO MAYORES AL SIZE DEL ARRAYLIST
		 * DESPUES HACER UN FOR INT I (EL DE TODA LA VIDA) QUE TE VAYA PIDIENDO UNO POR UNO LOS 
		 * HECHIZOS QUE QUIERES, PERO LO HAREMOS UTILIZANDO EL ARRAYLIST DE HECHIZOS, VOY A IMPRIMIR
		 * LA LISTA DENTRO DEL FOR (LA DE MOSTRARHECHIZOS() ) Y PEDIR QUE INGRESE UN NÚMERO
		 * EJ: PONE QUE QUIERE EL HECHIZO N1 DE LA LISTA, SE LO AGREGAMOS A LA LISTA NUEVA
		 * DE HECHIZOS Y DESPUÉS DE QUE TERMINE LO AGREGAMOS A LA LISTA DEL SISTEMA Y GUARDAMOS EL ARCHIVO. LISTO
		 */
		
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
