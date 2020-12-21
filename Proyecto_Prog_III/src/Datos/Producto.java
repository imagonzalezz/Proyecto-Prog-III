package Datos;

public abstract class Producto {

	protected double precio;
	protected double duracion;
	protected String codigoProducto;

	public Producto(double precio, double duracion, String codigoProducto) {
		super();
		this.precio = precio;
		this.duracion = duracion;
		this.codigoProducto = codigoProducto;
	}

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

	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", duracion=" + duracion + ", codigo=" + codigoProducto + "]";
	}
	
}
