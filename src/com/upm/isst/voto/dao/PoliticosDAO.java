package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.PoliticosModel;

public interface PoliticosDAO {
	public PoliticosModel create(String nombre, String apellido1, String apellido2, long dni, 
			 String provincia, String partido, long codigo);
	public List<PoliticosModel> read();
	public List<PoliticosModel> readNombre(String nombre);
	public List<PoliticosModel> readApellido1(String apellido1);
	public List<PoliticosModel> readApellido2(String apellido2);
	public List<PoliticosModel> readDNI(long dni);
	public List<PoliticosModel> readProvincia(String provincia);
	public List<PoliticosModel> readPartido(String partido);
	public List<PoliticosModel> readCodigo(long codigo);

	public void update(PoliticosModel VOTO);
	public void delete(PoliticosModel VOTO);
}
