package pe.org.ac.siges.domain;

import java.io.Serializable;

public class ReporteDesByVeh implements Serializable{

	private static final long serialVersionUID = -844450845150619198L;
	
	private Integer codDestino;
	private String nomDestino;
	private Integer codVehiculo;
	private String nomVehiculo;
	private Integer canViaje;
	private Integer diesel;

	public ReporteDesByVeh() {
		super();
	}

	public Integer getCodDestino() {
		return codDestino;
	}
	public void setCodDestino(Integer codDestino) {
		this.codDestino = codDestino;
	}
	public String getNomDestino() {
		return nomDestino;
	}
	public void setNomDestino(String nomDestino) {
		this.nomDestino = nomDestino;
	}
	public Integer getCodVehiculo() {
		return codVehiculo;
	}
	public void setCodVehiculo(Integer codVehiculo) {
		this.codVehiculo = codVehiculo;
	}
	public String getNomVehiculo() {
		return nomVehiculo;
	}
	public void setNomVehiculo(String nomVehiculo) {
		this.nomVehiculo = nomVehiculo;
	}
	public Integer getCanViaje() {
		return canViaje;
	}
	public void setCanViaje(Integer canViaje) {
		this.canViaje = canViaje;
	}
	public Integer getDiesel() {
		return diesel;
	}
	public void setDiesel(Integer diesel) {
		this.diesel = diesel;
	}

}
