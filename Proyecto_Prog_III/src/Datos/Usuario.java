package Datos;

public class Usuario {
	
	protected String usuario;
	protected String contrasenya;
	protected String correo;
	
	/**
	 * Constructor para instanciar un usuario que ya existe en la base de datos
	 * @param usuario nombre de usuario
	 */
	public Usuario(String usuario) {
		super();
		this.usuario = usuario;
	}

	/**
	 * Constructor para instanciar un usuario que no existe en la base de datos
	 * @param usuario nombre de usuario
	 * @param contrasenya contraseña
	 * @param correo correo electronico
	 */
	public Usuario(String usuario, String contrasenya, String correo) {
		super();
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.correo = correo;
	}

	/**
	 * 
	 * @return nombre de usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario nombre de usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 * @return contraseña
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * 
	 * @param contrasenya contraseña
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * 
	 * @return correo electronico
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * 
	 * @param correo correo electronico
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenya=" + contrasenya + ", correo=" + correo + "]";
	}

	
	
	


}
