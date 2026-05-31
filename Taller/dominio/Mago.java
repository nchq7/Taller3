package dominio;
import java.util.ArrayList;
public class Mago {
	private String nombre;
	private ArrayList<Hechizo> hechizosMago;
	public Mago(String nombre, ArrayList<Hechizo> hechizosMago) {
		this.nombre = nombre;
		this.hechizosMago = hechizosMago;
	}
	
}
