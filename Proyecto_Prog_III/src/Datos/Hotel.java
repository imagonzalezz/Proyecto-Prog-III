package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BaseDatos.BD;

public class Hotel implements TieneCodigo{

	protected String codigo;
	protected String nombre;
	protected String ciudad;
	protected int estrellas;
	
	/**
	 * Constructor por defecto
	 */
	public Hotel() {
		super();
	}

	/**
	 * 
	 * @param nombre Nombre
	 * @param direccion Direccion
	 * @param estrellas Número de estrellas
	 */
	public Hotel(String nombre, String ciudad, int estrellas) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estrellas = estrellas;
		ArrayList<String> codigos = codigosEnAL();
		String cod = "HO" + (int) Math.floor(Math.random()*(9999-1000+1)+1000);
		generarCodigo(codigos, cod, codigos.size()+1);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setDireccion(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", ciudad=" + ciudad + ", estrellas=" + estrellas + "]";
	}
	
	@Override
	public ArrayList<String> codigosEnAL() {
		ArrayList<String> codigos = new ArrayList<>();
		Connection con = BD.initBD();
		Statement st = null;
		String query = "SELECT codigo FROM Hoteles";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
				codigos.add(rs.getString("codigo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BD.cerrarBD(con, st);
		}
		return codigos;
	}
	
	@Override
	public void generarCodigo(ArrayList<String> codigos, String cod, int indice) {
		if(indice<0)
			this.setCodigo(cod);
		else {
			if(cod != codigos.get(indice))
				generarCodigo(codigos, cod, indice-1);
			else{
				
			}
		}
	}
}
