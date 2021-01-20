package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Datos.Hotel;
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
	
	public static Connection initBD() {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + "UDTravels.db" );
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
						   " contrasenya string, "+
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
					   "cantidad int)");
			statement.executeUpdate("create table Visitas "+
					   "(codigo string, "+
					   "lugarInteres string, "+
					   "direccion string, "+
					   "valoracion double, "+
					   "precio double, "+
					   "duracion double)");
			statement.executeUpdate("create table ComprasVisitas "+
					   "(codigo string, "+
					   "usuario string, "+
					   "cantidad int)");
			statement.executeUpdate("create table Ofertas "+
					   "(codigo string, "+
					   "codigoHotel string, "+
					   "precioPorAdulto double, "+
					   " precioPorMenor double)");
			statement.executeUpdate("create table ComprasOfertas "+
					   "(codigo string, "+
					   "usuario string, "+
					   "numDias int, "+
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
			statement.executeUpdate("drop table if exists ComprasVuelos");
			statement.executeUpdate("drop table if exists Visitas");
			statement.executeUpdate("drop table if exists ComprasVisitas");
			statement.executeUpdate("drop table if exists Ofertas");
			statement.executeUpdate("drop table if exists ComprasOfertas");
			statement.executeUpdate("drop table if exists Hoteles");
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
		Connection con = BD.initBD();
		Statement st = null;
		try {
			st = con.createStatement();
			String query = "INSERT INTO Usuarios VALUES('"+u.getUsuario()+"','"+u.getContrasenya()+"','"+u.getCorreo()+"')";
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
		Connection con = BD.initBD();
		Statement st = null;
		Vuelo vu;
		Visita vi;
		try {
			st = con.createStatement();
			String query;
			if(p instanceof Vuelo) {
				vu = (Vuelo) p;
				query = "INSERT INTO Vuelos VALUES('"+vu.getCodigo()+"','"+vu.getOrigen()+"','"+vu.getDestino()+"','"+vu.getFechaYHora()+"',"+vu.getPrecio()+","+vu.getDuracion()+")";
			}
			else {
				vi = (Visita) p;
				query = "INSERT INTO Visitas VALUES('"+vi.getCodigo()+"','"+vi.getLugarInteres()+"','"+vi.getDireccion()+"',"+vi.getValoracion()+","+vi.getPrecio()+","+vi.getDuracion()+")";
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
	
	public static void anyadirOferta(Oferta o) {
		Connection con = BD.initBD();
		Statement st = null;
		String query = "INSERT INTO Ofertas VALUES('"+o.getCodigo()+"','"+o.getCodigoHotel()+"',"+o.getPrecioPorAdulto()+","+o.getPrecioPorMenor()+")";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
	}
	
	public static void anyadirHotel(Hotel h) {
		Connection con = BD.initBD();
		Statement st = null;
		String query = "INSERT INTO Hoteles VALUES('"+h.getCodigo()+"','"+h.getCiudad()+"',"+h.getEstrellas()+")";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			BD.cerrarBD(con, st);
		}
	}
	
	/**
	 * 
	 * @param usuario
	 * @param contrasenya
	 * @return 	0: No hay ningún usuario con ese nombre de usuario
	 * 			1: Existe un usuario con ese nombre de usuario pero la contraseña no coincide
	 * 			2: Existe un usuario con ese nombre de usuario y la contraseña coincide
	 */
	
	
	public static int comprobacionUsuario(String usuario, String contrasenya) {
		Connection con = BD.initBD();
		int resultado = 0;
		String query = "select * from Usuarios where usuario = '"+usuario+"'";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				String c = rs.getString("contrasenya");
				if(contrasenya.equals(c))
					resultado = 2;
				else 
					resultado = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
		return resultado;
	}
	
	public static Usuario obtenerUsuario(String usuario) {
		Connection con = BD.initBD();
		String query = "select * from Usuarios where usuario = '"+usuario+"'";
		Statement st = null;
		Usuario u = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				String c = rs.getString("contrasenya");
				String co = rs.getString("correo");
				u = new Usuario(usuario, c, co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
		return u;
	}
	
	
	public static ArrayList<String> destinosOfertas(){
		Connection con = BD.initBD();
		ArrayList<String> destinos = new ArrayList<>();
		String query = "SELECT codigoHotel FROM Ofertas";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String query2 = "SELECT direccion FROM Hoteles WHERE codigo='" + rs.getString("codigoHotel")+"'";
				ResultSet rs2 = st.executeQuery(query2);
				while(rs2.next()) {
					String destino = rs2.getString("direccion");
					destinos.add(destino);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cerrarBD(con, st);
		}
		return destinos;
	}
	
	public static ArrayList<Oferta> obtenerOfertasDestino(String destino){
		ArrayList<Oferta> ofertas = new ArrayList<>();
		
		String query1 = "SELECT codigo FROM Hoteles WHERE direccion='"+destino+"'";
		Connection con = BD.initBD();
		Statement st = null;
		try {
		
			st = con.createStatement();
			ResultSet rs1 = st.executeQuery(query1);
			while(rs1.next()) {
			
				String codigo = rs1.getString("codigo");
			
				String query = "SELECT * FROM Ofertas WHERE codigoHotel='"+codigo+"'";
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					String codigoOferta = rs.getString("codigo");
					String codigoHotel = rs.getString("codigoHotel");
					double precioPorAdulto = rs.getDouble("precioPorAdulto");
					double precioPorMenor = rs.getDouble("precioPorMenor");
					Oferta o = new Oferta(codigoOferta, codigoHotel, precioPorAdulto, precioPorMenor);
					ofertas.add(o);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
		return ofertas;
	}
	
	public static ArrayList<String> destinosVisita() {
		Connection con = BD.initBD();
		ArrayList<String> destinos = new ArrayList<>();
		String query = "SELECT direccion FROM Visitas";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String destino = rs.getString("direccion");
				destinos.add(destino);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cerrarBD(con, st);
		}
		return destinos;
	}
	
	public static ArrayList<Visita> obtenerVisitasDestino(String destino){
		ArrayList<Visita> visitas = new ArrayList<>();
		String query = "SELECT * FROM Visitas WHERE direccion='"+destino+"'";
		Connection con = BD.initBD();
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String codigo = rs.getString("codigo");
				String lugarInteres = rs.getString("lugarInteres");
				String direccion = rs.getString("direccion");
				double valoracion = rs.getDouble("valoracion");
				double precio = rs.getDouble("precio");
				double duracion = rs.getDouble("duracion");
				Visita vi = new Visita(codigo, lugarInteres, direccion, valoracion, duracion, precio);
				visitas.add(vi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cerrarBD(con, st);
		}
		return visitas;
	}
	
	 public static ArrayList<String> origenesVuelo(){
		 Connection con = BD.initBD();
		 ArrayList<String> origenes = new ArrayList<>();
		 String query = "SELECT origen FROM Vuelos";
		 Statement st = null;
		 try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String origen = rs.getString("origen");
				origenes.add(origen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cerrarBD(con, st);
		}
		 return origenes;
	 }
	
	 public static ArrayList<Vuelo> obtenerVuelosOrigen(String ciudad){
		 ArrayList<Vuelo> vuelos = new ArrayList<>();
		 String query = "SELECT * FROM Vuelos WHERE origen='" + ciudad + "'";
		 Connection con = BD.initBD();
		 Statement st = null;
		 try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String codigo = rs.getString("codigo");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				String fechaYHora = rs.getString("fechaYHora");
				double precio = rs.getDouble("precio");
				double duracion = rs.getDouble("duracion");
				Vuelo v = new Vuelo(codigo, origen, destino, fechaYHora, duracion, precio);
				vuelos.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cerrarBD(con, st);
		}
		 return vuelos;
	 }
}
