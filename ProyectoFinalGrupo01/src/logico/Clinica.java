package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Clinica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Vacuna> vacunas;
	private ArrayList<Consulta> consultas;
	private ArrayList<Enfermedad> enfermedadS;
	private ArrayList<Historial> historiales;
	private ArrayList<Vigilancia> vigilancias;
	private static Clinica miclinica= null;
	private static Clinica miClinica2;
	
	public Clinica() {
		super();
		this.usuarios = new ArrayList<>();
		this.vacunas = new ArrayList<>();
		this.consultas = new ArrayList<>();
		this.enfermedadS = new ArrayList<>();
		this.historiales = new ArrayList<>();
		this.setVigilancias(new ArrayList<>());
	}
	
	public static Clinica getInstance() {
		if(miclinica==null) {
			miclinica = new Clinica();
		}
		return miclinica;
	}
	
	public static void SetClinica(Clinica clin) {
		Clinica.miClinica2 = clin;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public ArrayList<Vacuna> getVacunas() {
		return vacunas;
	}
	public void setVacunas(ArrayList<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}
	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}
	public ArrayList<Enfermedad> getenfermedadS() {
		return enfermedadS;
	}
	public void setenfermedadS(ArrayList<Enfermedad> enfermedadS) {
		this.enfermedadS = enfermedadS;
	}
	public ArrayList<Historial> getHistoriales() {
		return historiales;
	}
	public void setHistoriales(ArrayList<Historial> historiales) {
		this.historiales = historiales;
	}
	
	public void insertarUsuario(Usuario us){
		usuarios.add(us);
	}
	
	public void insertarVacuna(Vacuna vac) {
		vacunas.add(vac);
	}
	
	public void insertarEnfermedad(Enfermedad ef) {
		enfermedadS.add(ef);
	}
	public Usuario buscarUsuarioByCedula(String cedula) {
		Usuario user = null;
		for (Usuario findUs : usuarios) {
			if(findUs.getID().equalsIgnoreCase(cedula)) {
				user = findUs;
			}
		}
		return user;
	}
	
	public void eliminarUsuario(Usuario user) {
		usuarios.remove(user);
	}
	

	public Enfermedad buscarEnfermedadByCodigo(String codigo) {
		Enfermedad auxEnfermedad = null;
		for (Enfermedad ef : enfermedadS) {
			if(ef.getCodigoString().equalsIgnoreCase(codigo)) {
				auxEnfermedad = ef;
			}
		}
		return auxEnfermedad;
	}
	public ArrayList<Vigilancia> getVigilancias() {
		return vigilancias;
	}

	public void setVigilancias(ArrayList<Vigilancia> vigilancias) {
		this.vigilancias = vigilancias;
	}
	
	public Medico buscarMedicoByEspecialidadAndNombre(String especialidad, String nombre){
		Medico auxMedico = null;
		for (Usuario med : usuarios) {
			if(med instanceof Medico) {
				if(((Medico) med).getEspecialidad().equalsIgnoreCase(especialidad)) {
					if(med.getNombre().equalsIgnoreCase(nombre)) {
						auxMedico = (Medico) med;
					}
				}
			}
		}
		return auxMedico;
	}
	public ArrayList<Medico> buscarmedicosByEspecialiad(String especialidad) {
		ArrayList<Medico> auxMedico = new ArrayList<>();
		for (Usuario med : usuarios) {
			if(med instanceof Medico) {
				if(((Medico) med).getEspecialidad().equalsIgnoreCase(especialidad)) {
					auxMedico.add((Medico) med);
				}
			}
		}
		return auxMedico;
	}
	
	public Paciente buscarPacienteById(String id) {
		Paciente auxPaciente = null;
		for (Usuario consulta : usuarios) {
			if(consulta instanceof Paciente) {
				if(consulta.getID().equalsIgnoreCase(id)) {
					auxPaciente = (Paciente) consulta;
				}
			}
		}
		return auxPaciente;
	}
	
}
