package pe.org.ac.siges.dao;

import java.util.List;

import pe.org.ac.siges.domain.Destino;

public interface DestinoDao {

	public void save(Destino obj) throws Exception;

	public List<Destino> getAll(Destino obj) throws Exception;

	public Destino get(Destino obj) throws Exception;

	public void update(Destino obj) throws Exception;

	public void delete(Destino obj) throws Exception;
}
