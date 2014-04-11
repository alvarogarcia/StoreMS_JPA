package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.ListOrdersByProviderAction;
import uo.ri.amp.ui.admin.action.ReceiveOrder;
import alb.util.menu.BaseMenu;

/**
 * @author Álvaro García
 * 
 */
public class OrdersMenu extends BaseMenu {

	/**
	 * Menú para los pedidos
	 */
	public OrdersMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de Proveedores", null },
				{ "Recibir Pedido", ReceiveOrder.class },
				{ "Listar Pedidos por Proveedor",
						ListOrdersByProviderAction.class }, };
	}

	/**
	 * Ejecuta el menú principal para el administrador
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
