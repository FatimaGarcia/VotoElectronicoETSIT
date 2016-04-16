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
	private long dni;
	@Column
	private String provincia;
	@Column
	private String partido;
	
	
	public PoliticosModel(Long codigo, String nombreCompleto, long dni, 
			 String provincia, String partido) {
		// TODO Auto-generated constructor stub
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.provincia = provincia;
		this.partido = partido;
		this.codigo = codigo;
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
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
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
	@Override
	public String toString() {
		return "Politico [Codigo=" + codigo + ", Nombre=" + nombreCompleto
				+ ", DNI=" + dni + ", Provincia=" + provincia
				+ ", Partido politico=" + partido + "]";
	}
}
