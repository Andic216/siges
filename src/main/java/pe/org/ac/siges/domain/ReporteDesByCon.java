package pe.org.ac.siges.domain;

import java.io.Serializable;

public class ReporteDesByCon implements Serializable {

	private static final long serialVersionUID = -2570122974799535135L;

	private Integer codDestino;
	private String nomDestino;
	private Integer codConductor;
	private String nomConductor;
	private Integer canViaje;

	public ReporteDesByCon() {
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

	public Integer getCodConductor() {
		return codConductor;
	}

	public void setCodConductor(Integer codConductor) {
		this.codConductor = codConductor;
	}

	public String getNomConductor() {
		return nomConductor;
	}

	public void setNomConductor(String nomConductor) {
		this.nomConductor = nomConductor;
	}

	public Integer getCanViaje() {
		return canViaje;
	}

	public void setCanViaje(Integer canViaje) {
		this.canViaje = canViaje;
	}

}
