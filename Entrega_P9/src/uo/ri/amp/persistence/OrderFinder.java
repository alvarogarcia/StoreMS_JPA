package uo.ri.amp.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Pedido;

/**
 * @author alvaroastur4
 * 
 */
public class OrderFinder {

	/**
	 * Encuentra los pedidos buscando por el c�digo del proveedor
	 * 
	 * @param providerCode
	 *            C�digo del proveedor
	 * @return Pedidos a un proveedor
	 */
	@SuppressWarnings("unchecked")
	public static List<Pedido> findOrdersByProvider(Long providerCode) {

		return Jpa.getManager().createNamedQuery("Pedido.findOrdersByProvider")
				.setParameter(1, providerCode).getResultList();
	}

	/**
	 * Encuentra un pedido por su c�digo
	 * 
	 * @param orderCode
	 *            C�digo del pedido
	 * @return Pedido buscado
	 */
	public static Pedido findOrderByCode(Long orderCode) {
		// return (Pedido)
		// Jpa.getManager().createNamedQuery("Pedido.findOrderByCode").setParameter(1,
		// orderCode).getSingleResult();
		EntityManager entityManager = Jpa.getManager();

		Pedido pedido = entityManager.find(Pedido.class, orderCode);
		return pedido;
	}

}
