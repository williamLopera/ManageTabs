package com.domain;

public class DatosPersonales {
	private String id ;
	private String cedula;
	private String nombre;
	private String telefono;	
	private String correo;
	
	public DatosPersonales() {}
	
	public DatosPersonales(String id, String cedula, String nombre,
			String telefono, String correo) {
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "DatosPersonales [id=" + id + ", cedula=" + cedula + ", nombre="
				+ nombre + ", telefono=" + telefono + ", correo=" + correo
				+ "]";
	}
		
	/****** Validaciones *****/
	// Valida los campos los valores de los campos
	public boolean getValidator(String campo){
		if (campo.equalsIgnoreCase("Cedula") && cedula.trim().length() == 0)
			return  true;
		else if (campo.equalsIgnoreCase("Nombre") && nombre.trim().length() == 0)
				return  true;
		else if (campo.equalsIgnoreCase("Telefono") && telefono.trim().length() == 0)
				return true;
		else if (campo.equalsIgnoreCase("Correo") && correo.trim().length() == 0)
			return true;
		else
			return false;
	}
}