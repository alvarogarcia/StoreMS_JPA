package uo.ri.amp.business;

import java.util.List;

import alb.util.BusinessException;

import uo.ri.model.Pedido;

/**
 * @author Álvaro García
 * 
 */
public interface OrdersService {

	/**
	 * @param providerCode
	 *            Código del proveedor
	 * @return Lista de pedidos del proveedor dado. Ordenados por fecha
	 *         descendientemente, y primero los pendientes
	 * @throws BusinessException
	 */
	public List<Pedido> listOrders(Long providerCode) throws BusinessException;

	/**
	 * @param orderCode
	 *            Código del pedido
	 * @return Devuelve un mapa que contiene los datos de un pedido
	 * @throws BusinessException
	 */
	public Pedido findOrder(Long orderCode) throws BusinessException;

	/**
	 * Establece un pedido como recibido => actualiza campos fecha_recepción y
	 * estado_pedido
	 * 
	 * @param pedido
	 *            Mapa con los datos del pedido
	 * @throws BusinessException
	 */
	public void updateOrderReceived(Pedido pedido) throws BusinessException;

}
