package logico;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Usuario {
	private String loginString;
	private String passowrdString;
	private String consultorioString;
	private String especialidadString;
	private ArrayList<Consulta> consultas;
	
	public Medico(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion, String telefono,
			String direccion, String login,String passowrd,String consultorio,String especialidad) {
		super(nombre, apellido, cedula, fechaNaciento, ocupacion, telefono, direccion);
		this.loginString = login;
		this.passowrdString = passowrd;
		this.consultorioString = consultorio;
		this.especialidadString = especialidad;
		this.setConsultas(new ArrayList<Consulta>());
	} 

	public String getLoginString() {
		return loginString;
	}

	public void setLoginString(String loginString) {
		this.loginString = loginString;
	}

	public String getPassowrdString() {
		return passowrdString;
	}

	public void setPassowrdString(String passowrdString) {
		this.passowrdString = passowrdString;
	}

	public String getConsultorioString() {
		return consultorioString;
	}

	public void setConsultorioString(String consultorioString) {
		this.consultorioString = consultorioString;
	}

	public String getEspecialidadString() {
		return especialidadString;
	}

	public void setEspecialidadString(String especialidadString) {
		this.especialidadString = especialidadString;
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public void insertarConsulta(Consulta consulta) {
		consultas.add(consulta);
	}
}
