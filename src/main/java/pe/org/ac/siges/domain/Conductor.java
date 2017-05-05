package pe.org.ac.siges.domain;

import java.io.Serializable;

public class Conductor implements Serializable{

	private static final long serialVersionUID = 6919193741263791435L;

	private Integer id;
	private String dni;
	private String nombre;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = (nombre!=null?nombre.toUpperCase():nombre);
	}

}
