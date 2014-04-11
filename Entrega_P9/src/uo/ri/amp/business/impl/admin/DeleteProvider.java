package uo.ri.amp.business.impl.admin;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.Proveedor;

/**
 * @author alvaroastur4
 *
 */
public class DeleteProvider implements Command {
	
	private Long idProvider;
	
	/**
	 * Constructor de la clase DeleteProvider
	 * @param idProvider id del Proveedor a eliminar
	 */
	public DeleteProvider(Long idProvider){
		this.idProvider = idProvider;
	}

	@Override
	public Object execute() throws BusinessException {
		Proveedor proveedor = Jpa.getManager().find(Proveedor.class, idProvider);
		if(proveedor.getPedidos().size() > 0){
			throw new RuntimeException("ERROR. No se puede eliminar un" +
					" proveedor si hay pedidos para el mismo");
		}
		
		Jpa.getManager().remove(proveedor);
		
		return null;
	}

}
