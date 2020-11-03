package Datos;

public class Producto {

	protected double precio;
	protected double duracion;

	/**
	 * Constructor por defecto
	 */
	public Producto() {
		super();
	}

	/**
	 * 
	 * @param precio Precio del producto
	 */
	public Producto(double precio, double duracion) {
		super();
		this.precio = precio;
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + "]";
	}
	
	
	
	
	
}
