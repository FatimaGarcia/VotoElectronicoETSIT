package com.upm.isst.voto.model;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PoliticosModel implements Serializable {

	private static final long serialVersionUID =01L;
	@Id
	@Column
	private Long codigo;
	@Column
	private String nombreCompleto;
	@Column
	private String provincia;
	@Column
	private String partido;
	@Column 
	private int codPartido;
	
	
	public PoliticosModel(Long codigo, String nombreCompleto, 
			 String provincia, String partido, int codPartido) {
		// TODO Auto-generated constructor stub
		this.nombreCompleto = nombreCompleto;
		this.provincia = provincia;
		this.partido = partido;
		this.codigo = codigo;
		this.codPartido = codPartido;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getcodPartido() {
		return codPartido;
	}
	public void setcodPartido(int codPartido) {
		this.codPartido = codPartido;
	}
	@Override
	public String toString() {
		return "Politico [Codigo=" + codigo + ", Nombre=" + nombreCompleto
				+ ", Provincia=" + provincia
				+ ", Partido politico=" + partido + "]";
	}
}
