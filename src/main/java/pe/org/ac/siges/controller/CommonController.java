package pe.org.ac.siges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.org.ac.siges.domain.Conductor;
import pe.org.ac.siges.domain.Destino;
import pe.org.ac.siges.domain.Vehiculo;
import pe.org.ac.siges.service.ConductorService;
import pe.org.ac.siges.service.DestinoService;
import pe.org.ac.siges.service.VehiculoService;

@Controller
@RequestMapping(value = "/common")
public class CommonController {
	
	@Autowired
	private ConductorService conductorService;
	
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(value = "/conductor", produces = "application/json; charset=utf-8")
	public @ResponseBody List<Conductor> conductor() {
		return conductorService.getAll(new Conductor());
	}
	
	@RequestMapping(value = "/destino", produces = "application/json; charset=utf-8")
	public @ResponseBody List<Destino> destino() {		
		return destinoService.getAll(new Destino());		
	}
	
	@RequestMapping(value = "/vehiculo", produces = "application/json; charset=utf-8")
	public @ResponseBody List<Vehiculo> vehiculo() {	
		return vehiculoService.getAll(new Vehiculo());		
	}
}
