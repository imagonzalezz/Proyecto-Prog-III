package Datos;

import java.util.ArrayList;
import java.util.Date;

public class Oferta extends TieneCod{
	
	protected String codigo;
	protected String codigoHotel;
	protected double precioPorAdulto;
	protected double precioPorMenor;
	
	public Oferta(String codigoHotel, double precioPorAdulto, double precioPorMenor) {
		super();
		this.codigoHotel = codigoHotel;
		this.precioPorAdulto = precioPorAdulto;
		this.precioPorMenor = precioPorMenor;
		ArrayList<String> codigos = codigosEnAL("Ofertas");
		String codigo = generarCodigo(codigos, "OF", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()+1);
		this.setCodigo(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(String codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public double getPrecioPorAdulto() {
		return precioPorAdulto;
	}

	public void setPrecioPorAdulto(double precioPorAdulto) {
		this.precioPorAdulto = precioPorAdulto;
	}

	public double getPrecioPorMenor() {
		return precioPorMenor;
	}

	public void setPrecioPorMenor(double precioPorMenor) {
		this.precioPorMenor = precioPorMenor;
	}

	@Override
	public String toString() {
		return "Oferta [codigo=" + codigo + ", codigoHotel=" + codigoHotel + ", precioPorAdulto=" + precioPorAdulto
				+ ", precioPorMenor=" + precioPorMenor + "]";
	}
	
	
}