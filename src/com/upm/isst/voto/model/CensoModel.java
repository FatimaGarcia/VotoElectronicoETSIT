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
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private long dni;
	@Column
	private String calle;
	@Column
	private long numero;
	@Column
	private String bloque;
	@Column
	private long piso;
	@Column
	private String puerta;
	@Column
	private String ciudad;
	@Column
	private String provincia;
	@Column
	private String nacimiento;
	@Column
	private String nacionalidad;
	@Column
	private String lugarNacimiento;
	@Column
	private String sexo;
	@Column
	private boolean votoElectronico;

	public CensoModel(String nombre, String apellido1, String apellido2, long dni, String calle, long numero, String bloque,
			long piso, String puerta, String ciudad, String provincia, String nacimiento, String nacionalidad, 
			String lugarNacimiento, String sexo, boolean votoElectronico) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
		this.bloque = bloque;
		this.piso = piso;
		this.puerta = puerta;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.lugarNacimiento = lugarNacimiento;
		this.sexo = sexo;
		this.votoElectronico = votoElectronico;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public long getPiso() {
		return piso;
	}

	public void setPiso(long piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
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

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
