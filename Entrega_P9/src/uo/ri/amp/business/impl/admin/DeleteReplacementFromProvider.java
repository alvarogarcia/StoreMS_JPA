package uo.ri.amp.business.impl.admin;

import java.util.Set;

import alb.util.BusinessException;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.ItemPedido;
import uo.ri.model.Pedido;
import uo.ri.model.RepuestosProveedor;
import uo.ri.model.types.PedidoStatus;
import uo.ri.model.types.RepuestosProveedorKey;

/**
 * @author alvaroastur4
 * 
 */
public class DeleteReplacementFromProvider implements Command {

	Long replacementCode, providerCode;

	/**
	 * Constructor de la clase DeleteReplacementFromProvider
	 * 
	 * @param replacementCode
	 *            Código del repuesto a eliminar
	 * @param providerCode
	 *            Código del proveedor del que se le va a eliminar el repuesto
	 */
	public DeleteReplacementFromProvider(Long replacementCode, Long providerCode) {
		this.replacementCode = replacementCode;
		this.providerCode = providerCode;
	}

	@Override
	public Object execute() throws BusinessException {
		// No se puede eliminar si el proveedor ya tiene algún pedido para ese
		// repuesto
		RepuestosProveedorKey rpK = new RepuestosProveedorKey(replacementCode,
				providerCode);
		RepuestosProveedor repuestoProveedor = Jpa.getManager().find(
				RepuestosProveedor.class, rpK);
		Set<Pedido> pedidos = repuestoProveedor.getProveedor().getPedidos();
		for (Pedido pedido : pedidos) {
			if (!pedido.getEstado_recepcion().equals(PedidoStatus.RECIBIDO)) {
				for (ItemPedido iP : pedido.getItemsPedido()) {
					if (iP.getRepuesto()
							.equals(repuestoProveedor.getRepuesto()))
						throw new BusinessException(
								"ERROR. No se puede eliminar un repuesto de un " +
								"proveedor para el que hay pedidos");

				}
			}

		}
		Jpa.getManager().remove(repuestoProveedor);

		return null;
	}

}
