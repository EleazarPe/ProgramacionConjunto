package logico;

import java.util.Date;

public class Vigilancia {
	private String nombreString;
	private String tipoString;
	private int transmisibilidad;
	private int poblacionAfectada;
	private Date primerbroteDate;
	private Date fechaActual;
	
	public Vigilancia(String nombreString, String tipoString, int transmisibilidad, int poblacionAfectada,
			Date primerbroteDate) {
		super();
		this.nombreString = nombreString;
		this.tipoString = tipoString;
		this.transmisibilidad = transmisibilidad;
		this.poblacionAfectada = poblacionAfectada;
		this.primerbroteDate = primerbroteDate;
		this.fechaActual = new Date();
	}
	

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public String getTipoString() {
		return tipoString;
	}

	public void setTipoString(String tipoString) {
		this.tipoString = tipoString;
	}

	public int getTransmisibilidad() {
		return transmisibilidad;
	}

	public void setTransmisibilidad(int transmisibilidad) {
		this.transmisibilidad = transmisibilidad;
	}

	public int getPoblacionAfectada() {
		return poblacionAfectada;
	}

	public void setPoblacionAfectada(int poblacionAfectada) {
		this.poblacionAfectada = poblacionAfectada;
	}

	public Date getPrimerbroteDate() {
		return primerbroteDate;
	}

	public void setPrimerbroteDate(Date primerbroteDate) {
		this.primerbroteDate = primerbroteDate;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
}
