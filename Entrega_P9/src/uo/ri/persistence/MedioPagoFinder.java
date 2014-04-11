package uo.ri.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import uo.ri.model.MedioPago;
import uo.ri.persistence.util.Jpa;

public class MedioPagoFinder {

	@SuppressWarnings("unchecked")
	public static List<MedioPago> findPaymentMeansByInvoiceId(Long idFactura) {
	
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("MedioPago.findByInvoiceId").setParameter(1, idFactura);
		return query.getResultList();
	}

	public static MedioPago findById(Long idMedio) {
	
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("MedioPago.findById").setParameter(1, idMedio);
		return (MedioPago) query.getSingleResult();
	}

}
