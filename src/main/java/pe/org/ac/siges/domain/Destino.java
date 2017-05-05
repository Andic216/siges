package pe.org.ac.siges.domain;

import java.io.Serializable;

public class Destino implements Serializable{

	private static final long serialVersionUID = -6450671292568316715L;

	private Integer id;
	private String codigo;
	private String nombre;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = (codigo != null ? codigo.toUpperCase() : codigo);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = (nombre != null ? nombre.toUpperCase() : nombre);
	}

}
