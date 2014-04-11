package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 * 
 */
public class ProveedorFinder {

	/**
	 * encuentra un proveedor buscando por su nombre
	 * 
	 * @param nameProviderBeforeUpdating
	 *            Nombre del proveedor buscado
	 * @return Proveedor buscado
	 */
	@SuppressWarnings("unchecked")
	public static List<Proveedor> findProvidersByName(
			String nameProviderBeforeUpdating) {
		return Jpa.getManager()
				.createNamedQuery("Proveedor.findProvidersByName")
				.setParameter(1, nameProviderBeforeUpdating).getResultList();
	}

	/**
	 * Encuentra un proveedor buscado por su identificador
	 * 
	 * @param providerCode
	 *            id del proveedor buscado
	 * @return Proveedor buscado
	 */
	public static Proveedor findProviderByCode(Long providerCode) {
		return (Proveedor) Jpa.getManager()
				.createNamedQuery("Proveedor.findProviderByCode")
				.setParameter(1, providerCode).getSingleResult();
	}

}
