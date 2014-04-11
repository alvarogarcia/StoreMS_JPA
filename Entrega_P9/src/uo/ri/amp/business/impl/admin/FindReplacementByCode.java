package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.RepuestoFinder;

/**
 * @author alvaroastur4
 * 
 */
public class FindReplacementByCode implements Command {

	Long idReplacement;

	/**
	 * Constructor de la clase FindReplacementByCode
	 * 
	 * @param idReplacement
	 *            Código del repuesto
	 */
	public FindReplacementByCode(Long idReplacement) {
		this.idReplacement = idReplacement;
	}

	@Override
	public Object execute() throws BusinessException {
		return RepuestoFinder.findReplacementByCode(idReplacement);
	}

}
