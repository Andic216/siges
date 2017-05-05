package pe.org.ac.siges.domain;

import java.io.Serializable;
import java.util.Date;

public class ReporteDesByTic implements Serializable{

	private static final long serialVersionUID = 356928048054818828L;

	private Integer codDestino;
	private String nomDestino;
	private String ticket;
	private Date fecha;
	
	public ReporteDesByTic() {
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

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
}
