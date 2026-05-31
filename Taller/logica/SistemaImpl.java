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
	
}
