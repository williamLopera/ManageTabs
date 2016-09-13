package com.domain;

import java.util.ArrayList;

public class Seccion {
	private String name;
	private String id;
	private String visible;
	private String obligatorio;
	private String editable;
	private String tipoCampo;
	private String indicadorObligatorio;
	private String validarVista;
	private ArrayList<Campo> campos;


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
	public Seccion(){
		campos = new  ArrayList<Campo>();
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
	public ArrayList<Campo> getCampos() {
		return campos;
	}
	public void setCampos(ArrayList<Campo> campos) {
		this.campos = campos;
	}
	@Override
	public String toString() {
		return "Seccion [name=" + name + ", id=" + id + ", visible="
				+ visible + ", obligatorio=" + obligatorio + ", editable="
				+ editable + ", tipoCampo=" + tipoCampo
				+ ", indicadorObligatorio=" + indicadorObligatorio
				+ ", validarVista=" + validarVista + ", campos=" + campos + "]";
	}
	
	
}
