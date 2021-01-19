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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodigoComprado() {
		return codigoComprado;
	}

	public void setCodigoComprado(String codigoComprado) {
		this.codigoComprado = codigoComprado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
