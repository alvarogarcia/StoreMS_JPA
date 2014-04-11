package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.ListOrdersByProviderAction;
import uo.ri.amp.ui.admin.action.ReceiveOrder;
import alb.util.menu.BaseMenu;

/**
 * @author �lvaro Garc�a
 * 
 */
public class OrdersMenu extends BaseMenu {

	/**
	 * Men� para los pedidos
	 */
	public OrdersMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gesti�n de Proveedores", null },
				{ "Recibir Pedido", ReceiveOrder.class },
				{ "Listar Pedidos por Proveedor",
						ListOrdersByProviderAction.class }, };
	}

	/**
	 * Ejecuta el men� principal para el administrador
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
