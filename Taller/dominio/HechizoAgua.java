package dominio;

public class HechizoAgua extends Hechizo {
	private int cantHeal;
	private int presionDelAgua;
	public HechizoAgua(String nombre, String tipo, int daño, int cantHeal, int presionDelAgua) {
		super(nombre, tipo, daño);
		this.presionDelAgua = presionDelAgua;
		this.cantHeal = cantHeal;
	}

}
