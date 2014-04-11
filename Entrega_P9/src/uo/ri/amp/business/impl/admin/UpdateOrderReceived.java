package uo.ri.amp.business.impl.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uo.ri.amp.business.impl.Command;

import uo.ri.amp.persistence.OrderFinder;
import uo.ri.amp.persistence.util.Jpa;
import uo.ri.model.ItemPedido;
import uo.ri.model.Pedido;
import uo.ri.model.Repuesto;
import uo.ri.model.types.PedidoStatus;

/**
 * @author Álvaro García
 * 
 */
public class UpdateOrderReceived implements Command {

	Pedido pedido;

	/**
	 * Constructor
	 * 
	 * @param pedido
	 *            Mapa con los datos del pedido
	 */
	public UpdateOrderReceived(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public Object execute() {
		Pedido pedidoAct = OrderFinder.findOrderByCode(pedido.getId());
		pedidoAct.setEstado_recepcion(PedidoStatus.RECIBIDO);
		pedidoAct.setFecha_Recepcion(new Date());

		Set<ItemPedido> itemsPedido = pedidoAct.getItemsPedido();
		for (ItemPedido iP : itemsPedido) {
			// Por cada itemPEdido saco su Repuesto y desde él actualizo su
			// precio y
			// cantidad y hago un merge
			Repuesto repuesto = iP.getRepuesto();
			Long cantidadAnterior = repuesto.getExistencias();
			Double precioAnterior = repuesto.getPrecio();
			Long cantidadAhora = cantidadAnterior + iP.getCantidad();
			Double precioAhora = ((cantidadAnterior * precioAnterior) + (iP
					.getCantidad() * iP.getPrecio()))
					/ (cantidadAnterior + iP.getCantidad());

			repuesto.setExistencias(cantidadAhora);
			repuesto.setPrecio(precioAhora);
			Jpa.getManager().merge(repuesto);

		}

		// Después de actualizar los precios y cantidades de cada item del
		// Pedido
		// hago un merge con el Pedido para que se actualice en la base de datos
		// y se marque como Recibido y que como fecha de Recepción se ponga la
		// nueva.

		return Jpa.getManager().merge(pedidoAct);

	}

}
