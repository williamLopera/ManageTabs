/**
 * 
 */
package com.webmethods.caf.myportlet;

import com.domain.MensajeErroneo;
import com.utilities.Util;

/**
 * @author Pranical
 *
 */

public class MyPortletDefaultviewView  extends   com.webmethods.caf.faces.bean.BasePageBean {

	/**
	 * Determines if a de-serialized file is compatible with this class.
	 *
	 * Maintainers must change this value if and only if the new version
	 * of this class is not compatible with old versions. See Sun docs
	 * for <a href=http://java.sun.com/j2se/1.5.0/docs/guide/serialization/spec/version.html> 
	 * details. </a>
	 */
	private static final long serialVersionUID = 1L;
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {};
	private transient com.webmethods.caf.myportlet.MyPortlet myPortlet = null;
	private Util util;

	/**
	 * Initialize page
	 */
	
	
	public String initialize() {
		try {
			resolveDataBinding(INITIALIZE_PROPERTY_BINDINGS, null, "initialize", true, false);
		    util = new Util();
			return OUTCOME_OK;
		} catch (Exception e) {
			error(e);
			log(e);
			return OUTCOME_ERROR; 
		}	
	}

	public com.webmethods.caf.myportlet.MyPortlet getMyPortlet()  {
		if (myPortlet == null) {
		    myPortlet = (com.webmethods.caf.myportlet.MyPortlet)resolveExpression("#{MyPortlet}");
		}
		return myPortlet;
	}
	
	
	@SuppressWarnings("rawtypes")
	private java.util.ArrayList views = null;

	private static final String[][] VIEWS_PROPERTY_BINDINGS = new String[][] {
	};
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.ArrayList getViews() {
		if (views == null) {
			views = new java.util.ArrayList();
			views.add(new String[] {"/MyPortlet/default.view", "Tag Laborales"});
			views.add(new String[] {"/MyPortlet/page2.view", "Tag Personales"});
			views.add(new String[] {"/MyPortlet/page3.view", "Tag Otros Datos"});
		}
	
		resolveDataBinding(VIEWS_PROPERTY_BINDINGS, views, "views", false, false);
		return views;
	}

	/**
	 * Action Event Handler for the control with id='button1'
	 */
	public String validaciones() {
		try 
		{
			String vista = "/MyPortlet/default.view";
			MensajeErroneo  mensajeErroneo = util.evaluarData(myPortlet, "com/webmethods/caf/formularioXML/base.xml", vista);
		    myPortlet.setMensajes("");
		    if (mensajeErroneo.isError()){
			    String url = createURLToRedirect("wmp_tv=", mensajeErroneo.getVista());
				myPortlet.setMensajes(mensajeErroneo.getMensaje());
				//error("mensajesError: "+ mensajeErroneo.getMensaje());
				getFacesContext().getExternalContext().redirect(url);
		    } else {
		    	myPortlet.getAnalizarDatos();
		    	String url = createURLToRedirect("wmp_tv=", "/MyPortlet/ready.view");
				myPortlet.setMensajes(mensajeErroneo.getMensaje());
				getFacesContext().getExternalContext().redirect(url);
		    }
		} catch (Exception e) {			
			log("Error Validaciones: "+ e.getMessage());
			return OUTCOME_ERROR;
		}
   	 	return OUTCOME_OK;
	}

	public String createURLToRedirect(String tag, String view){
		String url = "";
	    try {
	    	com.webmethods.caf.portlet.IPortletURL renderUrl = createRenderUrl();
	    	url = renderUrl.toString();
	    	
	    	//error("##=> url inicial: "+ url);
	    	String[] data = renderUrl.toString().split(tag);		// Parametro al cual se direcciona la vista
	    	url = data[0] + tag + view;								// Parametriza la url de la visa a redireccionar
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return url;
	}

}