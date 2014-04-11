package uo.ri.amp.business.impl;

import java.util.List;

import alb.util.BusinessException;

import uo.ri.amp.business.OrdersService;
import uo.ri.amp.business.impl.admin.FindOrderByCode;
import uo.ri.amp.business.impl.admin.ListOrdersByProvider;
import uo.ri.amp.business.impl.admin.UpdateOrderReceived;
import uo.ri.amp.business.impl.CommandExecutor;
import uo.ri.model.Pedido;

/**
 * @author Álvaro García
 * 
 */
public class OrdersServiceImpl implements OrdersService {

	CommandExecutor cE = new CommandExecutor();

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> listOrders(Long providerCode) throws BusinessException {
		return (List<Pedido>) cE
				.execute(new ListOrdersByProvider(providerCode));
	}

	@Override
	public Pedido findOrder(Long orderCode) throws BusinessException {
		return (Pedido) cE.execute(new FindOrderByCode(orderCode));
	}

	@Override
	public void updateOrderReceived(Pedido pedido) throws BusinessException {
		cE.execute(new UpdateOrderReceived(pedido));

	}

}
