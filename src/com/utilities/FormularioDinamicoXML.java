package com.utilities;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.domain.Campo;
import com.domain.FormularioDinamico;
import com.domain.Pestana;
import com.domain.Seccion;

public class FormularioDinamicoXML extends DefaultHandler{
	static Logger logger = Logger.getLogger(FormularioDinamicoXML.class);
	private FormularioDinamico formularioDinamico;
	private boolean xml = false;
	private boolean pestana = false;
	private boolean seccion = false;
	private boolean campo = false;
	private String content = null;
	private Pestana pestanaAux;
	private Seccion seccionAux;
	private Campo campoAux;
	
	public FormularioDinamico getFormularioDinamico() {
		return formularioDinamico;
	}
	public void setFormularioDinamico(FormularioDinamico formularioDinamico) {
		this.formularioDinamico = formularioDinamico;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		
		
//		System.out.println("abrio la etiqueta "+qName);
		if("campo".equalsIgnoreCase(qName)){
			xml = false;
			pestana = false;
			seccion = false;
			campo = true;
			campoAux = new Campo();
			System.out.println("Instancia de campo");
		}else
		if ("seccion".equalsIgnoreCase(qName)) {
			xml = false;
			pestana = false;
			seccion = true;
			campo = false;
			seccionAux = new Seccion();
			System.out.println("Instancia de seccion");
		}else
		if ("pestana".equalsIgnoreCase(qName)){
			xml = false;
			pestana = true;
			seccion = false;
			campo = false;
			pestanaAux = new Pestana();
			System.out.println("Instancia de pestana");
		}else
		if ("xml".equalsIgnoreCase(qName)){
			xml = true;
			pestana = false;
			seccion = false;
			campo = false;
			formularioDinamico = new FormularioDinamico();
			System.out.println("Instancia formularioDinamico");
		}
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		content = String.copyValueOf(ch, start, length).trim();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("Cierro elemento "+qName);
		if("campo".equalsIgnoreCase(qName)) {
			System.out.println("		"+campoAux.toString());
			seccionAux.getCampos().add(campoAux);
		}else
		if("seccion".equalsIgnoreCase(qName)) {
			System.out.println("	"+seccionAux.getName());
			pestanaAux.getSecciones().add(seccionAux);
		}if("pestana".equalsIgnoreCase(qName)) {
			System.out.println(pestanaAux.getName());
			formularioDinamico.getPestanas().add(pestanaAux);
		}else{
			if(campo){
				if ("name".equalsIgnoreCase(qName)) {
					campoAux.setName(content);
				}else
				if("id".equalsIgnoreCase(qName)) {
					campoAux.setId(content);
				}else
				if("visible".equalsIgnoreCase(qName)) {
					campoAux.setVisible(content);
				}else
				if("obligatorio".equalsIgnoreCase(qName)) {
					campoAux.setObligatorio(content);
				}else
				if("editable".equalsIgnoreCase(qName)) {
					campoAux.setEditable(content);
				}else
				if("tipoCampo".equalsIgnoreCase(qName)) {
					campoAux.setTipoCampo(content);
				}else
				if("indicaObligatorio".equalsIgnoreCase(qName)) {
					campoAux.setIndicadorObligatorio(content);
				}else
				if("validarVista".equalsIgnoreCase(qName)) {
					campoAux.setValidarVista(content);
				}
			}else
			if (seccion) {
				if ("name".equalsIgnoreCase(qName)) {
					seccionAux.setName(content);
				}else
				if("id".equalsIgnoreCase(qName)) {
					seccionAux.setId(content);
				}else
				if("visible".equalsIgnoreCase(qName)) {
					seccionAux.setVisible(content);
				}else
				if("obligatorio".equalsIgnoreCase(qName)) {
					seccionAux.setObligatorio(content);
				}else
				if("editable".equalsIgnoreCase(qName)) {
					seccionAux.setEditable(content);
				}
				if("tipoCampo".equalsIgnoreCase(qName)) {
					seccionAux.setTipoCampo(content);
				}else
				if("indicaObligatorio".equalsIgnoreCase(qName)) {
					seccionAux.setIndicadorObligatorio(content);
				}else
				if("validarVista".equalsIgnoreCase(qName)) {
					seccionAux.setValidarVista(content);
				}
			}else
			if (pestana){
				if ("name".equalsIgnoreCase(qName)) {
					pestanaAux.setName(content);
				}else
				if("url".equalsIgnoreCase(qName)) {
					pestanaAux.setUrl(content);
				}else
				if("id".equalsIgnoreCase(qName)) {
					pestanaAux.setId(content);
				}else
				if("visible".equalsIgnoreCase(qName)) {
					pestanaAux.setVisible(content);
				}else
				if("obligatorio".equalsIgnoreCase(qName)) {
					pestanaAux.setObligatorio(content);
				}else
				if("editable".equalsIgnoreCase(qName)) {
					pestanaAux.setEditable(content);
				}
				if("tipoCampo".equalsIgnoreCase(qName)) {
					pestanaAux.setTipoCampo(content);
				}else
				if("indicaObligatorio".equalsIgnoreCase(qName)) {
					pestanaAux.setIndicadorObligatorio(content);
				}else
				if("validarVista".equalsIgnoreCase(qName)) {
					pestanaAux.setValidarVista(content);
				}
			}else
			if (xml){
				if ("name".equalsIgnoreCase(qName)) {
					formularioDinamico.setNameDocumento(content);
				}
			}
		}
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("termino documento");
	}
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		super.error(e);
		System.out.println("error e");
	}

	
}
