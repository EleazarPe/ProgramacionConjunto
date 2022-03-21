package logico;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Usuario {

	private ArrayList<Consulta> misConsultas;
	private String tipoSangre;
	
	public Paciente(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion,ArrayList<Consulta>misConsultas, String tipoSangre) {
		super(nombre, apellido, cedula, fechaNaciento, ocupacion, telefono, direccion);
		this.misConsultas = new ArrayList<>();
		this.tipoSangre = tipoSangre;
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

}
