/**
 * 
 */
package com.webmethods.caf.myportlet;

/**
 * @author Pranical
 *
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.portlet.PortletPreferences;

import org.apache.log4j.Logger;

import com.domain.CampoVariable;
import com.domain.DatosLaborales;
import com.domain.DatosPersonales;
import com.domain.DatosSolicitud;

public class MyPortlet  extends   com.webmethods.caf.faces.bean.BaseFacesPreferencesBean {
	Logger logger = Logger.getLogger(MyPortlet.class);	
	private transient com.webmethods.caf.ManageTabs manageTabs = null;
	private DatosPersonales personalInicial;
	private DatosPersonales personalFinal;
	private DatosLaborales laboralInicial;
	private DatosLaborales laboralFinal;
	private ArrayList<CampoVariable> camposVariables;
	private DatosSolicitud datosSolicitud;
	
	/**
	 * List of portlet preference names
	 */
	public static final String[] PREFERENCES_NAMES = new String[] {
		"personal", "laboral", "mensajes"
	};
	/**
	 * Create new preferences bean with list of preference names
	 */
	public MyPortlet() {
		super(PREFERENCES_NAMES);
		try {
			datosSolicitud = dummyCargarDatosSolicitud();
			
			// Seteo los datos originales - clonar valores (tener instancias iniciales independiente)
			personalInicial = dummyCargarDatosSolicitud().getDatosPersonales();
			laboralInicial = dummyCargarDatosSolicitud().getDatosLaborales();
			
			// Seteo los valores al objeto de dominio del negocio
			setLaboral(datosSolicitud.getDatosLaborales());
			setPersonal(datosSolicitud.getDatosPersonales());
			setMensajes("");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Call this method in order to persist
	 * Portlet preferences
	 */
	public void storePreferences() throws Exception {
		logger.info("##=> MyPortlet - storePreferences ");
		updatePreferences();
		PortletPreferences preferences = getPreferences();
		preferences.store();	
		personalFinal = getPersonal();
		laboralFinal = getLaboral();
	}

	public com.webmethods.caf.ManageTabs getManageTabs()  {		
		if (manageTabs == null) {
		    manageTabs = (com.webmethods.caf.ManageTabs)resolveExpression("#{ManageTabs}");
		}
		return manageTabs;
	}

	public DatosSolicitud dummyCargarDatosSolicitud(){
		DatosPersonales datosPersonales = new DatosPersonales("1", "123456789", "Miguel Cabrera", "0424-1234567", "miguel.cabrera@test.com");
		DatosLaborales datosLaborales = new DatosLaborales("1", "Pelotero", "01/01/2000", "Caña de Azucar. Maracay.", "$ 20.000");
		DatosSolicitud solicitud = new DatosSolicitud(false, false, datosPersonales, datosLaborales);
		return solicitud;
	}

	
	/**
	 */
	public DatosLaborales getLaboral() throws Exception {
		return (DatosLaborales) getPreferenceValue("laboral", DatosLaborales.class);
	}

	/**
	 * Invoke {@link #storePreferences} to persist these changes
	 */
	public void setLaboral(DatosLaborales datosLaborales) throws Exception {
		setPreferenceValue("laboral", datosLaborales);
	}
	
	/**
	 */
	public DatosPersonales getPersonal() throws Exception {
		return (DatosPersonales) getPreferenceValue("personal", DatosPersonales.class);
	}

	
	public DatosSolicitud getDatosSolicitud() {
		return datosSolicitud;
	}

	public void setDatosSolicitud(DatosSolicitud datosSolicitud) {
		this.datosSolicitud = datosSolicitud;
	}

	
	public String getMensajes() throws Exception{
		return (String) getPreferenceValue("mensajes", String.class);
	}

	public void setMensajes(String mensajes)  throws Exception {
		setPreferenceValue("mensajes", mensajes);
	}

	/**
	 * Invoke {@link #storePreferences} to persist these changes
	 */
	public void setPersonal(DatosPersonales datosPersonal) throws Exception {
		setPreferenceValue("personal", datosPersonal);		
	}
	
	public void getAnalizarDatos(){
		try {
			storePreferences();
			camposVariables = new ArrayList<CampoVariable>();   // Reiniciar lista para re-evaluar cambios
			ArrayList<String> listaValoresPersonal = analizarDatos( "1",
																	personalInicial.getClass(), 
																	personalFinal.getClass(), 
																	personalInicial, 
																	personalFinal,
																	"Personal");		
			ArrayList<String> listaValoresLaboral = analizarDatos(  "1",
																	laboralInicial.getClass(), 
																	laboralFinal.getClass(), 
																	laboralInicial, 
																	laboralFinal,
																	"Laboral");	
			logger.info(" ----[CAMPOS VARIABLES] -------------------------------------------- ");
			for (String dato: listaValoresPersonal){
				logger.info(dato);
			}
			for (String dato: listaValoresLaboral){
				logger.info(dato);
			}
			
			for(CampoVariable campo: camposVariables){
				logger.info("Campo variable: " + campo.toString());
			}
			logger.info(" ------------------------------------------------------------------- ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * analizarDatos: Metodo encargado de analizar los datos de dos objetos para detectar su variacion.
	 */
	private ArrayList<String> analizarDatos( 	String id,
												Class clase1, 
												Class clase2, 
												Object object1,
												Object object2,
												String tabla)
	{
		ArrayList<String> listaValores = new ArrayList<String>();
		Field campos[] = clase1.getDeclaredFields();
		id = "0";
		for(int i=0; i<campos.length; i++)
		{
			String nombreCampo = campos[i].getName();
			char caracter=nombreCampo.toUpperCase().charAt(0);
			String resto=nombreCampo.substring(1);
			String tipo = "get";
//			if (nombreCampo.equalsIgnoreCase("valorBoolean") || nombreCampo.equalsIgnoreCase("valorBoolean"))
//			{
//				tipo = "is";
//			}
		
			try 
			{
				String valor1=null, valor2=null;
				Object obj1=null, obj2=null;

				Method metodo1 = clase1.getDeclaredMethod(tipo+caracter+resto,null);
				Method metodo2 = clase2.getDeclaredMethod(tipo+caracter+resto,null);
			
				obj1 = metodo1.invoke(object1, null);
				obj2 = metodo2.invoke(object2, null);
				if (obj1 != null && obj2 != null){
					valor1 = obj1.toString();
					valor2 = obj2.toString();
//					logger.info("valor1: " + valor1);
//					logger.info("valor2: " + valor2);
					if (!valor1.equals(valor2)){
						listaValores.add(" ##=> "+ nombreCampo + ": ["+ obj1.toString() +"/"+obj2.toString()+"]");
						camposVariables.add(new CampoVariable(id, tabla, nombreCampo,  obj1.toString(),  obj2.toString()));
					}
				}			
			} catch (Exception e){
				logger.error(" ##=> MyPortlet - Error analizarDatos: "+ e.getMessage());
			}
		}
		return listaValores;
	}
	
	public void validarDatos(){
		String nombre = personalFinal.getNombre();
		if (nombre.equals("")){
			
		}
	}

	public ArrayList<CampoVariable> getCamposVariables() {
		return camposVariables;
	}

	public void setCamposVariables(ArrayList<CampoVariable> camposVariables) {
		this.camposVariables = camposVariables;
	}
	
}