package uo.ri.amp.ui.admin.action;

import java.util.List;

import uo.ri.amp.conf.ServicesFactory;
import uo.ri.model.Proveedor;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

/**
 * @author Álvaro García
 * 
 */
public class UpdateProviderNameByNameAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String nameProviderBeforeUpdating = Console.readString("Nombre actual");
		boolean numeroCorrecto = false;

		try {

			List<Proveedor> listadoProveedores = ServicesFactory
					.getProviderService().checkWhatProviderToUpdate(
							nameProviderBeforeUpdating);

			// imprimo la lista de códigos y nombres
			int elemento = 1;
			for (Proveedor proveedor : listadoProveedores) {
				Console.print(elemento + ". ID: " + proveedor.getId());
				Console.println("\tNombre: " + proveedor.getNombre());
				elemento++;
			}

			int proveedorDeLaLista = 0;
			while (!numeroCorrecto && listadoProveedores.size() > 0) {
				proveedorDeLaLista = Console
						.readInt("Introduzca el elemento a actualizar");
				if (proveedorDeLaLista > 0
						&& proveedorDeLaLista <= listadoProveedores.size())
					numeroCorrecto = true;
				else
					Console.println("ERROR. El número debe estar comprendido" +
							" entre 1 y "
							+ listadoProveedores.size());
			}
			if (listadoProveedores.size() > 0) {
				String providerName = Console
						.readString("Nombre nuevo del proveedor");

				ServicesFactory.getProviderService().updateProvider(
						(Long) listadoProveedores.get(proveedorDeLaLista - 1)
								.getId(), providerName);
			} else
				Console.println("No se ha encontrado ningún proveedor con ese" +
						" nombre");
		} catch (RuntimeException e) {
			Console.print("Ha habido un error en la actualización. Por favor," +
					" verifique que los datos de entrada son correctos e" +
					" inténtelo de nuevo.\n");
		}

	}

}
