package Datos;

public class Visita extends Producto {

	protected String lugarInteres;
	protected double valoracion;
	
	public Visita(double precio, double duracion, String codigoProducto, String lugarInteres, double valoracion) {
		super(precio, duracion, codigoProducto);
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
