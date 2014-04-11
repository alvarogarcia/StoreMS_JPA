package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 * 
 */
public class AddProvider implements Command {

	private Proveedor proveedor;

	/**
	 * Constructor de la clase AddProvider
	 * 
	 * @param name
	 *            Nombre del proveedor a añadir
	 */
	public AddProvider(String name) {
		this.proveedor = new Proveedor(null, name);
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(proveedor);

		return proveedor;
	}

}
