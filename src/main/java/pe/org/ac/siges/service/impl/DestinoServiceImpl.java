package pe.org.ac.siges.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.DestinoDao;
import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.domain.Destino;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.DestinoService;
import pe.org.ac.siges.util.Constant;

@Service("destinoService")
public class DestinoServiceImpl implements DestinoService {

	final static Logger logger = Logger.getLogger(DestinoServiceImpl.class);
	
	@Autowired
	private DestinoDao destinoDao;
	
	@Autowired
	private EntregaDao entregaDao;
	
	public List<Destino> getAll(Destino obj) {
		try {
			return destinoDao.getAll(obj);
		} catch (Exception e) {
			logger.error("ConductorService - getAll: " + e);
			return null;
		}
	}

	public Respuesta saveOrUpdate(Destino obj) {
		try {
			if (obj.getId() != null) {
				destinoDao.update(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_UPDATE);
			} else {
				destinoDao.save(obj);
				return new Respuesta(Constant.DATA_OK, Constant.MNSJ_SAVE);
			}
		} catch (Exception e) {
			logger.error("ConductorService - saveOrUpdate: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}

	}

	public Respuesta delete(Destino obj) {
		try {
			List<Entrega> lst =  entregaDao.getAll(new Entrega(obj));
			if(lst.size()>0){
				return new Respuesta(Constant.DATA_ERROR, Constant.MNSJ_USO);
			}
			destinoDao.delete(obj);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_DELETE);
		} catch (Exception e) {
			logger.error("ConductorService - delete: " + e);
			return new Respuesta(Constant.DATA_OK, Constant.MNSJ_ERROR);
		}
	}

	public Destino get(Destino obj) {
		try {
			return destinoDao.get(obj);
		} catch (Exception e) {
			logger.error("ConductorService - edit: " + e);
			return null;
		}

	}
}
