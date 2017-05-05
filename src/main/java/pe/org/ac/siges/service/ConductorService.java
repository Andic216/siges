package pe.org.ac.siges.service;

import java.util.List;

import pe.org.ac.siges.domain.Conductor;
import pe.org.ac.siges.domain.Respuesta;

public interface ConductorService {

	public List<Conductor> getAll(Conductor obj);

	public Respuesta saveOrUpdate(Conductor obj);

	public Conductor get(Conductor obj);

	public Respuesta delete(Conductor obj);
}
