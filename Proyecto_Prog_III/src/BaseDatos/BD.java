package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Datos.Producto;
import Datos.Usuario;
import Datos.Visita;
import Datos.Vuelo;

public class BD {
	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual. Devuelve un statement para trabajar con esa base de datos
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("create table Usuarios "+
						   "(usuario string, "+
						   " contrasenya string)");
			statement.executeUpdate("create table Vuelos "+
					   "(duracion double, "+
					   "(precio double, "+
					   "(origen string, "+
					   "(destino string, "+
					   "(clase string, "+
					   " fechaYHora string)");
			statement.executeUpdate("create table Visitas "+
					   "(duracion double, "+
					   "(precio double, "+
					   "(lugarInteres string, "+
					   " valoracion double)");
			return statement;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE MËTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("drop table if exists Usuarios");
			statement.executeUpdate("drop table if exists Vuelos");
			statement.executeUpdate("drop table if exists Visitas");
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
		}
	}

	public static void anyadirUsuario(Usuario u){
		Connection con = BD.initBD("UDTravels.db");
		Statement st = null;
		try {
			st = con.createStatement();
			String query = "INSERT INTO Usuarios VALUES('"+u.getUsuario()+"','"+u.getContrasenya()+"')";
			st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
		 
	}
	
	public static void anyadirProducto(Producto p) {
		Connection con = BD.initBD("UDTravels.db");
		Statement st = null;
		Vuelo vu;
		Visita vi;
		try {
			st = con.createStatement();
			String query;
			if(p instanceof Vuelo) {
				vu = (Vuelo) p;
				query = "INSERT INTO Vuelos VALUES("+vu.getPrecio()+","+vu.getDuracion()+",'"+vu.getOrigen()+"','"+vu.getDestino()+"','"+vu.getClase()+"','"+vu.getFechaYHora()+"')";
			}
			else {
				vi = (Visita) p;
				query = "INSERT INTO Visitas VALUES("+vi.getPrecio()+","+vi.getDuracion()+",'"+vi.getLugarInteres()+"',"+vi.getValoracion()+")";
			}
			st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
	}
}
