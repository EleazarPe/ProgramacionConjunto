package logico;

import java.util.Date;

public class Vacuna {
	private Date fecha;
	private Date fechanacimientoDate;
	private String lugarString;
	private String vacunaString;
	
	public Vacuna(Date fecha, String lugarString, String vacunaString,Date fechanacimiento) {
		super();
		this.fecha = fecha;
		this.fecha = fechanacimiento;
		this.lugarString = lugarString;
		this.vacunaString = vacunaString;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugarString() {
		return lugarString;
	}

	public void setLugarString(String lugarString) {
		this.lugarString = lugarString;
	}

	public String getVacunaString() {
		return vacunaString;
	}

	public void setVacunaString(String vacunaString) {
		this.vacunaString = vacunaString;
	}

	public Date getFechanacimientoDate() {
		return fechanacimientoDate;
	}

	public void setFechanacimientoDate(Date fechanacimientoDate) {
		this.fechanacimientoDate = fechanacimientoDate;
	}
	

}
