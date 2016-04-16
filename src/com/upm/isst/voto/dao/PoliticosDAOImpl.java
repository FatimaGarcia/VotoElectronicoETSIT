package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.PoliticosModel;

public class PoliticosDAOImpl implements PoliticosDAO {


private static PoliticosDAOImpl instance;
	
	public PoliticosDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public static PoliticosDAOImpl getInstance(){
		if (instance == null)
			instance = new PoliticosDAOImpl();
		return instance;
	}

	@Override
	public PoliticosModel create(String nombre, String apellido1, String apellido2,
			long dni, String provincia, String partido, long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readApellido1(String apellido1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readApellido2(String apellido2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readDNI(long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readPartido(String partido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticosModel> readCodigo(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PoliticosModel VOTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PoliticosModel VOTO) {
		// TODO Auto-generated method stub

	}

}
