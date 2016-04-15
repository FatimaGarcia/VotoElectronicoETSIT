package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CensoModel;

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
	public CensoModel create(String nombre, String apellido1, String apellido2,
			long dni, String provincia, String partido, long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readApellido1(String apellido1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readApellido2(String apellido2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readDNI(long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readPartido(String partido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CensoModel> readCodigo(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CensoModel VOTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CensoModel VOTO) {
		// TODO Auto-generated method stub

	}

}
