package pe.org.ac.siges.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.org.ac.siges.domain.Destino;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.DestinoService;

@Controller
@RequestMapping(value = "/destino")
public class DestinoController {


	@Autowired
	private DestinoService destinoService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "destino";
	}
	
	@RequestMapping(value = "/lst", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getLst(@ModelAttribute Destino obj) {

		Map<String, Object> rpta = new HashMap<String, Object>();
		List<Destino> lst = destinoService.getAll(obj);
		rpta.put("iTotalRecords", lst.size());
		rpta.put("aaData", lst);
		return rpta;
	}

	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Respuesta saveOrUpdate(@RequestBody Destino obj) {

		return destinoService.saveOrUpdate(obj);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Destino edit(@RequestBody Destino obj) {

		return destinoService.get(obj);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody Respuesta eliminar(@RequestBody Destino obj) {

		return destinoService.delete(obj);
	}
}
