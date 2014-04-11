package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 * 
 */
public class FindProviderByCode implements Command {

	Long providerCode;

	/**
	 * Constructor de la clase FindProviderByCode
	 * 
	 * @param providerCode
	 *            Código del proveedor
	 */
	public FindProviderByCode(Long providerCode) {
		this.providerCode = providerCode;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().find(Proveedor.class, providerCode);
	}

}
