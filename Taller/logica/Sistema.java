package logica;
import java.util.ArrayList;

import dominio.*;
public interface Sistema {
	void añadirHechizo(Hechizo hechizo);
	Hechizo buscarHechizo(String hechizo);
	void añadirMago(ArrayList<Hechizo> hechizo, String nombre);
}
