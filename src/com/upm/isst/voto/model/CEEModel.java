package com.upm.isst.voto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CEEModel implements Serializable {
	private static final long serialVersionUID =01L;
	@Id
	@Column
	private Long dni;
	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private String provincia;
	@Column
	private String contrasena;
	@Column
	private boolean voto;
	@Column
	private String cod; 

	public CEEModel(Long dni, String nombre, String apellido1, String apellido2, 
			 String provincia, String contrasena, String cod) {
		// TODO Auto-generated constructor stub
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.provincia = provincia;
		this.contrasena = contrasena;
		this.voto = false;
		this.cod = cod;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean getVoto() {
		return voto;
	}

	public void setVoto(Boolean voto) {
		this.voto = voto;
	}
	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "Persona [DNI=" + dni + ", Nombre=" + nombre
				+ ", PrimerApellido=" + apellido1 + ", SegundoApellido=" + apellido2
				+  ", Provincia=" + provincia + ", Ha votado?=" + voto + "]";
	}

}
