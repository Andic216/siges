package pe.org.ac.siges.service;

import java.util.List;

import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;

public interface EntregaService {

	public List<Entrega> getAll(Entrega obj);

	public Respuesta saveOrUpdate(Entrega obj);

	public Entrega get(Entrega obj);

	public Respuesta delete(Entrega obj);
}
