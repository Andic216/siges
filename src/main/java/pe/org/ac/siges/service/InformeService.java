package pe.org.ac.siges.service;

import java.util.Map;

import pe.org.ac.siges.domain.Entrega;

public interface InformeService {

	public Map<String, Object> dataVehiculo(Entrega obj);
	public Map<String, Object> dataConductor(Entrega obj);
	public Map<String, Object> dataTicket(Entrega obj);
}
