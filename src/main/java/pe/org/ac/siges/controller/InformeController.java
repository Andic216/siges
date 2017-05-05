package pe.org.ac.siges.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import pe.org.ac.siges.domain.Entrega;
import pe.org.ac.siges.service.InformeService;
import pe.org.ac.siges.util.InformeBean;

@Controller
@RequestMapping(value = "/informe")
public class InformeController {

	@Autowired
	private InformeService informeService;

	@Autowired
	private JasperReportsPdfView vehiculoPdf;
	
	@Autowired 
	private JasperReportsPdfView conductorPdf;
	  
	 @Autowired 
	 private JasperReportsPdfView ticketPdf;
	

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "informe";
	}

	@RequestMapping(value = "/vehiculo/{fInicio}/{fFin}", method = RequestMethod.GET)
	public ModelAndView vehiculo(HttpServletResponse response, @PathVariable String fInicio,
			@PathVariable String fFin) {

		return InformeBean.reporte(vehiculoPdf, "Vehiculo",
				informeService.dataVehiculo(new Entrega(fInicio.replaceAll("-", "/"), fFin.replaceAll("-", "/"))));
	}

	
	@RequestMapping(value = "/conductor/{fInicio}/{fFin}", method = RequestMethod.GET)
	public ModelAndView conductor(HttpServletResponse  response, @PathVariable String fInicio,	 
			@PathVariable String fFin) {
	 
	 return InformeBean.reporte(conductorPdf, "Conductor",
			 informeService.dataConductor(new Entrega(fInicio.replaceAll("-", "/"), fFin.replaceAll("-", "/"))));
	 }
	 
	 @RequestMapping(value = "/ticket/{fInicio}/{fFin}", method = RequestMethod.GET) 
	 public ModelAndView ticket(HttpServletResponse response, @PathVariable String fInicio, 
			 @PathVariable String fFin) {
	 
		 return InformeBean.reporte(ticketPdf, "Ticket",
				 	informeService.dataTicket(new Entrega(fInicio.replaceAll("-", "/"), fFin.replaceAll("-", "/")))); }
	

}
