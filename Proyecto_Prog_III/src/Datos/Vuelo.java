package Datos;

import java.util.ArrayList;

public class Vuelo extends Producto {

	protected String origen;
	protected String destino; 
	protected String fechaYHora;
	
	public Vuelo(String codigo,String origen, String destino, String fechaYHora, double duracion, double precio) {
		this.origen = origen;
		this.codigoProducto = codigo;
		this.destino = destino;
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public Vuelo(String origen, String destino, String fechaYHora, double duracion, double precio) {
		this.origen = origen;
		this.destino = destino;
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.precio = precio;
		ArrayList<String> codigos = codigosEnAL("Vuelos");
		String codigo = generarCodigo(codigos, "VU", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()+1);
		this.setCodigo(codigo);
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

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	
}
