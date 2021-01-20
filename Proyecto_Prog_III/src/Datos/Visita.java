package Datos;

import java.util.ArrayList;

public class Visita extends Producto {

	protected String lugarInteres;
	protected String ciudad;
	protected double valoracion;
	
	public Visita(String lugarInteres,String ciudad, double valoracion, double duracion, double precio) {
		this.lugarInteres = lugarInteres;
		this.ciudad = ciudad;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
 
	
}
