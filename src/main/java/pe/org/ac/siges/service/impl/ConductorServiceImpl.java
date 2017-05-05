package pe.org.ac.siges.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.ConductorDao;
import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.domain.Conductor;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.ConductorService;
import pe.org.ac.siges.util.Constant;

@Service("conductorService")
public class ConductorServiceImpl implements ConductorService {

	final static Logger logger = Logger.getLogger(ConductorServiceImpl.class);

	@Autowired
	private ConductorDao conductorDao;
	
	@Autowired
	private EntregaDao entregaDao;

	public List<Conductor> getAll(Conductor obj) {
		try {
			return conductorDao.getAll(obj);
		} catch (Exception e) {
			logger.error("ConductorService - getAll: " + e);
			return null;
		}
	}

	public Respuesta saveOrUpdate(Conductor obj) {
		try {
			if (obj.getId() != null) {
				conductorDao.update(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_UPDATE);
			} else {
				conductorDao.save(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_SAVE);
			}
		} catch (Exception e) {
			logger.error("ConductorService - saveOrUpdate: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Respuesta delete(Conductor obj) {
		try {
			List<Entrega> lst =  entregaDao.getAll(new Entrega(obj));
			if(lst.size()>0){
				return new Respuesta(Constant.DATA_ERROR, Constant.MNSJ_USO);
			}
			conductorDao.delete(obj);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_DELETE);
		} catch (Exception e) {
			logger.error("ConductorService - delete: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Conductor get(Conductor obj) {
		try {
			return conductorDao.get(obj);
		} catch (Exception e) {
			logger.error("ConductorService - edit: " + e);
			return null;
		}

	}
}
