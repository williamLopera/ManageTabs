package com.utilities;

import java.net.URL;
import java.util.Enumeration;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.domain.FormularioDinamico;
import org.apache.log4j.Logger;

public class ManejadorFormularioDinamico {
	static Logger logger = Logger.getLogger(ManejadorFormularioDinamico.class);
	private FormularioDinamico formularioDinamico;
	private boolean estadoConsulta;
	
	public ManejadorFormularioDinamico(){
		estadoConsulta = false;
		formularioDinamico = new FormularioDinamico();
	}
	public FormularioDinamico getFormularioDinamico() {
		return formularioDinamico;
	}
	public void setFormularioDinamico(FormularioDinamico formularioDinamico) {
		this.formularioDinamico = formularioDinamico;
	}
	public boolean isEstadoConsulta() {
		return estadoConsulta;
	}
	public void setEstadoConsulta(boolean estadoConsulta) {
		this.estadoConsulta = estadoConsulta;
	}
	
	public ManejadorFormularioDinamico(Enumeration<URL> e){
		formularioDinamico = new FormularioDinamico();

		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = parserFactor.newSAXParser();
			FormularioDinamicoXML handler = new FormularioDinamicoXML();			
			if(e.hasMoreElements()){
				URL elemento = e.nextElement();
				logger.info("URL: "+ elemento.toString());
				parser.parse(elemento.openStream(),handler);
			
			}
			estadoConsulta=true;
			formularioDinamico = handler.getFormularioDinamico();
		} catch (Exception e1) {
			estadoConsulta=false;
			logger.info("Error ManejadorFormularioDinamico: "+e1.getMessage());
		}	
	}
}
