package logico;

import java.util.Date;

public class Cita {
	
	private Usuario[] user;
	private Date fecha;
	private String codigo;
	
	public Cita(Usuario[] user, Date fecha, String codigo) {
		super();
		this.user = user;
		this.fecha = fecha;
		this.codigo = codigo;
	}
	
	public Usuario[] getUser() {
		return user;
	}
	public void setUser(Usuario[] user) {
		this.user = user;
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
	
	
	
	

}
