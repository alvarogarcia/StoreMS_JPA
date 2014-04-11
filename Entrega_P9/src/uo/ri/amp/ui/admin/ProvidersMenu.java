package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.AddProviderAction;
import uo.ri.amp.ui.admin.action.AddReplacementToProviderAction;
import uo.ri.amp.ui.admin.action.DeleteProviderAction;
import uo.ri.amp.ui.admin.action.DeleteReplacementToProviderAction;
import alb.util.menu.BaseMenu;

/**
 * @author �lvaro Garc�a
 * 
 */
public class ProvidersMenu extends BaseMenu {

	/**
	 * Men� para los mec�nicos
	 */
	public ProvidersMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gesti�n de Proveedores", null },

				{ "A�adir proveedor", AddProviderAction.class },
				{ "Modificar datos proveedor", UpdateProvidersMenu.class },
				{ "Eliminar proveedor", DeleteProviderAction.class },
				{ "A�adir repuesto al Proveedor",
						AddReplacementToProviderAction.class },
				{ "Modificar repuesto del Proveedor",
						UpdateReplacementFromProviderMenu.class },
				{ "Eliminar Repuesto del Proveedor",
						DeleteReplacementToProviderAction.class },

		};
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
