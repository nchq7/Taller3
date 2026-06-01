package dominio;
import java.util.ArrayList;
public class Mago {
	private String nombre;
	private ArrayList<Hechizo> hechizosMago;
	
	public Mago(String nombre, ArrayList<Hechizo> hechizosMago) {
		this.nombre = nombre;
		this.hechizosMago = hechizosMago;
	}
	
	public int calcularPuntuacion() {
		int puntuacion = 0;
		for (Hechizo hechizo : hechizosMago) {
			puntuacion += hechizo.calcularPuntuacion();
		}
		
		return puntuacion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String lineaTxt() {
		String linea = this.nombre + ";";
		String lineaHechizos = "";
		for(int i = 0; i < hechizosMago.size();i++) {
			lineaHechizos += hechizosMago.get(i).getNombre();
			if (i != hechizosMago.size()-1) {
				lineaHechizos += "|";
			}
		}
		return linea + lineaHechizos;
	}
	
}
