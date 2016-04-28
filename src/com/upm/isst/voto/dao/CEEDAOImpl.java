package com.upm.isst.voto.dao;

import java.util.List;  

import javax.persistence.*;

import com.upm.isst.voto.model.CEEModel;

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
	public CEEModel create(Long dni, String nombre, String apellido1, String apellido2,
			 String provincia, String contrasena) {
		
		CEEModel entradaCEE = null;
		
		EntityManager em = EMFService.get().createEntityManager();
		entradaCEE = new CEEModel(dni, nombre, apellido1, apellido2, provincia, contrasena);
		em.persist(entradaCEE);
		em.close();
		
		return entradaCEE;
	}

	
	
	@Override
	public List<CEEModel> read() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from CEEModel m"); 
		List<CEEModel> res=q.getResultList();
		em.close();
		return res;
	}

	
	@Override
	public List<CEEModel> readNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CEEModel> readApellido1(String apellido1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CEEModel> readApellido2(String apellido2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CEEModel readDNI(Long dni) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from CEEModel t where t.dni = :dni"); 
		q.setParameter("dni", dni);
		if (q.getResultList().size()>0){ 
		CEEModel entradaCEE= (CEEModel) (q.getResultList().get(0));
		em.close();
		return entradaCEE;
		}else{
			return null;
		}
	}

	@Override
	public List<CEEModel> readProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean readContrasena(String contrasena, Long dni) {
		CEEModel entradaCEE= readDNI(dni);
		if (entradaCEE.getContrasena().equals(contrasena)) return true;
		return false;
	}
	
	public String readProvincia(Long dni) {
		CEEModel entradaCEE= readDNI(dni);
		return entradaCEE.getProvincia();
	}
	
	public Boolean readVoto(Long dni) {
		CEEModel entradaCEE= readDNI(dni);
		return entradaCEE.getVoto();
	}

	@Override
	public void update(CEEModel votante) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(votante);
				
		em.close();
	}

	@Override
	public void delete(Long dni) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			CEEModel votante = em.find(CEEModel.class, dni);
			em.remove(votante);
		}finally{
			em.close();
		}
	}

}
