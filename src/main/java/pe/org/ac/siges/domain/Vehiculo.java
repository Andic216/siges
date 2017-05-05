package pe.org.ac.siges.domain;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = -7916611608798440727L;

	private Integer id;
	private String placa;
	private String marca;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = (placa!=null?placa.toUpperCase():placa);
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = (marca!=null?marca.toUpperCase():marca);
	}
	
}
