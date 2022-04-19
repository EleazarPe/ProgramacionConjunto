package logico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private ArrayList<Consulta> misConsultas;
	private String tipoSangre;
	private String rh;
	private String Ocupacion;
	private String TelefonoOpc;
	private ArrayList<Dosis> misDosis;
	private ArrayList<Cita> misCitas;

	public Paciente(String nombre, String apellido, String cedula, Date fechaNaciento, String ocupacion,
			String telefono, String direccion,String codigo, String tipoSangre,String rh,
			String TelefonoOpc) {
		super(nombre, apellido, cedula, fechaNaciento, telefono, direccion,codigo);
		this.tipoSangre = tipoSangre;
		this.rh = rh;
		this.Ocupacion = ocupacion;
		//this.misConsultas = new ArrayList<>();
		this.misDosis = new ArrayList<>();
		this.misCitas = new ArrayList<>();
		this.TelefonoOpc = TelefonoOpc;
	}

	/*public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}*/

	public String getTipoSangre() {
		return tipoSangre;
	}

	/*public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}*/

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getOcupacion() {
		return Ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		Ocupacion = ocupacion;
	}

	public ArrayList<Dosis> getMisDosis() {
		return misDosis;
	}

	public void setMisDosis(ArrayList<Dosis> misds) {
		this.misDosis = misds;
	}

	public void ingresarDosis(Dosis vaccine) {
		misDosis.add(vaccine);
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

	public String getTelefonoOpc() {
		return TelefonoOpc;
	}

	public void setTelefonoOpc(String telefonoOpc) {
		TelefonoOpc = telefonoOpc;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

}
