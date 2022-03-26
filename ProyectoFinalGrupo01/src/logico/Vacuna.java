package logico;

import java.util.ArrayList;
import java.util.Date;

public class Vacuna {
	private String cedulaString;
	private String nombreString;
	private String ocupacionString;
	private String direccionString;
	private Date fechanacimientoDate;
	private ArrayList<Dosis> dosisArrayList;
	public Vacuna(String cedulaString, String nombreString, String ocupacionString, String direccionString,
			Date fechanacimientoDate) {
		super();
		this.cedulaString = cedulaString;
		this.nombreString = nombreString;
		this.ocupacionString = ocupacionString;
		this.direccionString = direccionString;
		this.fechanacimientoDate = fechanacimientoDate;
		this.setDosisArrayList(new ArrayList<>());
	}
	public String getCedulaString() {
		return cedulaString;
	}
	public void setCedulaString(String cedulaString) {
		this.cedulaString = cedulaString;
	}
	public String getNombreString() {
		return nombreString;
	}
	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}
	public String getOcupacionString() {
		return ocupacionString;
	}
	public void setOcupacionString(String ocupacionString) {
		this.ocupacionString = ocupacionString;
	}
	public String getDireccionString() {
		return direccionString;
	}
	public void setDireccionString(String direccionString) {
		this.direccionString = direccionString;
	}
	public Date getFechanacimientoDate() {
		return fechanacimientoDate;
	}
	public void setFechanacimientoDate(Date fechanacimientoDate) {
		this.fechanacimientoDate = fechanacimientoDate;
	}
	public ArrayList<Dosis> getDosisArrayList() {
		return dosisArrayList;
	}
	public void setDosisArrayList(ArrayList<Dosis> dosisArrayList) {
		this.dosisArrayList = dosisArrayList;
	}
	public boolean encontrarDosis(String nombre) {
		boolean aux = false;
		for (Dosis dosis : dosisArrayList) {
			if(dosis.getNombre().equalsIgnoreCase(nombre)) {
				aux = true;
			}	
		}
		return aux;
	}
	public void insertarDosis(Dosis dos) {
		dosisArrayList.add(dos);
	}

}
