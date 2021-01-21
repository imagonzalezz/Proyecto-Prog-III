package Datos;

import java.util.ArrayList;

public class Visita extends Producto {

	protected String lugarInteres;
	protected String direccion;
	protected double valoracion;
	
	/**
	 * Constructor para instanciar una visita que ya existe en la base de datos
	 * @param codigo codigo de la visita
	 * @param lugarInteres nombre del lugar de interes
	 * @param direccion ciudad en la que se ubica
	 * @param valoracion valoracion sobre 5
	 * @param precio precio de cada visita
	 * @param duracion duracion de la visita en minutos
	 */
	public Visita(String codigo,String lugarInteres,String direccion, double valoracion, double precio, double duracion) {
		this.lugarInteres = lugarInteres;
		this.codigoProducto = codigo;
		this.direccion = direccion;
		this.valoracion = valoracion;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	/**
	 * Constructor para instanciar un usuario que no existe en la base de datos
	 * @param lugarInteres nombre del lugar de interes
	 * @param direccion ciudad en la que se ubica
	 * @param valoracion valoracion sobre 5
	 * @param precio precio de cada visita
	 * @param duracion duracion de la visita en minutos
	 */
	public Visita(String lugarInteres,String direccion, double valoracion, double precio, double duracion) {
		this.lugarInteres = lugarInteres;
		this.direccion = direccion;
		this.valoracion = valoracion;
		this.duracion = duracion;
		this.precio = precio;
		ArrayList<String> codigos = codigosEnAL("Visitas");
		String codigo = generarCodigo(codigos, "VI", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()-1);
		this.setCodigo(codigo);
	}

	/**
	 * 
	 * @return nombre del lugar de interes
	 */
	public String getLugarInteres() {
		return lugarInteres;
	}

	/**
	 * 
	 * @param lugarInteres nombre del lugar de interes
	 */
	public void setLugarInteres(String lugarInteres) {
		this.lugarInteres = lugarInteres;
	}

	/**
	 * 
	 * @return ciudad en la que se ubica
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param direccion ciudad en la que se ubica
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return valoracion sobre 5
	 */
	public double getValoracion() {
		return valoracion;
	}

	/**
	 * 
	 * @param valoracion valoracion sobre 5
	 */
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
 
	
}
