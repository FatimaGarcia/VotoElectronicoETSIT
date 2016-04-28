package com.upm.isst.voto.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.upm.isst.voto.model.CEEModel;
import com.upm.isst.voto.model.PoliticosModel;
import com.upm.isst.voto.model.ProvinciasModel;

public class ProvinciasDAOImpl implements ProvinciasDAO {


private static ProvinciasDAOImpl instance;
	
	private ProvinciasDAOImpl() {
	}

	public static ProvinciasDAOImpl getInstance(){
		if (instance == null)
			instance = new ProvinciasDAOImpl();
		return instance;
	}

	@Override
	public ProvinciasModel create(String nombre, int numeroCandidatos) {
		EntityManager em = EMFService.get().createEntityManager();

		ProvinciasModel provincia = new ProvinciasModel(nombre, numeroCandidatos);
		em.persist(provincia);
		em.close();
		return provincia;
	}
	
	public List<ProvinciasModel> read(){
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from ProvinciasModel m"); 
		List<ProvinciasModel> res=q.getResultList();
		em.close();
		return res;
	};
	public int readNumeroCandidatos(String nombre){
		ProvinciasModel provincia = readNombre(nombre);
		return provincia.getNumeroCandidatos();
		
	}
	public ProvinciasModel readNombre(String nombre){
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from ProvinciasModel t where t.nombre = :nombre"); 
		q.setParameter("nombre", nombre);
		if (q.getResultList().size()>0){ 
			ProvinciasModel	entradaProvincias= (ProvinciasModel) (q.getResultList().get(0));
		em.close();
		return entradaProvincias;
		}else{
			return null;
		}
	}
	@Override
	public void update(String nombre) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(nombre);
				
		em.close();
	}

	@Override
	public void delete(String nombre) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			ProvinciasModel provincia = em.find(ProvinciasModel.class, nombre);
			em.remove(provincia);
		}finally{
			em.close();
		}
	}
	
	
}
