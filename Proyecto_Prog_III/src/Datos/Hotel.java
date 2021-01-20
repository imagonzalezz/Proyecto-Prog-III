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
		ArrayList<String> codigos = codigosEnAL("Hoteles");
		String codigo = generarCodigo(codigos, "HO", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()+1);
		this.setCodigo(codigo);
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
		return "Hotel [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", estrellas=" + estrellas
				+ "]";
	}

}
