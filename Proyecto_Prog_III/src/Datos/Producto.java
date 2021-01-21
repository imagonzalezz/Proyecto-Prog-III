package Datos;

public abstract class Producto extends TieneCod {

	protected double precio;
	protected double duracion;
	protected String codigoProducto;

	/**
	 * 
	 * @return precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * 
	 * @return duracion de la visita o tiempo de vuelo
	 */
	public double getDuracion() {
		return duracion;
	}

	/**
	 * 
	 * @param duracion duracion de la visita o tiempo de vuelo
	 */
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	/**
	 * 
	 * @return codigo del producto
	 */
	public String getCodigo() {
		return codigoProducto;
	}

	/**
	 * 
	 * @param codigo codigo del producto
	 */
	public void setCodigo(String codigo) {
		this.codigoProducto = codigo;
	}
	
}
