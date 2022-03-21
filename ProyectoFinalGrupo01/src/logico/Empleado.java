package logico;

import java.util.Date;

public class Empleado extends Usuario {
	
	private String login;
	private String password;
	
	public Empleado(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion, String login, String password ) {
		super(nombre, apellido, cedula, fechaNaciento, ocupacion, telefono, direccion);
		this.login = login;
		this.password = password;
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

}
