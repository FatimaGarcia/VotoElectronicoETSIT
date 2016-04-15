package com.upm.isst.voto.dao;

import java.util.Date;
import java.util.List;

import com.upm.isst.voto.model.CensoModel;

import javax.persistence.*;

public class CensoDAOImpl implements CensoDAO {

private static CensoDAOImpl instance;
	
	private CensoDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public static CensoDAOImpl getInstance(){
		if (instance == null)
			instance = new CensoDAOImpl();
		return instance;
	}
	@Override
	public CensoModel create(long dni, String nombre, String apellido1, String apellido2,
			  long codigoPostal, String ciudad, String provincia, Date nacimiento, String lugarNacimiento,
			String nacionalidad,  String sexo, boolean votoElectronico) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		CensoModel votante = new CensoModel(dni, nombre, apellido1, apellido2, codigoPostal, ciudad, provincia,
											nacimiento, nacionalidad, lugarNacimiento, sexo, votoElectronico);
		em.persist(votante);
		em.close();
		return votante;
	}

	@Override
	public List<CensoModel> read() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t");

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}
	@Override
	public List<CensoModel> readDNI(long dni) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.dni = :dni");
		q.setParameter("dni", dni);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}
	
	@Override
	public List<CensoModel> readNombre(String nombre) {
		EntityManager em = EMFService.get().createEntityManager();
					
		Query q = em.createQuery("select t from CensoModel t where t.nombre = :nombre");
		q.setParameter("nombre", nombre);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readApellido1(String apellido1) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.apellido1 = :apellido1");
		q.setParameter("apellido1", apellido1);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readApellido2(String apellido2) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.apellido2 = :apellido2");
		q.setParameter("apellido2", apellido2);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readCodigoPostal(long codigoPostal) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.codigoPostal = :codigoPostal");
		q.setParameter("codigoPostal", codigoPostal);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}


	@Override
	public List<CensoModel> readCiudad(String ciudad) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.ciudad = :ciudad");
		q.setParameter("ciudad", ciudad);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readProvincia(String provincia) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.provincia = :provincia");
		q.setParameter("provincia", provincia);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readNacimiento(Date nacimiento) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.nacimiento = :nacimiento");
		q.setParameter("nacimiento", nacimiento);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}
	
	@Override
	public List<CensoModel> readLugarNacimiento(String lugarNacimiento) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.lugarNacimiento = :lugarNacimiento");
		q.setParameter("lugarNacimiento", lugarNacimiento);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}
	
	@Override
	public List<CensoModel> readNacionalidad(String nacionalidad) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.nacionalidad = :nacionalidad");
		q.setParameter("nacionalidad", nacionalidad);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	

	@Override
	public List<CensoModel> readSexo(String sexo) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.sexo = :sexo");
		q.setParameter("sexo", sexo);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public List<CensoModel> readVotoElectronico(Boolean votoElectronico) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from CensoModel t where t.votoElectronico = :votoElectronico");
		q.setParameter("votoElectronico", votoElectronico);

		List<CensoModel> votantes = q.getResultList();
		em.close();
		return votantes;
	}

	@Override
	public void update(CensoModel votante) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(votante);
				
		em.close();
	}

	@Override
	public void delete(CensoModel votante) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.remove(votante);
				
		em.close();
	}

}
