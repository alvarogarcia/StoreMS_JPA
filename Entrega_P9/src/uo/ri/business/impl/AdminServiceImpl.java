package uo.ri.business.impl;

import java.util.List;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.AddMechanic;
import uo.ri.business.impl.admin.DeleteMechanic;
import uo.ri.business.impl.admin.FindAllMechanics;
import uo.ri.business.impl.admin.FindMechanicById;
import uo.ri.business.impl.admin.UpdateMechanic;
import uo.ri.model.Mecanico;
import alb.util.BusinessException;

public class AdminServiceImpl implements AdminService {
	
	CommandExecutor cE = new CommandExecutor();

	@Override
	public void newMechanic(Mecanico mecanico) throws BusinessException {
		cE.execute(new AddMechanic( mecanico ));
	}

	@Override
	public void updateMechanic(Mecanico mecanico) throws BusinessException {
		cE.execute(new UpdateMechanic( mecanico ));
	}

	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException {
		cE.execute(new DeleteMechanic(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> findAllMechanics() throws BusinessException {
		return (List<Mecanico>) cE.execute(new FindAllMechanics());
		
	}

	@Override
	public Mecanico findMechanicById(Long id) throws BusinessException {
		return (Mecanico) cE.execute(new FindMechanicById(id));
	}

}
