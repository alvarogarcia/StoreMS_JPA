package uo.ri.amp.business.impl.admin;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.OrderFinder;
import uo.ri.model.Pedido;

/**
 * @author Álvaro García
 * 
 */
public class FindOrderByCode implements Command {

	Long orderCode;

	/**
	 * Constructor
	 * 
	 * @param orderCode
	 *            Código del pedido
	 */
	public FindOrderByCode(Long orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * encuentra el pedido dado su código de indentificación
	 * 
	 * @return Mapa con los datos del pedido
	 */
	@Override
	public Pedido execute() {
		return OrderFinder.findOrderByCode(orderCode);

	}

}
