package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.UpdateReplacementFromProviderByRCodeAction;
import uo.ri.amp.ui.admin.action.UpdateReplacementFromProviderByPCodeAction;
import alb.util.menu.BaseMenu;

/**
 * @author �lvaro Garc�a
 * 
 */
public class UpdateReplacementFromProviderMenu extends BaseMenu {

	/**
	 * Men� para los mec�nicos
	 */
	public UpdateReplacementFromProviderMenu() {
		menuOptions = new Object[][] {
				{
						"Administrador > Gesti�n de Proveedores > Actualizar" +
						" Proveedor",
						null },

				{ "Buscar Por C�digo de Repuesto",
						UpdateReplacementFromProviderByRCodeAction.class },
				{ "Buscar Por C�digo de Proveedor",
						UpdateReplacementFromProviderByPCodeAction.class }, };
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
