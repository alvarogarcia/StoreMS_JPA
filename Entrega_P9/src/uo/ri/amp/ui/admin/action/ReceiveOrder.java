package uo.ri.amp.ui.admin.action;

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
public class ReceiveOrder implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idPedido = Console.readLong("Código del pedido");

		try {

			Pedido pedido = ServicesFactory.getOrdersService().findOrder(
					idPedido);
			// Compruebo que la información es correcta imprimiendo los detalles
			// del pedido.
			Console.print("Pedido:\n" + pedido.toString()
					+ "\n\n ---- Items del Pedido----");
			for (ItemPedido iP : pedido.getItemsPedido())
				Console.print(iP.toString() + "\n");

			// Una vez impresos los detalles del pedido, preguntamos al usuario
			// si es el pedido correcto
			// para poder continuar

			String pedidoCorrecto = Console
					.readString("\n\n¿Es el pedido correcto? S/N");

			if (pedidoCorrecto.equalsIgnoreCase("S")) {
				ServicesFactory.getOrdersService().updateOrderReceived(pedido);
			} else { // En caso de que el pedido no sea el correcto no hago
						// nada.
				Console.print("Operación anulada");
			}

		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error al recibir el pedido. " +
					"Por favor, inténtelo de nuevo");
		}

	}
}
