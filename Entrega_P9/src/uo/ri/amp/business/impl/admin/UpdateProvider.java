package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 * 
 */
public class UpdateProvider implements Command {

	Long providerCode;
	String providerName;

	/**
	 * Constructor de la clase UpdateProvider
	 * 
	 * @param providerCode
	 *            Código del proveedor
	 * @param providerName
	 *            Nombre del proveedor
	 */
	public UpdateProvider(Long providerCode, String providerName) {
		this.providerCode = providerCode;
		this.providerName = providerName;
	}

	@Override
	public Object execute() throws BusinessException {
		Proveedor proveedor = Jpa.getManager().find(Proveedor.class,
				providerCode);
		proveedor.setNombre(providerName);
		return Jpa.getManager().merge(proveedor);
	}

}
