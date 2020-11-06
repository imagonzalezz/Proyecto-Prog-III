package Datos;

public class Hotel {

	protected String nombre;
	protected String direccion;
	protected int estrellas;
	
	/**
	 * Constructor por defecto
	 */
	public Hotel() {
		super();
	}

	/**
	 * 
	 * @param nombre Nombre
	 * @param direccion Direccion
	 * @param estrellas Nº de estrellas
	 */
	public Hotel(String nombre, String direccion, int estrellas) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.estrellas = estrellas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", direccion=" + direccion + ", estrellas=" + estrellas + "]";
	}
	
	
}
