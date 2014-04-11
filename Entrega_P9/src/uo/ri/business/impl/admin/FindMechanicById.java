package uo.ri.business.impl.admin;



import uo.ri.business.impl.Command;
import uo.ri.model.Mecanico;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

public class FindMechanicById implements Command{

	private Long id;

	public FindMechanicById(Long id) {
		this.id = id;
	}

	public Object execute() throws BusinessException {
	
		return Jpa.getManager().find(Mecanico.class, id);
	}

}
