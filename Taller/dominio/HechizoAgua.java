package dominio;

public class HechizoAgua extends Hechizo {
	private int cantHeal;
	private int presionDelAgua;
	private int puntuacion;
	public HechizoAgua(String nombre, String tipo, int daño, int cantHeal, int presionDelAgua) {
		super(nombre, tipo, daño);
		this.presionDelAgua = presionDelAgua;
		this.cantHeal = cantHeal;
	}
	@Override
	public int calcularPuntuacion() {
		return puntuacion = (getDaño() + cantHeal + presionDelAgua)*2;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	@Override
	public String lineaTxt() {
		return getNombre() + ";" + getTipo() + ";" + getDaño() + ";" + this.cantHeal + "," + this.presionDelAgua;
	}
	
}
