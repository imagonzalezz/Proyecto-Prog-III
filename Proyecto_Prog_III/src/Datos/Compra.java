package Datos;

public abstract class Compra {
	
	protected Usuario usuario;
	protected String codigoComprado;
	protected double precio;
	
	public Compra(Usuario usuario, String codigoComprado) {
		super();
		this.usuario = usuario;
		this.codigoComprado = codigoComprado;
	}

	/**
	 * 
	 * @return usuario que ha hecho la compra
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario usuario que ha hecho la compra
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 * @return codigo de lo que se ha comprado
	 */
	public String getCodigoComprado() {
		return codigoComprado;
	}

	/**
	 * 
	 * @param codigoComprado codigo de lo que se ha comprado
	 */
	public void setCodigoComprado(String codigoComprado) {
		this.codigoComprado = codigoComprado;
	}

	/**
	 * 
	 * @return precio de la compra
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio precio de la compra
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
