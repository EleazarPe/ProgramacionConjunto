package logico;

import java.util.ArrayList;

public class Clinica {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Vacuna> vacunas;
	private ArrayList<Consulta> consultas;
	private ArrayList<Enfermedad> vigilancias;
	private ArrayList<Historial> historiales;
	private static Clinica miclinica= null;
	
	public Clinica() {
		super();
		this.usuarios = new ArrayList<>();
		this.vacunas = new ArrayList<>();
		this.consultas = new ArrayList<>();
		this.vigilancias = new ArrayList<>();
		this.historiales = new ArrayList<>();
	}
	
	public static Clinica getInstance() {
		if(miclinica==null) {
			miclinica = new Clinica();
		}
		return miclinica;
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
	public ArrayList<Enfermedad> getVigilancias() {
		return vigilancias;
	}
	public void setVigilancias(ArrayList<Enfermedad> vigilancias) {
		this.vigilancias = vigilancias;
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
	
	public Vacuna buscarVacunabyCedula(String cedula) {
		Vacuna auxvacuna = null;
		for (Vacuna vc : vacunas) {
			//if(vc.getCedulaString().equalsIgnoreCase(cedula)) {
				//auxvacuna = vc;
			//}
		}
		return auxvacuna;
	}
	
}
