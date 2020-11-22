package Datos;

public class Vuelo extends Producto {

	protected String origen;
	protected String destino; 
	protected ClaseVuelo clase;
	protected String fechaYHora;
	
	/**
	 * Constructor por defecto
	 */
	public Vuelo() {
		super();
	}

	/**
	 * 
	 * @param origen Ciudad de origen
	 * @param destino Ciudad de destino
	 * @param precio Precio del vuelo
	 * @param duracion Duración del vuelo en minutos
	 * @param clase Tipo de clase: VIP, BUSINESS o PASSENGER
	 */
	public Vuelo(double precio, double duracion, String origen, String destino, ClaseVuelo clase, String fechaYHora) {
		super(precio, duracion);
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.clase = clase;
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

	public String getClase() {
		if(this.clase == ClaseVuelo.BUSINESS)
			return "Business";
		else if(this.clase == ClaseVuelo.PASSENGER)
			return "Passenger";
		else
			return "Vip";
	}

	public void setClase(ClaseVuelo clase) {
		this.clase = clase;
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	@Override
	public String toString() {
		return "Vuelo [origen=" + origen + ", destino=" + destino + ", clase=" + clase + ", fechaYHora=" + fechaYHora
				+ "]";
	}

	
	

	
	
	
	
}
