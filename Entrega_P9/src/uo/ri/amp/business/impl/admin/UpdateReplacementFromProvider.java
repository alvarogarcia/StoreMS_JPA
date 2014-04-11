package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.RepuestoProveedorFinder;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.RepuestosProveedor;

/**
 * @author alvaroastur4
 * 
 */
public class UpdateReplacementFromProvider implements Command {

	Long replacementCode, providerCode;
	Double newPrice;

	/**
	 * Constructor de la clase UpdateReplacementFromProvider
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @param providerCode
	 *            Código del proveedor
	 * @param newPrice
	 *            Nuevo precio
	 */
	public UpdateReplacementFromProvider(Long replacementCode,
			Long providerCode, Double newPrice) {
		this.replacementCode = replacementCode;
		this.providerCode = providerCode;
		this.newPrice = newPrice;
	}

	@Override
	public Object execute() throws BusinessException {
		RepuestosProveedor replacementToUpdate = RepuestoProveedorFinder
				.findRepuestoProveedor(replacementCode, providerCode);
		replacementToUpdate.setPrecio(newPrice);
		return Jpa.getManager().merge(replacementToUpdate);
	}

}
