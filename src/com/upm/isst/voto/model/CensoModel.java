package com.upm.isst.voto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CensoModel implements Serializable {
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
	private long codigoPostal;
	@Column
	private String ciudad;
	@Column
	private String provincia;
	@Column
	private String nacimiento;
	@Column
	private String nacionalidad;
	@Column
	private String sexo;
	@Column
	private boolean votoElectronico;
	@Column 
	private boolean certificado;

	public CensoModel(Long dni,String nombre, String apellido1, String apellido2, long codigoPostal, String ciudad, String provincia, String nacimiento, String nacionalidad, 
					  String sexo, boolean votoElectronico, boolean certificado){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.votoElectronico = votoElectronico;
		this.certificado = certificado;
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

	public long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isVotoElectronico() {
		return votoElectronico;
	}

	public void setVotoElectronico(boolean votoElectronico) {
		this.votoElectronico = votoElectronico;
	}
	public boolean certComprobado() {
		return certificado;
	}

	public void setCert(boolean certificado) {
		this.certificado = certificado;
	}
	@Override
	public String toString() {
		return "Persona [DNI=" + dni + ", Nombre=" + nombre
				+ ", PrimerApellido=" + apellido1 + ", SegundoApellido=" + apellido2
				+ ", Codigo Postal=" + codigoPostal  + ", Ciudad=" + ciudad
				+ ", Provincia=" + provincia + ", Fecha de nacimiento=" + nacimiento 
				+ ", Nacionalidad=" + nacionalidad + ", Sexo=" + sexo + ", ¿Voto Electronico?=" + votoElectronico
				+ "]";
	}

}
