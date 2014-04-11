package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.UpdateReplacementFromProviderByRCodeAction;
import uo.ri.amp.ui.admin.action.UpdateReplacementFromProviderByPCodeAction;
import alb.util.menu.BaseMenu;

/**
 * @author Álvaro García
 * 
 */
public class UpdateReplacementFromProviderMenu extends BaseMenu {

	/**
	 * Menú para los mecánicos
	 */
	public UpdateReplacementFromProviderMenu() {
		menuOptions = new Object[][] {
				{
						"Administrador > Gestión de Proveedores > Actualizar" +
						" Proveedor",
						null },

				{ "Buscar Por Código de Repuesto",
						UpdateReplacementFromProviderByRCodeAction.class },
				{ "Buscar Por Código de Proveedor",
						UpdateReplacementFromProviderByPCodeAction.class }, };
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
