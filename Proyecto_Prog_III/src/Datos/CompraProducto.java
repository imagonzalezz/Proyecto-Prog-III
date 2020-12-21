package Datos;

public class CompraProducto extends Compra {
	
	protected int cantidad;
	
	public CompraProducto(Usuario usuario, String codigoProducto, String fechaYHoraCompra, double precio) {
		super(usuario, codigoProducto, fechaYHoraCompra, precio);
		// TODO Auto-generated constructor stub
	}

	public CompraProducto(Usuario usuario, String codigoProducto, String fechaYHoraCompra, double precio,
			int cantidad) {
		super(usuario, codigoProducto, fechaYHoraCompra, precio);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
