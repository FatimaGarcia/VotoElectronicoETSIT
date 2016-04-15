package com.upm.isst.voto.dao;

import java.util.List;

import com.upm.isst.voto.model.CensoModel;

public class CEEDAOImpl implements CEEDAO {

	private static CEEDAOImpl instance;
	
	public CEEDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public static CEEDAOImpl getInstance(){
		if (instance == null)
			instance = new CEEDAOImpl();
		return instance;
	}
	
	@Override
	public CensoModel create(String nombre, String apellido1, String apellido2,
			long dni, String provincia, String contrasena) {
		// TODO Auto-generated method stub
		//EntityManager e m = EMFService.get().createEntityManager();
		//Hacer lo que sea con la bbdd
		//em.close();
		
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
	public List<CensoModel> readContrasena(String contrasena) {
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
