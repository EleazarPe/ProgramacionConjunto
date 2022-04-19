package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cita miCita;
	private String observacioneString;
	private ArrayList<Enfermedad> misEnfermedads;
	private String diagnosticoString;
	private String recetaString;
	private boolean historial;
	private int estatura;
	private int peso;
	private String tipoSangreString;
	private String rHString;
	private Date fecha;

	public Consulta(Cita miCita, String observacioneString,
			String diagnosticoString, String recetaString, boolean historial, int estatura, int peso,
			String tipoSangreString, String rHString) {
		super();
		this.miCita = miCita;
		this.observacioneString = observacioneString;
		this.misEnfermedads = new ArrayList<>();
		this.diagnosticoString = diagnosticoString;
		this.recetaString = recetaString;
		this.historial = historial;
		this.estatura = estatura;
		this.peso = peso;
		this.tipoSangreString = tipoSangreString;
		this.rHString = rHString;
		this.fecha = new Date();
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cita getMiCita() {
		return miCita;
	}
	public void setMiCita(Cita miCita) {
		this.miCita = miCita;
	}
	public String getObservacioneString() {
		return observacioneString;
	}
	public void setObservacioneString(String observacioneString) {
		this.observacioneString = observacioneString;
	}
	public ArrayList<Enfermedad> getMisEnfermedads() {
		return misEnfermedads;
	}
	public void setMisEnfermedads(ArrayList<Enfermedad> misEnfermedads) {
		this.misEnfermedads = misEnfermedads;
	}
	public String getDiagnosticoString() {
		return diagnosticoString;
	}
	public void setDiagnosticoString(String diagnosticoString) {
		this.diagnosticoString = diagnosticoString;
	}
	public String getRecetaString() {
		return recetaString;
	}
	public void setRecetaString(String recetaString) {
		this.recetaString = recetaString;
	}
	public boolean isHistorial() {
		return historial;
	}
	public void setHistorial(boolean historial) {
		this.historial = historial;
	}
	public int getEstatura() {
		return estatura;
	}
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getTipoSangreString() {
		return tipoSangreString;
	}
	public void setTipoSangreString(String tipoSangreString) {
		this.tipoSangreString = tipoSangreString;
	}
	public String getrHString() {
		return rHString;
	}
	public void setrHString(String rHString) {
		this.rHString = rHString;
	}
	public void insertarEnfermedad(Enfermedad ef) {
		misEnfermedads.add(ef);
	}
}
