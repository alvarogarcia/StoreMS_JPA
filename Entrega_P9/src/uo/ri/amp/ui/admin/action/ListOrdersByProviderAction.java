package uo.ri.amp.ui.admin.action;

import java.util.List;

import uo.ri.amp.conf.ServicesFactory;
import uo.ri.model.ItemPedido;
import uo.ri.model.Pedido;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

/**
 * @author Álvaro García
 * 
 */
public class ListOrdersByProviderAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idProveedor = Console.readLong("id del proveedor");

		try {

			// IMPRIMIR EN PANTALLA LOS PEDIDOS
			List<Pedido> pedidos = ServicesFactory.getOrdersService()
					.listOrders(idProveedor);

			for (Pedido pedido : pedidos) {
				Console.print(pedido.toString());
				for (ItemPedido iP : pedido.getItemsPedido())
					Console.print("\t\t" + iP.toString());

			}

		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error al recuperar los pedidos del" +
					" proveedor. Por favor, verifique que el proveedor exista" +
					" e inténtelo de nuevo.\n");
		}

	}

}
