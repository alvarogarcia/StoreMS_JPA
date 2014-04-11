package uo.ri.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.model.types.ItemsPedidoKey;

@SuppressWarnings("serial")
@Entity
@IdClass(ItemsPedidoKey.class)
@Table(name="TITEMSPEDIDO")
public class ItemPedido implements Serializable {
	@Id @ManyToOne
	private Pedido pedido;
	@Id @ManyToOne
	private Repuesto repuesto;
	
	private Integer cantidad = 0;
	
	private Double Precio;

	/**
	 * Constructor with all the fields
	 * @param pedido ID del pedido
	 * @param repuesto ID del repuesto
	 * @param cantidad Cantidad del pedido para ese repuesto
	 * @param precio Precio del repuesto en ese pedido.
	 */
	public ItemPedido(Pedido pedido, Repuesto repuesto, Integer cantidad,
			Double precio) {
		super();
		this.pedido = pedido;
		pedido._getItemsPedido().add(this);
		this.repuesto = repuesto;
		repuesto._getItemsPedido().add(this);
		this.cantidad = cantidad;
		Precio = precio;
	}
	
	public void unlink(){
		pedido._getItemsPedido().remove(this);
		pedido = null;
		
		repuesto._getItemsPedido().remove(this);
		repuesto = null;
	}
	
	/**
	 * Constructor sin parámetros
	 */
	public ItemPedido(){
	}

	/**
	 * @return the order
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the order to set
	 */
	void _setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the replacement
	 */
	public Repuesto getRepuesto() {
		return repuesto;
	}

	/**
	 * @param repuesto the replacement to set
	 */
	void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	/**
	 * @return the quantity
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the quantity to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the price
	 */
	public Double getPrecio() {
		return Precio;
	}

	/**
	 * @param precio the price to set
	 */
	public void setPrecio(Double precio) {
		Precio = precio;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemsPedido [pedido=" + pedido + ", repuesto=" + repuesto
				+ ", cantidad=" + cantidad + ", Precio=" + Precio + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		ItemPedido other = (ItemPedido) obj;
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
