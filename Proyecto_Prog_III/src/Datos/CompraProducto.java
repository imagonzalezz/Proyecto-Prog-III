package Datos;

public class CompraProducto {

	protected Producto producto;
	protected int cantidad;
	
	public CompraProducto() {
		super();
	}

	public CompraProducto(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "CompraProducto [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
