package pe.org.ac.siges.util;

import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Component
public class InformeBean {

	public static ModelAndView reporte(JasperReportsPdfView rpt, String nom, Map<String, Object> datos)
			//throws Exception 
	{
		Properties hw = new Properties();		
		hw.setProperty("Content-Disposition", "attachment;filename=" + nom+(int)(Math.random()*100+1)+".pdf");
		rpt.setHeaders(hw);
		return new ModelAndView(rpt, datos);
	}

	@Bean(name="vehiculoPdf")
	public JasperReportsPdfView cargaErrorPdf() {
		JasperReportsPdfView v = new JasperReportsPdfView();
		 v.setUrl("classpath:/rpt/rptVehiculo.jasper");
		v.setReportDataKey("collectionData");
		return v;
	}
	
	@Bean(name="conductorPdf")
	public JasperReportsPdfView cargaPdf() {
		JasperReportsPdfView v = new JasperReportsPdfView();
		 v.setUrl("classpath:/rpt/rptConductor.jasper");
		v.setReportDataKey("collectionData");
		return v;
	}
	
	@Bean(name="ticketPdf")
	public JasperReportsPdfView impoPdf() {
		JasperReportsPdfView v = new JasperReportsPdfView();
		 v.setUrl("classpath:/rpt/rptTicket.jasper");
		v.setReportDataKey("collectionData");
		return v;
	}

}
