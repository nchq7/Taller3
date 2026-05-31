package logica;
import java.util.ArrayList;

import dominio.*;
public interface Sistema {
	void añadirHechizo(Hechizo hechizo);
	Hechizo buscarHechizo(String hechizo);
	void añadirMago(ArrayList<Hechizo> hechizo, String nombre);
	void top10MejoresHechizos();
	void ordenarHechizos();
	void ordenarMagos();
	void top3Magos();
	void mostrarHechizos();
	void mostrarMagos();
	void mostrarHechizosYpuntuacion();
	void mostrarMagosYpuntiacion();


}
