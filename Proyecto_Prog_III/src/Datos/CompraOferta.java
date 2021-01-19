package Datos;

public class CompraOferta extends Compra {

	protected int numAdultos;
	protected int numMenores;
	protected int numDias;
	public CompraOferta(Usuario usuario, String codigoComprado, int numAdultos, int numMenores, int numDias) {
		super(usuario, codigoComprado);
		this.numAdultos = numAdultos;
		this.numMenores = numMenores;
		this.numDias = numDias;
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
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	
}
