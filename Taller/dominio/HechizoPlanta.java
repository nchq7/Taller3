package dominio;

public class HechizoPlanta extends Hechizo {
	private int duracionStun;
	private int cantPlantas;
	private int puntuacion;
	public HechizoPlanta(String nombre, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombre, tipo, daño);
		this.cantPlantas = cantPlantas;
		this.duracionStun = duracionStun;
	}
	@Override
	public int calcularPuntuacion() {
		return puntuacion = getDaño()+(duracionStun*cantPlantas);
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
}
