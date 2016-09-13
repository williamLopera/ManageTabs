package com.domain;

public class Campo {
	
	private String name;
	private String id;
	private String visible;
	private String obligatorio;
	private String editable;
	private String tipoCampo;
	private String indicadorObligatorio;
	private String validarVista;
	
	public String getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	public String getIndicadorObligatorio() {
		return indicadorObligatorio;
	}
	public void setIndicadorObligatorio(String indicadorObligatorio) {
		this.indicadorObligatorio = indicadorObligatorio;
	}
	public String getValidarVista() {
		return validarVista;
	}
	public void setValidarVista(String validarVista) {
		this.validarVista = validarVista;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public String getObligatorio() {
		return obligatorio;
	}
	public void setObligatorio(String obligatorio) {
		this.obligatorio = obligatorio;
	}
	public String getEditable() {
		return editable;
	}
	public void setEditable(String editable) {
		this.editable = editable;
	}
	@Override
	public String toString() {
		return "Campo [name=" + name + ", id=" + id + ", visible="
				+ visible + ", obligatorio=" + obligatorio + ", editable="
				+ editable + ", tipoCampo=" + tipoCampo
				+ ", indicadorObligatorio=" + indicadorObligatorio
				+ ", validarVista=" + validarVista + "]";
	}
	
	
}
