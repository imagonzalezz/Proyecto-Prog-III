package Datos;

import java.util.Date;

public class CompraOferta {

	protected Oferta oferta;
	protected int numAdultos;
	protected int numMenores;
	protected TipoReserva tipoReserva;
	protected Date fechaEntrada;
	protected Date fechaSalida;
	
	public CompraOferta() {
		super();
	}

	public CompraOferta(Oferta oferta, int numAdultos, int numMenores, TipoReserva tipoReserva, Date fechaEntrada,
			Date fechaSalida) {
		super();
		this.oferta = oferta;
		this.numAdultos = numAdultos;
		this.numMenores = numMenores;
		this.tipoReserva = tipoReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public int getNumAdultos() {
		return numAdultos;
	}

	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}

	public int getNumMenores() {
		return numMenores;
	}

	public void setNumMenores(int numMenores) {
		this.numMenores = numMenores;
	}

	public TipoReserva getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(TipoReserva tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "CompraOferta [oferta=" + oferta + ", numAdultos=" + numAdultos + ", numMenores=" + numMenores
				+ ", tipoReserva=" + tipoReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ "]";
	}

	
	
}
