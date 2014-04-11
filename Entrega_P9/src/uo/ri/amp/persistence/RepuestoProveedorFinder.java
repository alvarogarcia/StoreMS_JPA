package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.RepuestosProveedor;

/**
 * @author alvaroastur4
 * 
 */
public class RepuestoProveedorFinder {

	/**
	 * Encuentra en la base de datos repuestos de un proveedor
	 * 
	 * @param replacementCode
	 *            Código del repuesto a buscar
	 * @param providerCode
	 *            Código del proveedor sobre el que se quiere encontrar el
	 *            repuesto
	 * @return Objeto de tipo RepuestosProveedor
	 */
	public static RepuestosProveedor findRepuestoProveedor(
			Long replacementCode, Long providerCode) {
		return (RepuestosProveedor) Jpa.getManager()
				.createNamedQuery("RepuestosProveedor.findReplacementProvider")
				.setParameter(1, replacementCode).setParameter(2, providerCode)
				.getSingleResult();
	}

	/**
	 * Encuentra todos los repuestos de todos los proveedores filtrando por
	 * código del repuesto
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @return todos los repuestos de todos los proveedores filtrando por código
	 *         del repuesto
	 */
	@SuppressWarnings("unchecked")
	public static List<RepuestosProveedor> findRPsByReplacementCode(
			Long replacementCode) {
		return Jpa
				.getManager()
				.createNamedQuery("RepuestosProveedor.findRPsByReplacementCode")
				.setParameter(1, replacementCode).getResultList();
	}

	/**
	 * Encuentra todos los repuestos de todos los proveedores filtrando por
	 * código del proveedor
	 * 
	 * @param providerCode
	 *            Código del proveedor
	 * @return todos los repuestos de todos los proveedores filtrando por código
	 *         del proveedor
	 */
	@SuppressWarnings("unchecked")
	public static List<RepuestosProveedor> findRPsByProviderCode(
			Long providerCode) {
		return Jpa.getManager()
				.createNamedQuery("RepuestosProveedor.findRPsByProviderCode")
				.setParameter(1, providerCode).getResultList();
	}

}
