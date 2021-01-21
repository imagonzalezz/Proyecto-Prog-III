package Datos;

import java.util.ArrayList;

public class Visita extends Producto {

	protected String lugarInteres;
	protected String direccion;
	protected double valoracion;
	
	/**
	 * Constructor para instanciar una visita que ya existe en la base de datos
	 * @param codigo codigo de la visita
	 * @param lugarInteres
	 * @param direccion
	 * @param valoracion
	 * @param precio
	 * @param duracion
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
	 * @param lugarInteres
	 * @param direccion
	 * @param valoracion
	 * @param precio
	 * @param duracion
	 */
	public Visita(String lugarInteres,String direccion, double valoracion, double precio, double duracion) {
		this.lugarInteres = lugarInteres;
		this.direccion = direccion;
		this.valoracion = valoracion;
		this.duracion = duracion;
		this.precio = precio;
		ArrayList<String> codigos = codigosEnAL("Visitas");
		String codigo = generarCodigo(codigos, "VI", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()+1);
		this.setCodigo(codigo);
	}

	public String getLugarInteres() {
		return lugarInteres;
	}

	public void setLugarInteres(String lugarInteres) {
		this.lugarInteres = lugarInteres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
 
	
}
