package logico;

import java.util.Date;

public class Dosis {
	private String nombre;
	private String doctor;
	private Date fecha;
	private boolean aplicacion;
	public Dosis(String nombre, String doctor, boolean aplicacion) {
		super();
		this.nombre = nombre;
		this.doctor = doctor;
		this.fecha = new Date();
		this.aplicacion = aplicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(boolean aplicacion) {
		this.aplicacion = aplicacion;
	}
	
}
