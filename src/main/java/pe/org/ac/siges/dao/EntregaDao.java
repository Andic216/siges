package pe.org.ac.siges.dao;

import java.util.List;

import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.ReporteDesByCon;
import pe.org.ac.siges.domain.ReporteDesByTic;
import pe.org.ac.siges.domain.ReporteDesByVeh;

public interface EntregaDao {

	public void save(Entrega obj) throws Exception;

	public List<Entrega> getAll(Entrega obj) throws Exception;

	public Entrega get(Entrega obj) throws Exception;

	public void update(Entrega obj) throws Exception;

	public void delete(Entrega obj) throws Exception;

	public List<ReporteDesByVeh> getDestinoByVehiculo(Entrega obj) throws Exception;

	public List<ReporteDesByCon> getDestinoByConductor(Entrega obj) throws Exception;

	public List<ReporteDesByTic> getDestinoByTicket(Entrega obj) throws Exception;
}
