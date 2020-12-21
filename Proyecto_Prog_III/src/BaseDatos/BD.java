package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Datos.Oferta;
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
						   "(contrasenya string, "+
						   " correo string)");
			statement.executeUpdate("create table Vuelos "+
					   "(codigo string, "+
					   "origen string, "+
					   "destino string, "+
					   "fechaYHora string, "+
					   "precio double, "+
					   "duracion double)");
			statement.executeUpdate("create table ComprasVuelos "+
					   "(codigo string, "+
					   "usuario string, "+
					   "fechaYHora string, "+
					   "cantidad int)");
			statement.executeUpdate("create table Visitas "+
					   "(codigo string, "+
					   "lugarInteres string, "+
					   "valoracion double, "+
					   "precio double, "+
					   "duracion double)");
			statement.executeUpdate("create table ComprasVisitas "+
					   "(codigo string, "+
					   "usuario string, "+
					   "fechaYHora string, "+
					   "cantidad int)");
			statement.executeUpdate("create table Ofertas "+
					   "(codigo string, "+
					   "(codigoHotel string, "+
					   "(precioPorAdulto double, "+
					   " precioPorMenor double)");
			statement.executeUpdate("create table ComprasOfertas "+
					   "(codigo string, "+
					   "usuario string, "+
					   "fechaYHora string, "+
					   "fechaEntrada string, "+
					   "fechaSalida string, "+
					   "numAdultos int, "+
					   "numMenores int)");
			statement.executeUpdate("create table Hoteles "+
					   "(codigo string, "+
					   "direccion string, "+
					   "estrellas int)");
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
			st.executeUpdate(query);
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
				query = "INSERT INTO Vuelos VALUES('"+vu.getOrigen()+"','"+vu.getDestino()+"',"+vu.getDuracion()+"',"+vu.getPrecio()+"','"+vu.getFechaYHora()+"')";
			}
			else {
				vi = (Visita) p;
				query = "INSERT INTO Visitas VALUES('"+vi.getLugarInteres()+"',"+vi.getDuracion()+"',"+vi.getPrecio()+"',"+vi.getValoracion()+")";
			}
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
	}
	
	public void anyadirOferta(Oferta o) {
		Connection con = BD.initBD("UDTravels.db");
		Statement st = null;
		String query;
		try {
			st = con.createStatement();
			query = "INSERT INTO Ofertas VALUES('"+o.getHotel().getNombre()+"',"+o.getPrecioPorAdulto()+","+o.getPrecioPorMenor()+")";
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
	}
}
