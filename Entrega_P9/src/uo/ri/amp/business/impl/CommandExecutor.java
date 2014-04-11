package uo.ri.amp.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.ri.amp.persistence.util.Jpa;
import alb.util.BusinessException;

public class CommandExecutor {

	/**
	 * Ejecuta los comandos de la capa de negocio, creando un EntityManager y un
	 * EntityTransaction. Si todo funciona perfectamente hace commit y en caso
	 * de fallo hace rollback
	 * 
	 * @param comando
	 *            Comando a ejecutar
	 * @return
	 * @throws BusinessException
	 */
	public Object execute(Command comando) throws BusinessException {
		Object resultado = null;
		EntityManager eM = Jpa.createEntityManager();
		EntityTransaction eT = eM.getTransaction();
		eT.begin();

		try {
			resultado = comando.execute();
			eT.commit();
		} catch (BusinessException e) {
			eT.rollback();
			throw e;
		} catch (PersistenceException p) {
			eT.rollback();
			throw p;
		} finally {
			eM.close();
		}

		return resultado;

	}

}
