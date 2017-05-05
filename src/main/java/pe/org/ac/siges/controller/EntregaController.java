package pe.org.ac.siges.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.EntregaService;

@Controller
@RequestMapping(value = "/entrega")
public class EntregaController {

	final static Logger logger = Logger.getLogger(EntregaController.class);

	@Autowired
	private EntregaService entregaService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "entrega";
	}
	
	@RequestMapping(value = "/lst", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getLst(@ModelAttribute Entrega obj) {

		Map<String, Object> rpta = new HashMap<String, Object>();
		List<Entrega> lst = entregaService.getAll(obj);
		rpta.put("iTotalRecords", lst.size());
		rpta.put("aaData", lst);
		return rpta;
	}
	
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Respuesta saveOrUpdate(@RequestBody Entrega pro) {

		return entregaService.saveOrUpdate(pro);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Entrega edit(@RequestBody Entrega pro) {
		return entregaService.get(pro);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody Respuesta eliminar(@RequestBody Entrega pro) {
		return entregaService.delete(pro);
	}
}
