package com.domain;

import java.util.ArrayList;

public class FormularioDinamico {

	private ArrayList<Pestana> pestanas;
	private String nameDocumento;

	public ArrayList<Pestana> getPestanas() {
		return pestanas;
	}
	public void setPestanas(ArrayList<Pestana> pestanas) {
		this.pestanas = pestanas;
	}
	public String getNameDocumento() {
		return nameDocumento;
	}
	public void setNameDocumento(String nameDocumento) {
		this.nameDocumento = nameDocumento;
	}
	
	public FormularioDinamico(){
		pestanas = new ArrayList<Pestana>();
	}
}
