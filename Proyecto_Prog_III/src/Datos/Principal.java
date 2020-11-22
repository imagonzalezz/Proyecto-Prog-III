package Datos;

import java.sql.Connection;
import java.sql.Statement;

import BaseDatos.BD;

public class Principal {

	public static void main(String[] args) {
		Connection con = BD.initBD("UDTravels.db");
		Statement st = BD.usarCrearTablasBD(con);
		BD.cerrarBD(con, st);
	}
}
