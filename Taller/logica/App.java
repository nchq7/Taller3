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
	// Ignacio Valdivia 22.179.357-9 ICCI
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
		bw.close();
	}
	
	private static void guardarTxtHechizos() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt"));
		for (Hechizo hechizo : sys.getListaHechizos()) {
            String linea = hechizo.lineaTxt(); 
            
            bw.write(linea);
            bw.newLine();
        }
		bw.close();
	}
	
	
	private static void menuAdmin() throws IOException {
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
				guardarTxtMagos();
				break;
			case "2":
				modificarMago();
				guardarTxtMagos();
				break;
			case "3":
				eliminarMago();
				guardarTxtMagos();
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
	private static void eliminarMago() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("=== ELIMINAR MAGO ===");
	    int indice = 0;
	    
	    do {
	        sys.mostrarMagos();
	        System.out.println("Elija el número del mago que desea eliminar: ");
	        System.out.print("> ");
	        if(scanner.hasNextInt()) {
	            indice = scanner.nextInt();
	            if(indice <= 0 || indice > sys.getListaMagos().size()) {
	                System.err.println("Error. Elija un número válido.");
	            }
	        } else {
	            System.err.println("Error. Elija un NÚMERO.");
	            scanner.next();
	            indice = -1;
	        }
	    } while(indice <= 0 || indice > sys.getListaMagos().size());
	    
	    scanner.nextLine(); 
	    
	    String nombreMagoBorrado = sys.getListaMagos().get(indice - 1).getNombre();
	    
	    sys.eliminarMago(indice - 1);
	    
	    System.out.println("¡El mago " + nombreMagoBorrado + " ha sido eliminado con éxito!");
		
	}
	private static void modificarMago() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== MODIFICAR MAGO ===");
		int indice = 0;
		
		do {
			sys.mostrarMagos();
			System.out.println("Elija su mago a modificar: ");
			System.out.print("> ");
			if(scanner.hasNextInt()) {
				
				indice = scanner.nextInt();
				if(indice <= 0 || indice > sys.getListaMagos().size()) {
					System.err.println("Error. Elija un número válido.");
				}
				
			}else {
				System.err.println("Error. Elija un NÚMERO.");
				scanner.next();
				indice = -1;
			}
			
		}while(indice <= 0 || indice > sys.getListaMagos().size());
		scanner.nextLine();
		String opcion = "";
		do {
			System.out.println("Que deseas hacer?");
			System.out.println("1. Modificar nombre de mago\n2. Modificar hechizo de mago\n0. Salir");
			System.out.print("> ");
			opcion = scanner.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Ingrese el nuevo nombre");
				System.out.print("> ");
				String nombre = scanner.nextLine();
				sys.modificarNombreMago(nombre, indice-1);
				System.out.println("Nombre modificado con exito!");
				break;
			case "2":
				
				Mago magoSeleccionado = sys.getListaMagos().get(indice - 1);
				
				System.out.println("\n--- HECHIZOS ACTUALES DE " + magoSeleccionado.getNombre() + " ---");
				
				for (int i = 0; i < magoSeleccionado.getHechizosMago().size(); i++) {
					System.out.println((i + 1) + ") " + magoSeleccionado.getHechizosMago().get(i).getNombre());
				}
				
				int hechizoAQuitar = 0;
				do {
					System.out.println("Elija el número del hechizo que desea REEMPLAZAR:");
					System.out.print("> ");
					if (scanner.hasNextInt()) {
						hechizoAQuitar = scanner.nextInt();
						if (hechizoAQuitar <= 0 || hechizoAQuitar > magoSeleccionado.getHechizosMago().size()) {
							System.err.println("Error. Elija un número válido de la lista.");
						}
					} else {
						System.err.println("Error. Ingrese un número.");
						scanner.next();
						hechizoAQuitar = -1;
					}
				} while (hechizoAQuitar <= 0 || hechizoAQuitar > magoSeleccionado.getHechizosMago().size());
				
				
				System.out.println("\n--- LISTA GLOBAL DE HECHIZOS DISPONIBLES ---");
				sys.mostrarHechizos(); 
				
				
				int nuevoHechizoIndice = 0;
				do {
					System.out.println("Elija el número del NUEVO hechizo que aprenderá el mago:");
					System.out.print("> ");
					if (scanner.hasNextInt()) {
						nuevoHechizoIndice = scanner.nextInt();
						if (nuevoHechizoIndice <= 0 || nuevoHechizoIndice > sys.getListaHechizos().size()) {
							System.err.println("Error. Elija un número válido.");
						}
					} else {
						System.err.println("Error. Ingrese un número.");
						scanner.next();
						nuevoHechizoIndice = -1;
					}
				} while (nuevoHechizoIndice <= 0 || nuevoHechizoIndice > sys.getListaHechizos().size());
				
				scanner.nextLine(); 
				
				Hechizo hechizoNuevo = sys.getListaHechizos().get(nuevoHechizoIndice - 1);
				magoSeleccionado.getHechizosMago().set(hechizoAQuitar - 1, hechizoNuevo);
				
				System.out.println("¡Hechizo modificado con éxito!");
				break;
			case "0":
				System.out.println("Hasta luego crack");
				break;
			default:
				System.err.println("Ingresa una opción válida.");
				break;
			}
		}while(!opcion.equals("0"));
	}
	
	private static void agregarMago() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== AGREGAR NUEVO MAGO ===");
		System.out.println("Ingrese nombre del nuevo mago: ");
		System.out.print("> ");
		String nombre = scanner.nextLine();
		
		int cantidadHechizos = 0;
		do {
			System.out.println("Elija cantidad de hechizos para su mago (MAX: " + sys.getListaHechizos().size() + ")");
			System.out.print("> ");
			if(scanner.hasNextInt()) {
				
				cantidadHechizos = scanner.nextInt();
				if(cantidadHechizos <= 0 || cantidadHechizos > sys.getListaHechizos().size()) {
					System.err.println("Error. Elija un número válido.");
				}
				
			}else {
				System.err.println("Error. Elija un NÚMERO.");
				scanner.next();
				cantidadHechizos = -1;
			}
			
		}while(cantidadHechizos <= 0 || cantidadHechizos > sys.getListaHechizos().size());
		ArrayList<Hechizo> hechizosTemp = new ArrayList<>();
		for(int i = 0; i < cantidadHechizos;i++) {
			int indice = 0;
			sys.mostrarHechizos();
			
			do {
				System.out.println("Elija el número del hechizo que quiere para su mago");
				System.out.print("> ");
				if(scanner.hasNextInt()) {
					
					indice = scanner.nextInt();
					if(indice <= 0 || indice > sys.getListaHechizos().size()) {
						System.err.println("Error. Elija un número válido.");
					}
					
				}else {
					System.err.println("Error. Elija un NÚMERO.");
					scanner.next();
					indice = -1;
				}
				
			}while(indice <= 0 || indice > sys.getListaHechizos().size());
			
			hechizosTemp.add(sys.getListaHechizos().get(indice-1));
			System.out.println("HECHIZO AGREGADO CON EXITO. \n");
		}
		scanner.nextLine();
		System.out.println("Carga de hechizos para el mago " + nombre + " finalizado.");
		System.out.println("Mago agregado exitosamente!");
		sys.añadirMago(hechizosTemp, nombre);
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
