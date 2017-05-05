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

import pe.org.ac.siges.domain.Respuesta;
import pe.org.ac.siges.domain.Vehiculo;
import pe.org.ac.siges.service.VehiculoService;

@Controller
@RequestMapping(value = "/vehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "vehiculo";
	}
	
	@RequestMapping(value = "/lst", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getLst(@ModelAttribute Vehiculo obj) {

		Map<String, Object> rpta = new HashMap<String, Object>();
		List<Vehiculo> lst = vehiculoService.getAll(obj);
		rpta.put("iTotalRecords", lst.size());
		rpta.put("aaData", lst);
		return rpta;
	}

	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Respuesta saveOrUpdate(@RequestBody Vehiculo obj) {

		return vehiculoService.saveOrUpdate(obj);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Vehiculo edit(@RequestBody Vehiculo obj) {

		return vehiculoService.get(obj);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody Respuesta eliminar(@RequestBody Vehiculo obj) {

		return vehiculoService.delete(obj);
	}
}
