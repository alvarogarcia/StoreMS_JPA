package uo.ri.business.impl.admin;



import uo.ri.business.impl.Command;
import uo.ri.model.Mecanico;
import uo.ri.persistence.util.Jpa;

public class AddMechanic implements Command {

	private Mecanico mecanico;

	public AddMechanic(Mecanico mecanico){
		this.mecanico = mecanico;
	}

	public Object execute() {
		// persistence-unit name (file persistence.xml)
		//EntityManager eM = Jpa.getManager();
		//EntityTransaction eT = eM.getTransaction();
		
		//eT.begin();
		//eM.persist(mecanico);
		Jpa.getManager().persist(mecanico);
		//eT.commit();
		//eM.close();
		
		return mecanico;
	}

}
