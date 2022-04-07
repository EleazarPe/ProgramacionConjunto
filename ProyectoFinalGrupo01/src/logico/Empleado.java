package logico;

import java.io.Serializable;
import java.util.Date;

public class Empleado extends Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String ocupacionString;
	
	public Empleado(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion, String login,String codigo, String password ) {
		super(nombre, apellido, cedula, fechaNaciento, telefono, direccion, codigo);
		this.login = login;
		this.password = password;
		this.setOcupacionString(ocupacion);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOcupacionString() {
		return ocupacionString;
	}

	public void setOcupacionString(String ocupacionString) {
		this.ocupacionString = ocupacionString;
	}

}
