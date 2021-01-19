package Datos;

import java.util.Date;

public class Oferta {
	
	protected String codigo;
	protected String codigoHotel;
	protected double precioPorAdulto;
	protected double precioPorMenor;
	
	public Oferta(String codigoHotel, double precioPorAdulto, double precioPorMenor) {
		super();
		this.codigoHotel = codigoHotel;
		this.precioPorAdulto = precioPorAdulto;
		this.precioPorMenor = precioPorMenor;
	}
	
	
	
}