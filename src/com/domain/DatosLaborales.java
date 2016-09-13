package com.domain;

public class DatosLaborales {
	private String id ;
	private String cargo;
	private String fechaInicio;
	private String direccion;	
	private String salario;
	
	public DatosLaborales() {}

	public DatosLaborales(String id, String cargo, String fechaInicio,
			String direccion, String salario) {
		this.id = id;
		this.cargo = cargo;
		this.fechaInicio = fechaInicio;
		this.direccion = direccion;
		this.salario = salario;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "DatosLaborales [id=" + id + ", cargo=" + cargo
				+ ", fechaInicio=" + fechaInicio + ", direccion=" + direccion
				+ ", salario=" + salario + "]";
	}	
	
	/****** Validaciones *****/
	// Valida los campos los valores de los campos
	public boolean getValidator(String campo){
		if (campo.equalsIgnoreCase("Cargo") && cargo.trim().length() == 0)
			return  true;
		else if (campo.equalsIgnoreCase("Fecha Inicio") && fechaInicio.trim().length() == 0)
				return  true;
		else if (campo.equalsIgnoreCase("Direccion") && direccion.trim().length() == 0)
				return true;
		else if (campo.equalsIgnoreCase("Salario") && salario.trim().length() == 0)
			return true;
		else
			return false;
	}
}
