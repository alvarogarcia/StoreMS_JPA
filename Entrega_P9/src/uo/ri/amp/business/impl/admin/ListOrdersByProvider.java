package uo.ri.amp.business.impl.admin;

import java.util.List;

import alb.util.BusinessException;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.OrderFinder;
import uo.ri.model.Pedido;

/**
 * @author �lvaro Garc�a
 * 
 */
public class ListOrdersByProvider implements Command {

	Long providerCode;

	/**
	 * Constructor
	 * 
	 * @param providerCode
	 *            C�digo del proveedor
	 */
	public ListOrdersByProvider(Long providerCode) {
		this.providerCode = providerCode;
	}

	/**
	 * encuentra los pedidos dado un proveedor
	 * 
	 * @return Lista de Pedidos del proveedor dado
	 */
	@Override
	public List<Pedido> execute() throws BusinessException {

		return OrderFinder.findOrdersByProvider(providerCode);

	}
}
