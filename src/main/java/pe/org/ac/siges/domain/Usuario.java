package pe.org.ac.siges.domain;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -5961401164605335096L;

	private Integer id;
	private String rol;
	private String nombre;
	private String usuario;
	private String clave;
	private Integer estado;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Usuario(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Usuario(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	public Usuario(Integer id, String rol, String nombre) {
		super();
		this.id = id;
		this.rol = rol;
		this.nombre = nombre;
	}

	public Usuario(String usuario) {
		super();
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (nombre != null ? nombre.toUpperCase() : nombre);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = (usuario != null ? usuario.toUpperCase() : usuario);
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
