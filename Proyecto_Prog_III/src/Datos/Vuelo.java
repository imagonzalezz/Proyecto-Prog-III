package Datos;

import java.util.ArrayList;

public class Vuelo extends Producto {

	protected String origen;
	protected String destino; 
	protected String fechaYHora;
	
	/**
	 * Constructor para instanciar un vuelo que ya existe en la base de datos
	 * @param codigo codigo del vuelo
	 * @param origen ciudad de origen
	 * @param destino ciudad de destino
	 * @param fechaYHora fecha y hora en formato dd/mm/aaaa hh:mm
	 * @param duracion duracion del vuelo en minutos
	 * @param precio precio del billete
	 */
	public Vuelo(String codigo,String origen, String destino, String fechaYHora, double duracion, double precio) {
		this.origen = origen;
		this.codigoProducto = codigo;
		this.destino = destino;
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	/**
	 * Constructor para instanciar una visita que no existe en la base de datos
	 * @param origen ciudad de origen
	 * @param destino ciudad de destino
	 * @param fechaYHora fecha y hora en formato dd/mm/aaaa hh:mm
	 * @param duracion duracion del vuelo en minutos
	 * @param precio precio del billete
	 */
	public Vuelo(String origen, String destino, String fechaYHora, double duracion, double precio) {
		this.origen = origen;
		this.destino = destino;
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.precio = precio;
		ArrayList<String> codigos = codigosEnAL("Vuelos");
		String codigo = generarCodigo(codigos, "VU", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()-1);
		this.setCodigo(codigo);
	}

	/**
	 * 
	 * @return ciudad de origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * 
	 * @param origen ciudad de origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * 
	 * @return ciudad de destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * 
	 * @param destino ciudad de destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * 
	 * @return fecha y hora en formato dd/mm/aaaa hh:mm
	 */
	public String getFechaYHora() {
		return fechaYHora;
	}

	/**
	 * 
	 * @param fechaYHora fecha y hora en formato dd/mm/aaaa hh:mm
	 */
	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	
}
