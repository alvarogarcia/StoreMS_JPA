package uo.ri.amp.ui.admin.action;

import uo.ri.amp.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

/**
 * @author �lvaro Garc�a
 * 
 */
public class DeleteReplacementToProviderAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idReplacement = Console.readLong("id del repuesto");
		Long idProvider = Console.readLong("id del proveedor");

		try {

			// En caso de que haya alg�n pedido de este proveedor y con este
			// repuesto no
			// voy a poder eliminarlo.

			ServicesFactory.getProviderService().deleteReplacementFromProvider(
					idReplacement, idProvider);

		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error al eliminar el repuesto del" +
					" proveedor. Por favor, verifique que los datos de entrada" +
					" son correctos e int�ntelo de nuevo");
		}

	}

}
