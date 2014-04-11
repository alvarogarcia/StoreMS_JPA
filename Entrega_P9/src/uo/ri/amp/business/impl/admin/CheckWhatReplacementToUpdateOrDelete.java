package uo.ri.amp.business.impl.admin;

import java.util.List;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.RepuestoProveedorFinder;
import uo.ri.model.RepuestosProveedor;

/**
 * @author alvaroastur4
 * 
 */
public class CheckWhatReplacementToUpdateOrDelete implements Command {

	Long replacementCode, providerCode;
	boolean isReplacementCode;

	/**
	 * Constructor
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @param providerCode
	 *            Código del proveedor
	 * @param isReplacementCode
	 *            Determina si el filtrado se va a hacer por código de repuesto
	 *            (true) o por código de proveedor (false)
	 */
	public CheckWhatReplacementToUpdateOrDelete(Long replacementCode,
			Long providerCode, boolean isReplacementCode) {
		this.replacementCode = replacementCode;
		this.providerCode = providerCode;
		this.isReplacementCode = isReplacementCode;
	}

	/**
	 * comprueba los repuestos dado un proveedor
	 * 
	 * @return Lista de Repuestos sus proveedores, una vez realizado el filtrado
	 */
	@Override
	public Object execute() throws BusinessException {
		List<RepuestosProveedor> repuestosProveedor;
		if (isReplacementCode) {
			repuestosProveedor = RepuestoProveedorFinder
					.findRPsByReplacementCode(replacementCode);
		} else {
			repuestosProveedor = RepuestoProveedorFinder
					.findRPsByProviderCode(providerCode);
		}
		return repuestosProveedor;
	}

}
