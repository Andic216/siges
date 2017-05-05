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

import pe.org.ac.siges.domain.Conductor;
import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.service.ConductorService;

@Controller
@RequestMapping(value = "/conductor")
public class ConductorController {

	@Autowired
	private ConductorService conductorService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "conductor";
	}

	@RequestMapping(value = "/lst", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getLst(@ModelAttribute Conductor obj) {

		Map<String, Object> rpta = new HashMap<String, Object>();
		List<Conductor> lst = conductorService.getAll(obj);
		rpta.put("iTotalRecords", lst.size());
		rpta.put("aaData", lst);
		return rpta;
	}

	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Respuesta saveOrUpdate(@RequestBody Conductor pro) {

		return conductorService.saveOrUpdate(pro);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Conductor edit(@RequestBody Conductor pro) {

		return conductorService.get(pro);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody Respuesta eliminar(@RequestBody Conductor pro) {

		return conductorService.delete(pro);
	}
}
