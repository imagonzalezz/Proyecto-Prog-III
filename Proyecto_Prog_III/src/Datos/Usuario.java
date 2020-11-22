package Datos;

public class Usuario {
	
	protected String usuario;
	protected String contrasenya;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario, String contrasenya) {
		super();
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenya=" + contrasenya + "]";
	}

	
	


}
