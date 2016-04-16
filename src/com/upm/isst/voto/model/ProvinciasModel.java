package com.upm.isst.voto.model;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProvinciasModel implements Serializable{
	
	public ProvinciasModel(String nombre, int numeroCandidatos) {
	
		this.nombre = nombre;
		this.numeroCandidatos = numeroCandidatos;
	}

	@Id
	@Column
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroCandidatos() {
		return numeroCandidatos;
	}

	public void setNumeroCandidatos(int numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}

	@Column
	private int numeroCandidatos;

}
