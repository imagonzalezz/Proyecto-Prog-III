package Datos;

public class CompraProducto extends Compra implements TienePrecio {
	
	protected int cantidad;

	public CompraProducto(Usuario usuario, String codigoComprado, int cantidad) {
		super(usuario, codigoComprado);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public double calcPrecio() {
		
	}
	
	
}
