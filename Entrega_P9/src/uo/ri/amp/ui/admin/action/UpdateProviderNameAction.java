package uo.ri.amp.ui.admin.action;

import uo.ri.amp.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

/**
 * @author Álvaro García
 * 
 */
public class UpdateProviderNameAction implements Action {

	@Override
	public void execute() throws BusinessException {

		Long idProveedor = Console.readLong("id del proveedor a actualizar");
		String providerName = Console.readString("Nombre nuevo del proveedor");

		try {

			ServicesFactory.getProviderService().updateProvider(idProveedor,
					providerName);

		} catch (RuntimeException e) {
			Console.print("No se ha podido completar la modificación. "
					+ "Verifique que el id del proveedor a actualizar exista.\n");
		}
	}

}
