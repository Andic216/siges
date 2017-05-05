package pe.org.ac.siges.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Entrega implements Serializable{

	private static final long serialVersionUID = 1990849743283736477L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Lima")
	private Date fecha;
	private String ticket;
	private Conductor conductor;
	private Vehiculo vehiculo;
	private Destino destino;
	private String capacidad;
	private String hora;
	private String diesel;

	private String fecAuxI;
	private String fecAuxF;
	
	
	public Entrega() {
		super();
	}
	public Entrega(String fecAuxI, String fecAuxF) {
		super();
		this.fecAuxI = fecAuxI;
		this.fecAuxF = fecAuxF;
	}
	public Entrega(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
	}
	public Entrega(Destino destino) {
		super();
		this.destino = destino;
	}
	public Entrega(Conductor conductor) {
		super();
		this.conductor = conductor;
	}
	public String getFecAuxI() {
		return fecAuxI;
	}
	public void setFecAuxI(String fecAuxI) {
		this.fecAuxI = fecAuxI;
	}
	public String getFecAuxF() {
		return fecAuxF;
	}
	public void setFecAuxF(String fecAuxF) {
		this.fecAuxF = fecAuxF;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDiesel() {
		return diesel;
	}
	public void setDiesel(String diesel) {
		this.diesel = diesel;
	}
}
