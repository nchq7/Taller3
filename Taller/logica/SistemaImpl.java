package logica;

import java.util.ArrayList;
import dominio.*;

public class SistemaImpl implements Sistema {
	ArrayList<Hechizo> hechizos = new ArrayList<>();

	@Override
	public void añadirHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}
	
}
