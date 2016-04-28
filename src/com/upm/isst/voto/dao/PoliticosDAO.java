package com.upm.isst.voto.dao;

import java.util.List; 

import com.upm.isst.voto.model.PoliticosModel;

public interface PoliticosDAO {
	public PoliticosModel create(Long codigo, String nombreCompleto,
			 String provincia, String partido, int codPartido);
	public List<PoliticosModel> read();
	public List<PoliticosModel> readNombre(String nombreCompleto);
	public List<PoliticosModel> readProvincia(String provincia);
	public List<PoliticosModel> readPartido(String partido);
	public List<PoliticosModel> readCodigo(Long codigo);

	public void update(PoliticosModel politico);
	public void delete(Long codigo);
}
