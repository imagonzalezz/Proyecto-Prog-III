package Datos;

public class Visita extends Producto {

	protected String lugarInteres;
	protected double valoracion;
	
	public Visita() {
		super();
	}

	/**
	 * 
	 * @param precio Precio de la visita
	 * @param duracion Duración de la visita (minutos)
	 * @param lugarInteres Nombre del lugar de interes (por ejemplo, un museo)
	 * @param valoracion Valoración del lugar
	 */
	public Visita(double precio, double duracion, String lugarInteres, double valoracion) {
		super(precio, duracion);
		this.lugarInteres = lugarInteres;
		this.valoracion = valoracion;
	}

	public String getLugarInteres() {
		return lugarInteres;
	}

	public void setLugarInteres(String lugarInteres) {
		this.lugarInteres = lugarInteres;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Visita [lugarInteres=" + lugarInteres + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
}
