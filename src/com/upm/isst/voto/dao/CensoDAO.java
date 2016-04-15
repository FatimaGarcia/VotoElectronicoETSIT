package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CensoModel;

public interface CensoDAO {
	public CensoModel create(Long dni, String nombre, String apellido1, String apellido2, long codigoPostal,
			String ciudad, String provincia, String nacimiento, String nacionalidad, 
			 String sexo, boolean votoElectronico);
	public List<CensoModel> read();
	public List<CensoModel> readNombre(String nombre);
	public List<CensoModel> readApellido1(String apellido1);
	public List<CensoModel> readApellido2(String apellido2);
	public List<CensoModel> readDNI(Long dni);
	public List<CensoModel> readCodigoPostal(long numero);
	public List<CensoModel> readCiudad(String ciudad);
	public List<CensoModel> readProvincia(String provincia);
	public List<CensoModel> readNacimiento(String nacimiento);
	public List<CensoModel> readNacionalidad(String nacionalidad);
	public List<CensoModel> readSexo(String sexo);
	public List<CensoModel> readVotoElectronico(Boolean votoElectronico);
	public void update(CensoModel votante);
	public void delete(CensoModel votante);
}
