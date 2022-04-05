package logico;

import java.util.Date;

public class Cita {
	
	private Date fecha;
	private String codigo;
	private String notas;
	private String especialidad;
	private String doctor;
	

	
	public Cita( Date fecha, String codigo, String notas, String especialidad, String doctor) {
		super();
		this.fecha = fecha;
		this.codigo = codigo;
		this.notas = notas;
		this.especialidad = especialidad;
		this.doctor = doctor;
	}
	

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	
	
	

}
