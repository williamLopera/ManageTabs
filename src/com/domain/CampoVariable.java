package com.domain;

public class CampoVariable {
	private String id;
	private String tabla;
	private String campo;
	private String valorInicial;
	private String valorFinal;
	
	public CampoVariable(String id, String tabla, String campo,
			String valorInicial, String valorFinal) {
		this.id = id;
		this.tabla = tabla;
		this.campo = campo;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
	}

	public CampoVariable() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(String valorInicial) {
		this.valorInicial = valorInicial;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	@Override
	public String toString() {
		return "CampoVariable [id=" + id + ", tabla=" + tabla + ", campo="
				+ campo + ", valorInicial=" + valorInicial + ", valorFinal="
				+ valorFinal + "]";
	}
}
