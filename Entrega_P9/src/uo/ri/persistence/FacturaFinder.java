package uo.ri.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import uo.ri.model.Factura;
import uo.ri.persistence.util.Jpa;

public class FacturaFinder {

	public static Factura findByNumber(Long numero) {
	
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("Factura.findByNumber").setParameter(1, numero);
		return (Factura) query.getSingleResult();
	}

	public static Factura findById(Long id) {
	
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("Factura.findByNumber").setParameter(1, id);
		return (Factura) query.getSingleResult();
	}

	public static Long getNextInvoiceNumber() { // Puse Long mayúscula para que permita el null. Tenía long
	
		EntityManager eM = Jpa.getManager();
		Query query = eM.createNamedQuery("Factura.getNextInvoiceNumber");
		return  (Long) query.getSingleResult();
	}

}
