package Datos;

public class Vuelo extends Producto {

	protected String origen;
	protected String destino; 
	protected ClaseVuelo clase;
	protected String companyia;
	
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
	 * @param companyia Compañia aérea
	 */
	public Vuelo(double precio, double duracion, String origen, String destino, ClaseVuelo clase,
			String companyia) {
		super(precio, duracion);
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.clase = clase;
		this.companyia = companyia;
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

	public ClaseVuelo getClase() {
		return clase;
	}

	public void setClase(ClaseVuelo clase) {
		this.clase = clase;
	}

	public String getCompanyia() {
		return companyia;
	}

	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}

	@Override
	public String toString() {
		return "Vuelo [origen=" + origen + ", destino=" + destino + ", precio=" + precio + ", minsDuracion="
				+ duracion + ", clase=" + clase + ", companyia=" + companyia + "]";
	}
	
	

	
	
	
	
}
