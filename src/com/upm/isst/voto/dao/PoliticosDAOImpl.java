package com.upm.isst.voto.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.upm.isst.voto.model.CEEModel;
import com.upm.isst.voto.model.CensoModel;
import com.upm.isst.voto.model.PoliticosModel;

public class PoliticosDAOImpl implements PoliticosDAO {


private static PoliticosDAOImpl instance;
	
	private PoliticosDAOImpl() {
	}

	public static PoliticosDAOImpl getInstance(){
		if (instance == null)
			instance = new PoliticosDAOImpl();
		return instance;
	}

	@Override
	public PoliticosModel create(Long codigo, String nombreCompleto,
							String provincia, String partido, int codPartido) {
		EntityManager em = EMFService.get().createEntityManager();

		PoliticosModel politico = new PoliticosModel(codigo, nombreCompleto, provincia, partido, codPartido);
		em.persist(politico);
		em.close();
		return politico;
	}

	@Override
	public List<PoliticosModel> read() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from PoliticosModel t");

		List<PoliticosModel> politicos = q.getResultList();
		em.close();
		return politicos;
	}

	@Override
	public List<PoliticosModel> readNombre(String nombreCompleto) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from PoliticosModel t where t.nombreCompleto order by t.partido = :nombreCompleto");
		q.setParameter("nombreCompleto", nombreCompleto);

		List<PoliticosModel> politicos = q.getResultList();
		em.close();
		return politicos;
	}

	@Override
	public List<PoliticosModel> readProvincia(String provincia) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from PoliticosModel t where t.provincia = :provincia");
		q.setParameter("provincia", provincia);

		List<PoliticosModel> politicos = q.getResultList();
		em.close();
		return politicos;
	}

	@Override
	public List<PoliticosModel> readPartido(String partido) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from PoliticosModel t where t.partido = :partido");
		q.setParameter("partido", partido);

		List<PoliticosModel> politicos = q.getResultList();
		em.close();
		return politicos;
	}

	@Override
	public List<PoliticosModel> readCodigo(Long codigo) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from PoliticosModel t where t.codigo = :codigo");
		q.setParameter("codigo", codigo);

		List<PoliticosModel> politicos = q.getResultList();
		em.close();
		return politicos;
	}

	@Override
	public void update(PoliticosModel politico) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(politico);
				
		em.close();
	}

	@Override
	public void delete(Long codigo) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			PoliticosModel politico = em.find(PoliticosModel.class, codigo);
			em.remove(politico);
		}finally{
			em.close();
		}
	}

}
