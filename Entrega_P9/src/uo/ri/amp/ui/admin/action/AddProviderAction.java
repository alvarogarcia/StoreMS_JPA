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
public class AddProviderAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String providerName = Console.readString("nombre del proveedor");

		try {

			ServicesFactory.getProviderService().addProvider(providerName);

		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error al a�adir el proveedor. Por " +
					"favor, compruebe que los datos de entrada son correctos" +
					" e int�ntelo de nuevo\n");
		}

	}

}
