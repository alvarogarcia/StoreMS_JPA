package uo.ri.business.impl.admin;



import uo.ri.business.impl.Command;

import uo.ri.model.Mecanico;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

public class DeleteMechanic implements Command{

	private Long idMecanico;

	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	public Object execute() throws BusinessException {
		// Un mecanico no se podr� borrar si ya ha hecho intervenciones o 
		// tiene averias asignadas
		//EntityManager eT = Jpa.getManager();
		Mecanico mecanico = Jpa.getManager().find(Mecanico.class, idMecanico);
		if(mecanico.getIntervenciones().size() == 0){
			// Como no tiene intervenciones, puedo borrar al mec�nico
			Jpa.getManager().remove(mecanico);
			
			
		} else
			throw new BusinessException("ERROR. No se puede borrar al mec�nico ya que tiene alguna intervenci�n en proceso");

		return null;
	}

}
