package com.domain;

public class DatosSolicitud {
	private boolean changeDatosPersonales;
	private boolean changeDatosLaborales;
	private DatosPersonales datosPersonales;
	private DatosLaborales datosLaborales;
	
	public DatosSolicitud(){};
	
	public DatosSolicitud(boolean changeDatosPersonales,
			boolean changeDatosLaborales, DatosPersonales datosPersonales,
			DatosLaborales datosLaborales) {
		this.changeDatosPersonales = changeDatosPersonales;
		this.changeDatosLaborales = changeDatosLaborales;
		this.datosPersonales = datosPersonales;
		this.datosLaborales = datosLaborales;
	}

	public boolean isChangeDatosPersonales() {
		return changeDatosPersonales;
	}

	public void setChangeDatosPersonales(boolean changeDatosPersonales) {
		this.changeDatosPersonales = changeDatosPersonales;
	}

	public boolean isChangeDatosLaborales() {
		return changeDatosLaborales;
	}

	public void setChangeDatosLaborales(boolean changeDatosLaborales) {
		this.changeDatosLaborales = changeDatosLaborales;
	}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public DatosLaborales getDatosLaborales() {
		return datosLaborales;
	}

	public void setDatosLaborales(DatosLaborales datosLaborales) {
		this.datosLaborales = datosLaborales;
	}

	@Override
	public String toString() {
		return "DatosSolicitud [changeDatosPersonales=" + changeDatosPersonales
				+ ", changeDatosLaborales=" + changeDatosLaborales
				+ ", datosPersonales=" + datosPersonales + ", datosLaborales="
				+ datosLaborales + "]";
	}
}
