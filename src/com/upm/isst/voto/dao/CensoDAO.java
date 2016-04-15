package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CensoModel;

public interface CensoDAO {
	public CensoModel create(String nombre, String apellido1, String apellido2, long dni, String calle, long numero, String bloque,
			long piso, String puerta, String ciudad, String provincia, String nacimiento, String nacionalidad, 
			String lugarNacimiento, String sexo, boolean votoElectronico);
	public List<CensoModel> read();
	public List<CensoModel> readNombre(String nombre);
	public List<CensoModel> readApellido1(String apellido1);
	public List<CensoModel> readApellido2(String apellido2);
	public List<CensoModel> readDNI(int dni);
	public List<CensoModel> readCalle(String calle);
	public List<CensoModel> readNumero(int numero);
	public List<CensoModel> readBloque(String bloque);
	public List<CensoModel> readApellido2(int piso);
	public List<CensoModel> readPuerta(String puerta);
	public List<CensoModel> readCiudad(String ciudad);
	public List<CensoModel> readProvincia(String provincia);
	public List<CensoModel> readNacimiento(String nacimineto);
	public List<CensoModel> readNacionalidad(String nacionalidad);
	public List<CensoModel> readLugarNacimiento(String lugarNacimiento);
	public List<CensoModel> readSexo(String sexo);
	public List<CensoModel> readVotoElectronico(Boolean votoElectronico);
	public void update(CensoModel VOTO);
	public void delete(CensoModel VOTO);
}
