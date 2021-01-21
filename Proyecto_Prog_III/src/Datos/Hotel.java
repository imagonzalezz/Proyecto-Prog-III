package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BaseDatos.BD;

public class Hotel extends TieneCod{

	protected String codigo;
	protected String nombre;
	protected String ciudad;
	protected int estrellas;


	/**
	 * Constructor para hacer una instancia de un hotel que ya esta en la base de datos
	 * @param codigo codigo del hotel
	 * @param nombre nombre del hotel
	 * @param ciudad ciudad en la que se ubica
	 * @param estrellas numero de estrellas del hotel
	 */
	public Hotel(String codigo,String nombre, String ciudad, int estrellas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estrellas = estrellas;
	}
	
	/**
	 * Constructor para hacer una instancia de un hotel que no esta en la base de datos
	 * @param nombre nombre del hotel
	 * @param direccion ciudad en la que se ubica
	 * @param estrellas numero de estrellas del hotel
	 */
	public Hotel(String nombre, String ciudad, int estrellas) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estrellas = estrellas;
		ArrayList<String> codigos = codigosEnAL("Hoteles");
		String codigo = generarCodigo(codigos, "HO", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()-1);
		this.setCodigo(codigo);
	}

	/**
	 * 
	 * @return nombre del hotel
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre nombre del hotel
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return ciudad en la que se ubica
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * 
	 * @param ciudad ciudad en la que se ubica
	 */
	public void setDireccion(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * 
	 * @return numero de estrellas del hotel
	 */
	public int getEstrellas() {
		return estrellas;
	}

	/**
	 * 
	 * @param estrellas numero de estrellas del hotel
	 */
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	/**
	 * 
	 * @return codigo del hotel
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo codigo del hotel
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Hotel [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", estrellas=" + estrellas
				+ "]";
	}

}
