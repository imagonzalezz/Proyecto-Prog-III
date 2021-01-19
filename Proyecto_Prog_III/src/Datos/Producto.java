package Datos;

public abstract class Producto extends TieneCod {

	protected double precio;
	protected double duracion;
	protected String codigoProducto;

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getCodigo() {
		return codigoProducto;
	}

	public void setCodigo(String codigo) {
		this.codigoProducto = codigo;
	}
	
}
