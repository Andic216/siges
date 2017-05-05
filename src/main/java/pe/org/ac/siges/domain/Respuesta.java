package pe.org.ac.siges.domain;

public class Respuesta {

	private String estado;
	private String mensaje;

	public Respuesta() {
		super();
	}

	public Respuesta(String estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
