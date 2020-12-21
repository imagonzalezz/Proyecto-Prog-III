package Datos;

public class Vuelo extends Producto {

	protected String origen;
	protected String destino; 
	protected String fechaYHora;
	
	
	public Vuelo(double precio, double duracion, String codigoProducto, String origen, String destino,
			String fechaYHora) {
		super(precio, duracion, codigoProducto);
		this.origen = origen;
		this.destino = destino;
		this.fechaYHora = fechaYHora;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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


	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	@Override
	public String toString() {
		return "Vuelo [origen=" + origen + ", destino=" + destino + ", fechaYHora=" + fechaYHora + "]";
	}
	
}
