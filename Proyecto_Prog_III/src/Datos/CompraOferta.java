package Datos;

public class CompraOferta extends Compra {

	protected int numAdultos;
	protected int numMenores;
	protected String fechaEntrada;
	protected String fechaSalida;
	
	public CompraOferta(Usuario usuario, String codigoProducto, String fechaYHoraCompra, double precio) {
		super(usuario, codigoProducto, fechaYHoraCompra, precio);
	}

	public CompraOferta(Usuario usuario, String codigoProducto, String fechaYHoraCompra, double precio, int numAdultos,
			int numMenores, String fechaEntrada, String fechaSalida) {
		super(usuario, codigoProducto, fechaYHoraCompra, precio);
		this.numAdultos = numAdultos;
		this.numMenores = numMenores;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
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

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "CompraOferta [numAdultos=" + numAdultos + ", numMenores=" + numMenores + ", fechaEntrada="
				+ fechaEntrada + ", fechaSalida=" + fechaSalida + "]";
	}

	
	
}
