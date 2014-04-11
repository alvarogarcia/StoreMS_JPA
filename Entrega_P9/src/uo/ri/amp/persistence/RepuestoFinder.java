package uo.ri.amp.persistence;

import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Repuesto;

public class RepuestoFinder {

	/**
	 * Encuentra un repuesto buscando por su código
	 * 
	 * @param idReplacement
	 *            Código del repuesto
	 * @return Repuesto buscado
	 */
	public static Repuesto findReplacementByCode(Long idReplacement) {
		return (Repuesto) Jpa.getManager()
				.createNamedQuery("Repuesto.findReplacementById")
				.setParameter(1, idReplacement).getSingleResult();
	}

}
