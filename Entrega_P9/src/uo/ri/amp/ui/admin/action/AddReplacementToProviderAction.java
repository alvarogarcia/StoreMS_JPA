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
public class AddReplacementToProviderAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long replacementCode = Console.readLong("id del Repuesto");
		Long providerCode = Console.readLong("id del Proveedor");
		Double price = Console.readDouble("Precio del repuesto");

		try {

			ServicesFactory.getProviderService().addReplacementToProvider(
					replacementCode, providerCode, price);

		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error al a�adir el repuesto al " +
					"proveedor. Por favor, verifique que los datos de entrada" +
					" son correctos e int�ntelo de nuevo.\n");
		}

	}

}
