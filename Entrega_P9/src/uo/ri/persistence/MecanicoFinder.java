package uo.ri.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import uo.ri.model.Mecanico;
import uo.ri.persistence.util.Jpa;

public class MecanicoFinder {

	public static Mecanico findById(Long id) {
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("Mecanico.findById").setParameter(1, id);
		return (Mecanico) query.getSingleResult();
		
	}

	@SuppressWarnings("unchecked")
	public static List<Mecanico> findAll() {
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("Mecanico.findAll");
		return query.getResultList();
	}
	
	

}
