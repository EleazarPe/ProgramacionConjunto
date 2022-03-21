package logico;

public class Historial {
	
	private Consulta[] consultas;
	

	public Historial(Consulta[] consultas) {
		super();
		this.consultas = consultas;
	}

	public Consulta[] getConsultas() {
		return consultas;
	}

	public void setConsultas(Consulta[] consultas) {
		this.consultas = consultas;
	}
	
	

}
