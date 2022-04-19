package logico;

import java.io.Serializable;
import java.util.Date;

public class Dosis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vacuna vacinneVacuna;
	private String doctor;
	private Date fecha;
	public Dosis(Vacuna vc, String doctor) {
		super();
		this.vacinneVacuna = vc;
		this.doctor = doctor;
		this.fecha = new Date();
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

	public Vacuna getVacinneVacuna() {
		return vacinneVacuna;
	}

	public void setVacinneVacuna(Vacuna vacinneVacuna) {
		this.vacinneVacuna = vacinneVacuna;
	}

}
