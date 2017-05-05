package pe.org.ac.siges.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.EntregaService;
import pe.org.ac.siges.util.Constant;

@Service("entregaService")
public class EntregaServiceImpl implements EntregaService {

	final static Logger logger = Logger.getLogger(EntregaServiceImpl.class);

	@Autowired
	private EntregaDao entregaDao;

	public List<Entrega> getAll(Entrega obj) {
		try {
			return entregaDao.getAll(obj);
		} catch (Exception e) {
			logger.error("ConductorService - getAll: " + e);
			return null;
		}
	}

	public Respuesta saveOrUpdate(Entrega obj) {
		try {
			if (obj.getId() != null) {
				entregaDao.update(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_UPDATE);
			} else {
				entregaDao.save(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_SAVE);
			}
		} catch (Exception e) {
			logger.error("ConductorService - saveOrUpdate: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Respuesta delete(Entrega obj) {
		try {
			entregaDao.delete(obj);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_DELETE);
		} catch (Exception e) {
			logger.error("ConductorService - delete: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}
	}

	public Entrega get(Entrega obj) {
		try {
			return entregaDao.get(obj);
		} catch (Exception e) {
			logger.error("ConductorService - edit: " + e);
			return null;
		}

	}
}
