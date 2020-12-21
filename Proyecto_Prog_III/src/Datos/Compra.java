package Datos;

public abstract class Compra {
	
	protected Usuario usuario;
	protected String codigoComprado;
	protected String fechaYHoraCompra;
	protected double precio;
	
	
	public Compra(Usuario usuario, String codigoProducto, String fechaYHoraCompra, double precio) {
		super();
		this.usuario = usuario;
		this.codigoComprado = codigoProducto;
		this.fechaYHoraCompra = fechaYHoraCompra;
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaYHoraCompra() {
		return fechaYHoraCompra;
	}

	public void setFechaYHoraCompra(String fechaYHoraCompra) {
		this.fechaYHoraCompra = fechaYHoraCompra;
	}

	public String getCodigo() {
		return codigoComprado;
	}

	public void setCodigo(String codigo) {
		this.codigoComprado = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Compra [usuario=" + usuario + ", fechaYHoraCompra=" + fechaYHoraCompra + ", codigo=" + codigoComprado
				+ ", precio=" + precio + "]";
	}
	
	

}
