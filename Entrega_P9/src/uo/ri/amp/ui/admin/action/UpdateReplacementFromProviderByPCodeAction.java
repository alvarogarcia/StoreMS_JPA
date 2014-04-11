package uo.ri.amp.ui.admin.action;

import java.util.List;

import uo.ri.amp.conf.ServicesFactory;
import uo.ri.model.RepuestosProveedor;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

/**
 * @author Álvaro García
 * 
 */
public class UpdateReplacementFromProviderByPCodeAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long providerCode = Console.readLong("Codigo del proveedor");
		boolean numeroCorrecto = false;

		try {
			List<RepuestosProveedor> listadoRepuestosPorProveedor = ServicesFactory
					.getProviderService().checkWhatReplacementToUpdateOrDelete(
							new Long("0"), providerCode, false);

			// imprimo la lista de repuestos por proveedor encontrados
			int elemento = 1;
			for (RepuestosProveedor repProv : listadoRepuestosPorProveedor) {
				Console.print(elemento + ". ID Repuesto: "
						+ repProv.getRepuesto());
				Console.print("\tIDProveedor: " + repProv.getProveedor());
				Console.println("\tPrecio: " + repProv.getPrecio());
				elemento++;
			}

			int replacementToUpdate = 0;
			while (!numeroCorrecto && listadoRepuestosPorProveedor.size() > 0) {
				replacementToUpdate = Console
						.readInt("Introduzca el elemento a actualizar");
				if (replacementToUpdate > 0
						&& replacementToUpdate <= listadoRepuestosPorProveedor
								.size())
					numeroCorrecto = true;
				else
					Console.println("ERROR. El número debe estar comprendido" +
							" entre 1 y "
							+ listadoRepuestosPorProveedor.size());
			}

			if (listadoRepuestosPorProveedor.size() > 0) {
				Double newPrice = Console.readDouble("Nuevo precio");

				ServicesFactory.getProviderService()
						.updateReplacementFromProvider(
								(Long) listadoRepuestosPorProveedor
										.get(replacementToUpdate - 1)
										.getRepuesto().getId(), providerCode,
								newPrice);
			} else
				Console.println("No se han obtenido resultados con ese código" +
						" de proveedor");
		} catch (RuntimeException e) {
			Console.print("Ha ocurrido un error en la actualización. Por favor," +
					" verifique que los datos de entrada son correctos e" +
					" inténtelo de nuevo.\n");
		}

	}

}
