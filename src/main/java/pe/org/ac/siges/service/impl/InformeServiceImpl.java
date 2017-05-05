package pe.org.ac.siges.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.ac.siges.dao.EntregaDao;
import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.ReporteDesByCon;
import pe.org.ac.siges.domain.ReporteDesByTic;
import pe.org.ac.siges.domain.ReporteDesByVeh;
import pe.org.ac.siges.service.InformeService;

@Service("informeService")
public class InformeServiceImpl implements InformeService {

	final static Logger logger = Logger.getLogger(InformeServiceImpl.class);

	@Autowired
	private EntregaDao entregaDao;

	public Map<String, Object> dataVehiculo(Entrega obj) {

		Map<String, Object> jsonObjectRoot = new HashMap<String, Object>();
		jsonObjectRoot.put("FINICIO", obj.getFecAuxI());
		jsonObjectRoot.put("FFIN", obj.getFecAuxF());
		jsonObjectRoot.put("REPORTE", "REPORTE - DESTINO VEHICULO");

		List<ReporteDesByVeh> lstEnt = new ArrayList<ReporteDesByVeh>();

		try {
			lstEnt = entregaDao.getDestinoByVehiculo(obj);
			jsonObjectRoot.put("TOTAL", lstEnt.size());
		} catch (Exception e) {
			logger.error("InformeServiceImpl - getAll: " + e);
			jsonObjectRoot.put("TOTAL", 0);
		}
		jsonObjectRoot.put("collectionData", lstEnt);
		return jsonObjectRoot;
	}

	public Map<String, Object> dataConductor(Entrega obj) {
		Map<String, Object> jsonObjectRoot = new HashMap<String, Object>();
		jsonObjectRoot.put("FINICIO", obj.getFecAuxI());
		jsonObjectRoot.put("FFIN", obj.getFecAuxF());
		jsonObjectRoot.put("REPORTE", "REPORTE DESTINO CONDUCTOR");

		List<ReporteDesByCon> lstEnt = new ArrayList<ReporteDesByCon>();

		try {
			lstEnt = entregaDao.getDestinoByConductor(obj);
			jsonObjectRoot.put("TOTAL", lstEnt.size());
		} catch (Exception e) {
			logger.error("InformeServiceImpl - getAll: " + e);
			jsonObjectRoot.put("TOTAL", 0);
		}
		jsonObjectRoot.put("collectionData", lstEnt);
		return jsonObjectRoot;
	}

	public Map<String, Object> dataTicket(Entrega obj) {
		Map<String, Object> jsonObjectRoot = new HashMap<String, Object>();
		jsonObjectRoot.put("FINICIO", obj.getFecAuxI());
		jsonObjectRoot.put("FFIN", obj.getFecAuxF());
		jsonObjectRoot.put("REPORTE", "REPORTE DESTINO TICKET");

		List<ReporteDesByTic> lstEnt = new ArrayList<ReporteDesByTic>();

		try {
			lstEnt = entregaDao.getDestinoByTicket(obj);
			jsonObjectRoot.put("TOTAL", lstEnt.size());
		} catch (Exception e) {
			logger.error("InformeServiceImpl - getAll: " + e);
			jsonObjectRoot.put("TOTAL", 0);
		}
		jsonObjectRoot.put("collectionData", lstEnt);
		return jsonObjectRoot;
	}
}
