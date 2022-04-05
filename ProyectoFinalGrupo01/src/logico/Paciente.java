package logico;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Usuario {

	private ArrayList<Consulta> misConsultas;
	private String tipoSangre;
	private String CorreoElectronico;
	private String Ocupacion;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Cita> misCitas;
	
	public Paciente(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion,String codigo,ArrayList<Consulta>misConsultas, String tipoSangre,
			String correoElectronico) {
		super(nombre, apellido, cedula, fechaNaciento, telefono, direccion,codigo);
		this.tipoSangre = tipoSangre;
		this.CorreoElectronico = correoElectronico;
		this.Ocupacion = ocupacion;
		this.misConsultas = new ArrayList<>();
		this.misVacunas = new ArrayList<>();
		this.misCitas = new ArrayList<>();
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

	public String getOcupacion() {
		return Ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		Ocupacion = ocupacion;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	
	public void ingresarVacuna(Vacuna vaccine) {
		misVacunas.add(vaccine);
	}

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}
	
	public void insertarCita(Cita nueva) {
		misCitas.add(nueva);
	}

}
