package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BaseDatos.BD;

public abstract class TieneCod {

	/**
	 * 
	 * @param tabla tabla de la base de datos de la que se quiera conocer los codigos
	 * @return ArrayList con todos los codigos que haya en la base de datos
	 */
	public ArrayList<String> codigosEnAL(String tabla){
		/*ArrayList<String> codigos = new ArrayList<>();
		Connection con = BD.initBD();
		Statement st = null;
		String query = "SELECT codigo FROM " + tabla;
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
		}*/
		ArrayList<String> codigos = BD.obtenerCodigos(tabla);
		return codigos;
		
	}
	
	/**
	 * genera un codigo para almacenarlo en la base de datos
	 * @param codigos ArrayList de codigos existentes en la base de datos
	 * @param prefijo prefijo para el codigo
	 * @param cod numero para el codigo
	 * @param indice indice con el que se itera en el ArrayList
	 * @return
	 */
	public String generarCodigo(ArrayList<String> codigos, String prefijo, int cod, int indice) {
		if(indice<0)
			return prefijo + cod;
		else {
			if(!(prefijo+cod).equals(codigos.get(indice)))
				return generarCodigo(codigos,prefijo,cod,indice-1);
			else{
				return generarCodigo(codigos,prefijo,(int) Math.floor(Math.random()*(9999-1000+1)+1000),codigos.size());
			}
		}
	}
	
}
