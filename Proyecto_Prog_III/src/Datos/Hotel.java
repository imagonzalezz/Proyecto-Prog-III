package Datos;

public class Hotel {

	protected String codigo;
	protected String nombre;
	protected String ciudad;
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
	 * @param estrellas Número de estrellas
	 */
	public Hotel(String nombre, String ciudad, int estrellas) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estrellas = estrellas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setDireccion(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", ciudad=" + ciudad + ", estrellas=" + estrellas + "]";
	}
	
	
}
