package uo.ri.amp.conf;

import uo.ri.amp.business.OrdersService;
import uo.ri.amp.business.ProviderService;
import uo.ri.amp.business.impl.OrdersServiceImpl;
import uo.ri.amp.business.impl.ProviderServiceImpl;

import uo.ri.business.ForemanService;
import uo.ri.business.MechanicService;
import uo.ri.amp.business.impl.CommandExecutor;

/**
 * @author alvaroastur4
 * 
 */
public class ServicesFactory {

	/**
	 * Factoría que devuelve un servicio de Proveedor
	 * 
	 * @return servicio de proveedor
	 */
	public static ProviderService getProviderService() {
		return new ProviderServiceImpl();

	}

	/**
	 * Factoría que devuelve un servicio de Pedidos
	 * 
	 * @return servicio de pedidos
	 */
	public static OrdersService getOrdersService() {
		return new OrdersServiceImpl();
	}

	/**
	 * Retorna el command executor
	 * 
	 * @return CommandExecutor
	 */
	public static CommandExecutor getCommandExecutor() {
		return new CommandExecutor();
	}

	/**
	 * Retorna el serivcio para los mecánicos
	 * 
	 * @return
	 */
	public static MechanicService getMechanicService() {
		return null;
	}

	/**
	 * Retorna el servicio para el administrador
	 * 
	 * @return
	 */
	public static ForemanService getForemanService() {
		return null;
	}
}
