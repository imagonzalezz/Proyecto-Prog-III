package Principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.BD;
import Ventanas.Bienvenido;

public class Main {
	
	
	public static void main(String[] args) throws SQLException {
		Connection con =BD.initBD();
		BD.usarCrearTablasBD(con);
		Statement st = con.createStatement();
		BD.cerrarBD(con, st);
		new Bienvenido();
	}
	
	

}
