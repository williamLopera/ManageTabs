package com.domain;

import java.util.ArrayList;

public class Pestana {
	private String name;
	private String url;
	private String id;
	private String visible;
	private String obligatorio;
	private String editable;
	private String tipoCampo;
	private String indicadorObligatorio;
	private String validarVista;
	

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
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
	private ArrayList<Seccion> secciones;
	
	public Pestana(){
		secciones = new ArrayList<Seccion>();
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
	public ArrayList<Seccion> getSecciones() {
		return secciones;
	}
	public void setSecciones(ArrayList<Seccion> secciones) {
		this.secciones = secciones;
	}
	@Override
	public String toString() {
		return "Pestana [name=" + name +  ", url=" + url+ ", id=" + id + ", visible="
				+ visible + ", obligatorio=" + obligatorio + ", editable="
				+ editable + ", secciones=" + secciones + "]";
	}
	
	
}
