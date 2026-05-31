package dominio;

public class HechizoFuego extends Hechizo {
	private int duracionQuemadura;
	private int puntuacion;
	public HechizoFuego(String nombre, String tipo, int daño, int duracionQuemadura) {
		super(nombre, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}
	@Override
	public int calcularPuntuacion() {
		return puntuacion = getDaño()*duracionQuemadura;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
}
