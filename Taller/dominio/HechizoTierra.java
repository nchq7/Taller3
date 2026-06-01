package dominio;

public class HechizoTierra extends Hechizo {
	private int mejoraDefensa;
	private int puntuacion;
	public HechizoTierra(String nombre, String tipo, int daño, int mejoraDefensa) {
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}
	@Override
	public int calcularPuntuacion() {
		return puntuacion = (getDaño()*mejoraDefensa)/2;
		
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	@Override
	public String lineaTxt() {
		return getNombre() + ";" + getTipo() + ";" + getDaño() + ";" + this.mejoraDefensa;
	}
	
	
	
}
