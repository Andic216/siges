package pe.org.ac.siges.service;

import java.util.List;

import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.domain.Vehiculo;

public interface VehiculoService {
	
	public List<Vehiculo> getAll(Vehiculo obj);

	public Respuesta saveOrUpdate(Vehiculo obj);

	public Vehiculo get(Vehiculo obj);

	public Respuesta delete(Vehiculo obj);
}
