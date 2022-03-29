package logico;

import java.util.Date;

public class Usuario {
	
	protected String Nombre;
	protected String Apellido;
	protected String tipoDocumento;
	protected String ID;
	protected String Codigo;
	protected Date FechaNaciento;
	protected String Ocupacion;
	protected String telefono;
	protected String direccion;
	
	public Usuario(String nombre, String apellido, String ID, Date FechaNaciento, String ocupacion, String telefono,
			String direccion, String code) {
		super();
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.ID = ID;
		this.FechaNaciento = FechaNaciento;
		this.Ocupacion = ocupacion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.Codigo = code;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getOcupacion() {
		return Ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		Ocupacion = ocupacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public Date getFechaNaciento() {
		return FechaNaciento;
	}

	public void setFechaNaciento(Date fechaNaciento) {
		FechaNaciento = fechaNaciento;
	}

}
