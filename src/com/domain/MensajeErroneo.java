package com.domain;

public class MensajeErroneo {
	private String mensaje;
	private String vista;
	private boolean error;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	public MensajeErroneo() {}
	
	public MensajeErroneo(String mensaje, String vista, boolean error) {
		super();
		this.mensaje = mensaje;
		this.vista = vista;
		this.error = error;
	}
	@Override
	public String toString() {
		return "MensajeErroneo [mensaje=" + mensaje + ", vista=" + vista + "]";
	}
}
