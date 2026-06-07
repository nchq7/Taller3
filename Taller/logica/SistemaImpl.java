package logica;

import java.util.ArrayList;
import dominio.*;

public class SistemaImpl implements Sistema {
	ArrayList<Hechizo> hechizos = new ArrayList<>();
	ArrayList<Mago> magos = new ArrayList<>();
	
	@Override
	public void añadirHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}

	@Override
	public Hechizo buscarHechizo(String hechizo) {
		for(int i = 0;i<hechizos.size();i++){
			if(hechizo.equals(hechizos.get(i).getNombre())){
				return hechizos.get(i);
			}
		}
		return null;
	}

	@Override
	public void añadirMago(ArrayList<Hechizo> hechizos, String nombre) {
		magos.add(new Mago(nombre,hechizos));
	}

	@Override
	public void top10MejoresHechizos() {
		ordenarHechizos();
		System.out.println("=== Top 10 Mejores Hechizos ===");
		for(int i = 0; i < 10;i++) {
			System.out.println(i+1 + ") " + hechizos.get(i).getNombre() + " | Puntuación: " + hechizos.get(i).getPuntuacion());
		}
	}

	@Override
	public void ordenarHechizos() {
		for(int i = 0; i < hechizos.size()-1; i++) {
			for(int j = 0;j < hechizos.size()-1-i; j++) {
				
				if (hechizos.get(j).calcularPuntuacion() < hechizos.get(j+1).calcularPuntuacion()) {
					
					Hechizo aux = hechizos.get(j);
					hechizos.set(j, hechizos.get(j+1));
					hechizos.set(j+1, aux);
				}
			}
		}
	}

	@Override
	public void ordenarMagos() {
		for(int i = 0; i < magos.size()-1; i++) {
			for(int j = 0;j < magos.size()-1-i; j++) {
				
				if (magos.get(j).calcularPuntuacion() < magos.get(j+1).calcularPuntuacion()) {
					
					Mago aux = magos.get(j);
					magos.set(j, magos.get(j+1));
					magos.set(j+1, aux);
				}
			}
		}
		
	}

	@Override
	public void top3Magos() {
		ordenarMagos();
		for(int i = 0; i < 3;i++) {
			System.out.println(i+1 + ") " + magos.get(i).getNombre() + " | Puntuacion: " + magos.get(i).calcularPuntuacion());
		}
		
	}

	@Override
	public void mostrarHechizos() {
		System.out.println("=== MOSTRANDO TODOS LOS HECHIZOS ===");
		for(int i=0; i < hechizos.size();i++) {
			System.out.println(i+1 + ") " + hechizos.get(i).getNombre());
		}
		
	}

	@Override
	public void mostrarMagos() {
		System.out.println("=== MOSTRANDO TODOS LOS MAGOS ===");
		for(int i=0; i < magos.size();i++) {
			System.out.println(i+1 + ") " + magos.get(i).getNombre());
		}
		
	}

	@Override
	public void mostrarHechizosYpuntuacion() {
		System.out.println("=== MOSTRANDO HECHIZOS Y PUNTUACION ===");
		for(int i=0; i < hechizos.size();i++) {
			System.out.println(i+1 + ") " + hechizos.get(i).getNombre() + " | Puntuacion: " + hechizos.get(i).calcularPuntuacion());
		}
		
	}

	@Override
	public void mostrarMagosYpuntiacion() {
		System.out.println("=== MOSTRANDO MAGOS Y PUNTUACION ===");
		for(int i=0; i < magos.size();i++) {
			System.out.println(i+1 + ") " + magos.get(i).getNombre() + " | Puntuacion: " + magos.get(i).calcularPuntuacion());
		}
	}

	@Override
	public ArrayList<Hechizo> getListaHechizos() {
		return hechizos;
	}

	@Override
	public ArrayList<Mago> getListaMagos() {
		return magos;
	}

	@Override
	public void modificarNombreMago(String nombre, int indice) {
		magos.get(indice).setNombre(nombre);
	}
	
	@Override
	public void eliminarMago(int indice) {
	    this.magos.remove(indice);
	}

	@Override
	public void eliminarHechizo(int indice) {
		this.hechizos.remove(indice);
	}
	
}
