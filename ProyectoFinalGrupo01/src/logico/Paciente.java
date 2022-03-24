package logico;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Usuario {

	private ArrayList<Consulta> misConsultas;
	private String tipoSangre;
	private String CorreoElectronico;
	
	public Paciente(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion,String codigo,ArrayList<Consulta>misConsultas, String tipoSangre,
			String correoElectronico) {
		super(nombre, apellido, cedula, fechaNaciento, ocupacion, telefono, direccion,codigo);
		this.misConsultas = new ArrayList<>();
		this.tipoSangre = tipoSangre;
		this.CorreoElectronico = correoElectronico;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getCorreoElectronico() {
		return CorreoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}

}
