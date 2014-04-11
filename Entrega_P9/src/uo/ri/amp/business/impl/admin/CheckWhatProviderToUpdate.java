package uo.ri.amp.business.impl.admin;

import java.util.List;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.ProveedorFinder;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 * 
 */
public class CheckWhatProviderToUpdate implements Command {

	String nameProviderBeforeUpdating;

	/**
	 * Constructor de la clase CheckWhatProviderToUpdate
	 * 
	 * @param nameProviderBeforeUpdating
	 *            Nombre del proveedor antes de actualizar su nombre
	 */
	public CheckWhatProviderToUpdate(String nameProviderBeforeUpdating) {
		this.nameProviderBeforeUpdating = nameProviderBeforeUpdating;
	}

	@Override
	public Object execute() throws BusinessException {
		List<Proveedor> proveedores = ProveedorFinder
				.findProvidersByName(nameProviderBeforeUpdating);

		return proveedores;
	}

}
