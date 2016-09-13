package com.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import org.apache.log4j.Logger;

import com.domain.Campo;
import com.domain.DatosLaborales;
import com.domain.DatosPersonales;
import com.domain.DatosSolicitud;
import com.domain.MensajeErroneo;
import com.domain.Pestana;
import com.domain.Seccion;
import com.webmethods.caf.myportlet.MyPortlet;


public class Util {
	
	protected static Logger logger = Logger.getLogger(Util.class);
	private ManejadorFormularioDinamico manejadorFormularioDinamico;
	
	public ManejadorFormularioDinamico getManejadorFormularioDinamico(String archivo)
	{
		if (manejadorFormularioDinamico == null){
			 try {
				Enumeration<URL> e = getClass().getClassLoader().getResources(archivo);
				manejadorFormularioDinamico = new ManejadorFormularioDinamico(e);
				logger.info("Longitud documento "+manejadorFormularioDinamico.getFormularioDinamico().getPestanas().size());
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
		}
		return manejadorFormularioDinamico;
	}
	
	public MensajeErroneo evaluarData(MyPortlet myPortlet, String archivo, String vista)
	{
		ManejadorFormularioDinamico mfd = getManejadorFormularioDinamico(archivo);
		StringBuffer mensajesError = new StringBuffer();
	    DatosSolicitud datosSolicitud = myPortlet.getDatosSolicitud();
	    String vistaErrada = "";
		for(Pestana pestana: mfd.getFormularioDinamico().getPestanas()){
			// Validar Datos Laborales Obligatorios
			if(pestana.getName().equals("Tag Laborales"))
			{
				DatosLaborales laboral = datosSolicitud.getDatosLaborales();
				for (Seccion seccion: pestana.getSecciones()){
					if (seccion.getName().equals("Datos Laborales")){
						for (Campo campo: seccion.getCampos()){
							if(campo.getObligatorio().equals("True"))
							{
								if (laboral.getValidator(campo.getName())){
									//error(campo.getName() + " -- cargo: "+ laboral.getCargo());									
									String error = 	"Pestaña: " + pestana.getName().toUpperCase() + 
											" -> Sección: " + seccion.getName().toUpperCase() + 
											" -> Campo: <font color='red'><Strong>"+ campo.getName().toUpperCase() 
											+ "</Strong> , es requerido.</font>";
									
									mensajesError.append(error +"_$_"+campo.getId()+"_$_"+seccion.getName()+"_$$_");
									if (vistaErrada.equals("")){
										vista = pestana.getUrl();
										vistaErrada = vista;
									}
								}
							}
						}
					}
				}
			}
			// Validar Datos Personales Obligatorios
			if(pestana.getName().equals("Tag Personales"))
			{
				DatosPersonales personal = datosSolicitud.getDatosPersonales();
				for (Seccion seccion: pestana.getSecciones()){
					if (seccion.getName().equals("Datos Personales")){
						for (Campo campo: seccion.getCampos()){
							if(campo.getObligatorio().equals("True"))
							{
								//error(campo.getName() + " -- cedula: "+ personal.getCedula() + " -- " + personal.getValidator(campo.getName()));
								if (personal.getValidator(campo.getName())){
									
									String error = 	"Pestaña: " + pestana.getName().toUpperCase() + 
											" -> Sección: " + seccion.getName().toUpperCase() + 
											" -> Campo: <font color='red'><Strong>"+ campo.getName().toUpperCase() 
											+ "</Strong> , es requerido.</font>";
									
									mensajesError.append(error +"_$_"+campo.getId()+"_$_"+seccion.getName()+"_$$_");
									if (vistaErrada.equals("")){
										vista = pestana.getUrl();
										vistaErrada = vista;
									}
								}
							}
						}
					}
				}
			}
		}
		if (!vistaErrada.equals("")){
			return new MensajeErroneo(mensajesError.toString(), vistaErrada, true);
		} else {
			return new MensajeErroneo("", vista, false);
		}
	}
	
}
