package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.AddProviderAction;
import uo.ri.amp.ui.admin.action.AddReplacementToProviderAction;
import uo.ri.amp.ui.admin.action.DeleteProviderAction;
import uo.ri.amp.ui.admin.action.DeleteReplacementToProviderAction;
import alb.util.menu.BaseMenu;

/**
 * @author Álvaro García
 * 
 */
public class ProvidersMenu extends BaseMenu {

	/**
	 * Menú para los mecánicos
	 */
	public ProvidersMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de Proveedores", null },

				{ "Añadir proveedor", AddProviderAction.class },
				{ "Modificar datos proveedor", UpdateProvidersMenu.class },
				{ "Eliminar proveedor", DeleteProviderAction.class },
				{ "Añadir repuesto al Proveedor",
						AddReplacementToProviderAction.class },
				{ "Modificar repuesto del Proveedor",
						UpdateReplacementFromProviderMenu.class },
				{ "Eliminar Repuesto del Proveedor",
						DeleteReplacementToProviderAction.class },

		};
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
