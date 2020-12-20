package Datos;

import java.util.Date;

public class Oferta {
	
	protected Hotel hotel;
	protected double precioPorAdulto;
	protected double precioPorMenor;
	
	
	public Oferta() {
		super();
	}


	public Oferta(Hotel hotel, double precioPorAdulto, double precioPorMenor) {
		super();
		this.hotel = hotel;
		this.precioPorAdulto = precioPorAdulto;
		this.precioPorMenor = precioPorMenor;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		return "Oferta [hotel=" + hotel + ", precioPorAdulto=" + precioPorAdulto + ", precioPorMenor=" + precioPorMenor
				+ "]";
	}
	
	

}