package pe.org.ac.siges.service;

import java.util.List;

import pe.org.ac.siges.domain.Destino;
import pe.org.ac.siges.domain.Respuesta;

public interface DestinoService {

	public List<Destino> getAll(Destino obj);

	public Respuesta saveOrUpdate(Destino obj);

	public Destino get(Destino obj);

	public Respuesta delete(Destino obj);
}
