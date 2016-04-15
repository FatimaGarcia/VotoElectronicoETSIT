package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CensoModel;

public interface PoliticosDAO {
	public CensoModel create(String nombre, String apellido1, String apellido2, long dni, 
			 String provincia, String partido, long codigo);
	public List<CensoModel> read();
	public List<CensoModel> readNombre(String nombre);
	public List<CensoModel> readApellido1(String apellido1);
	public List<CensoModel> readApellido2(String apellido2);
	public List<CensoModel> readDNI(long dni);
	public List<CensoModel> readProvincia(String provincia);
	public List<CensoModel> readPartido(String partido);
	public List<CensoModel> readCodigo(long codigo);

	public void update(CensoModel VOTO);
	public void delete(CensoModel VOTO);
}
