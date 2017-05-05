package pe.org.ac.siges.dao;

import java.util.List;

import pe.org.ac.siges.domain.Vehiculo;;

public interface VehiculoDao {

	public void save(Vehiculo obj) throws Exception;

	public List<Vehiculo> getAll(Vehiculo obj) throws Exception;

	public Vehiculo get(Vehiculo obj) throws Exception;

	public void update(Vehiculo obj) throws Exception;

	public void delete(Vehiculo obj) throws Exception;
}
