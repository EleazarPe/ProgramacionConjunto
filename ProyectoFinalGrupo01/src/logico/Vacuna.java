package logico;

import java.util.ArrayList;

public class Vacuna {
	private String codigo;
	private String nombreString;
	private String laboratorioString;
	private String administracionString;
	private ArrayList<Enfermedad> enfermedades;
	
	public Vacuna(String codigo, String nombreString, String laboratorioString, String administracionString,
			ArrayList<Enfermedad> enfermedades) {
		super();
		this.codigo = codigo;
		this.nombreString = nombreString;
		this.laboratorioString = laboratorioString;
		this.administracionString = administracionString;
		this.enfermedades = new ArrayList<Enfermedad>();
	}

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public String getLaboratorioString() {
		return laboratorioString;
	}

	public void setLaboratorioString(String laboratorioString) {
		this.laboratorioString = laboratorioString;
	}

	public String getAdministracionString() {
		return administracionString;
	}

	public void setAdministracionString(String administracionString) {
		this.administracionString = administracionString;
	}

	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void insertarEnfermedad(Enfermedad ef) {
		enfermedades.add(ef);
	}
	
}
