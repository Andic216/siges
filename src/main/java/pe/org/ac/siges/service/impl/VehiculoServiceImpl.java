package pe.org.ac.siges.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.dao.VehiculoDao;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.domain.Vehiculo;
import pe.org.ac.siges.service.VehiculoService;
import pe.org.ac.siges.util.Constant;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

	final static Logger logger = Logger.getLogger(VehiculoServiceImpl.class);

	@Autowired
	private VehiculoDao vehiculoDao;
	
	@Autowired
	private EntregaDao entregaDao;

	public List<Vehiculo> getAll(Vehiculo obj) {
		try {
			return vehiculoDao.getAll(obj);
		} catch (Exception e) {
			logger.error("ConductorService - getAll: " + e);
			return null;
		}
	}

	public Respuesta saveOrUpdate(Vehiculo obj) {
		try {
			if (obj.getId() != null) {
				vehiculoDao.update(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_UPDATE);
			} else {
				vehiculoDao.save(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_SAVE);
			}
		} catch (Exception e) {
			logger.error("ConductorService - saveOrUpdate: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Respuesta delete(Vehiculo obj) {
		try {
			
			List<Entrega> lst =  entregaDao.getAll(new Entrega(obj));
			if(lst.size()>0){
				return new Respuesta(Constant.DATA_ERROR, Constant.MNSJ_USO);
			}			
			vehiculoDao.delete(obj);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_DELETE);
		} catch (Exception e) {
			logger.error("ConductorService - delete: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Vehiculo get(Vehiculo obj) {
		try {
			return vehiculoDao.get(obj);
		} catch (Exception e) {
			logger.error("ConductorService - edit: " + e);
			return null;
		}

	}
}
