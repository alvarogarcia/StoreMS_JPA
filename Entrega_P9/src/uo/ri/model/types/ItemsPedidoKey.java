package uo.ri.model.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemsPedidoKey implements Serializable {

	Long pedido;
	Long repuesto;
	
	public ItemsPedidoKey(){}
	

	/**
	 * @param pedido
	 * @param repuesto
	 */
	public ItemsPedidoKey(Long pedido, Long repuesto) {
		super();
		this.pedido = pedido;
		this.repuesto = repuesto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsPedidoKey other = (ItemsPedidoKey) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}

}
