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
	private ArrayList<Cita> misCitas;
	private static Clinica miclinica= null;
	private static Usuario registroUsuario;

	public Clinica() {
		super();
		this.usuarios = new ArrayList<>();
		this.vacunas = new ArrayList<>();
		this.consultas = new ArrayList<>();
		this.enfermedadS = new ArrayList<>();
		this.historiales = new ArrayList<>();
		this.misCitas = new ArrayList<>();
		this.setVigilancias(new ArrayList<>());
	}

	public static Clinica getInstance() {
		if(miclinica==null) {
			miclinica = new Clinica();
		}
		return miclinica;
	}
	public static Clinica GetClinica() {
		return miclinica;
	}
	public static void SetClinica(Clinica clin) {
		Clinica.miclinica = clin;
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

	public ArrayList<Vigilancia> getVigilancias() {
		return vigilancias;
	}

	public void setVigilancias(ArrayList<Vigilancia> vigilancias) {
		this.vigilancias = vigilancias;
	}

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}


	/////////////////////////////////////Paciente y Usuario/////////////////////////////////////////////////////////////////

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

	public static Usuario getRegistroUsuario() {
		return registroUsuario;
	}

	public static void setRegistroUsuario(Usuario registroUsuario) {
		Clinica.registroUsuario = registroUsuario;
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

	public void insertarUsuario(Usuario us){
		usuarios.add(us);
	}


	///////////////////////////////////// Doctores /////////////////////////////////////////////////////////////////

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

	public boolean encontrarConsultorio(String str) {
		boolean control = false;
		for (Usuario consulta : usuarios) {
			if(consulta instanceof Medico) {
				if(((Medico) consulta).getConsultorioString().equalsIgnoreCase(str)) {
					control = true;
				}
			}
		}
		return control;
	}

	public ArrayList<Cita> compararCitaYDoctor() {
		ArrayList<Cita> lasCitas = new ArrayList<>();
		for (Cita cit : misCitas) {
			if( cit.getEspecialidad().equalsIgnoreCase(((Medico) registroUsuario).getEspecialidad()) && cit.getDoctor().equalsIgnoreCase(((Medico) registroUsuario).getNombre()+" "+((Medico) registroUsuario).getApellido())) {
				lasCitas.add(cit);
			}
		}
		return lasCitas;
	}

	///////////////////////////////////// Variadas /////////////////////////////////////////////////////////////////

	public boolean confirmLogin(String txt, String txt2) {
		boolean login = false;
		for (Usuario med : usuarios) {
			if(med instanceof Medico) {
				if(((Medico) med).getLoginString().equals(txt) && ((Medico) med).getPassowrdString().equals(txt2)) {
					registroUsuario = med;
					login = true;
				}
			}

		}
		return login;
	}

	public void eliminarEnfermedad(Enfermedad ef) {
		enfermedadS.remove(ef);
	}

	public void eliminarVacuna(Vacuna vc) {
		vacunas.remove(vc);
	}

	public Vacuna buscarVacunaByCodigo(String codigo) {
		Vacuna auxvaVacuna = null;
		for (Vacuna vc : vacunas) {
			if(vc.getCodigo().equalsIgnoreCase(codigo)) {
				auxvaVacuna = vc;
			}
		}
		return auxvaVacuna;
	}
	
	public Vacuna buscarVacunaByNombre(String nombre) {
		Vacuna auxvaVacuna = null;
		for (Vacuna vc : vacunas) {
			if(vc.getNombreString().equalsIgnoreCase(nombre)) {
				auxvaVacuna = vc;
			}
		}
		return auxvaVacuna;
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

	public void insertarVacuna(Vacuna vac) {
		vacunas.add(vac);
	}

	public void insertarEnfermedad(Enfermedad ef) {
		enfermedadS.add(ef);
	}

	public void insertarCita(Cita cit) {
		misCitas.add(cit);
	}
	public void insertarConsulta(Consulta consul) {
		consultas.add(consul);
	}

	public Usuario getLoginUserEmpleado() {
		return registroUsuario;
	}
	public void setLoginUserEmpleado(Usuario loginUserEmpleado) {
		Clinica.registroUsuario = registroUsuario;
	}
	
	public Cita buscarCitaByCodigoPaciente(String codigo) {
		Cita miCita = null;
		for (Cita cit : misCitas) {
			if(cit.getUserUsuario().getID().equalsIgnoreCase(codigo)) {
				miCita = cit;
			}
		}
		return miCita;
	}
}
