package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;
import uo.ri.model.Repuesto;
import uo.ri.model.RepuestosProveedor;

/**
 * @author alvaroastur4
 * 
 */
public class AddReplacementToProvider implements Command {

	Long replacementCode, providerCode;
	Double price;

	/**
	 * Constructor de la clase AddReplacementToProvider
	 * 
	 * @param replacementCode
	 *            Código de repuesto a añadir al proveedor
	 * @param providerCode
	 *            Código del proveedor al que se le va a añadir el repuesto
	 * @param price
	 *            Precio del repuesto para ese proveedor
	 */
	public AddReplacementToProvider(Long replacementCode, Long providerCode,
			Double price) {
		this.replacementCode = replacementCode;
		this.providerCode = providerCode;
		this.price = price;
	}

	@Override
	public Object execute() throws BusinessException {
		Repuesto repuesto = Jpa.getManager().find(Repuesto.class,
				replacementCode);
		Proveedor proveedor = Jpa.getManager().find(Proveedor.class,
				providerCode);
		RepuestosProveedor repuestoProveedor = new RepuestosProveedor(repuesto,
				proveedor, price);
		Jpa.getManager().persist(repuestoProveedor);

		return repuestoProveedor;
	}

}
