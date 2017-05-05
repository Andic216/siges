package pe.org.ac.siges.dao;

import java.util.List;

import pe.org.ac.siges.domain.Conductor;

public interface ConductorDao {

	public void save(Conductor obj) throws Exception;

	public List<Conductor> getAll(Conductor obj) throws Exception;

	public Conductor get(Conductor obj) throws Exception;

	public void update(Conductor obj) throws Exception;

	public void delete(Conductor obj) throws Exception;
}
