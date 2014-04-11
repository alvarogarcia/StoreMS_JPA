package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.model.types.PedidoStatus;

@SuppressWarnings("serial")
@Entity
@Table(name="TPEDIDOS")
public class Pedido implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_Creacion = new Date();
	@Temporal(TemporalType.DATE)
	private Date fecha_Recepcion;
	
	private Double precio = 0.0;
	@ManyToOne
	private Proveedor proveedor;
	@OneToMany(mappedBy="pedido", fetch = FetchType.EAGER)
	private Set<ItemPedido> itemsPedido = new HashSet<ItemPedido>();
	
	@Enumerated(EnumType.STRING)
	private PedidoStatus estado_recepcion;
	
	
	
	

	
	/**
	 * @param id
	 * @param fecha_Creacion
	 * @param fecha_Recepcion
	 * @param precio
	 * @param proveedor
	 * @param itemsPedido
	 * @param estado_recepcion
	 */
	public Pedido(Long id, Date fecha_Creacion, Date fecha_Recepcion,
			Double precio, Proveedor proveedor, Set<ItemPedido> itemsPedido,
			PedidoStatus estado_recepcion) {
		super();
		this.id = id;
		this.fecha_Creacion = fecha_Creacion;
		this.fecha_Recepcion = fecha_Recepcion;
		this.precio = precio;
		this.proveedor = proveedor;
		this.itemsPedido = itemsPedido;
		this.estado_recepcion = estado_recepcion;
	}

	public Pedido(){}

	void _setProveedor(Proveedor proveedor){
		this.proveedor = proveedor;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha_Creacion() {
		return fecha_Creacion;
	}
	public void setFecha_Creacion(Date fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}
	public Date getFecha_Recepcion() {
		return fecha_Recepcion;
	}
	public void setFecha_Recepcion(Date fecha_Recepcion) {
		this.fecha_Recepcion = fecha_Recepcion;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public PedidoStatus getEstado_recepcion() {
		return estado_recepcion;
	}
	public void setEstado_recepcion(PedidoStatus estado_recepcion) {
		this.estado_recepcion = estado_recepcion;
	}

	/**
	 * @return the itemsPedido
	 */
	public Set<ItemPedido> getItemsPedido() {
		return Collections.unmodifiableSet(itemsPedido);
	}

	/**
	 * @param itemsPedido the itemsPedido to set
	 */
	public void setItemsPedido(Set<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	
	public Set<ItemPedido> _getItemsPedido(){
		return itemsPedido;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha_Creacion=" + fecha_Creacion
				+ ", fecha_Recepcion=" + fecha_Recepcion + ", precio=" + precio
				+ ", proveedor=" + proveedor + ", estado_recepcion="
				+ estado_recepcion + "]";
	}
	
	
	public void addItemPedido(ItemPedido itemPedido){
		itemPedido._setPedido(this);
		itemsPedido.add(itemPedido);
		
	}
	
	public void removeItemPedido(ItemPedido itemPedido){
		itemPedido._setPedido(null);
		itemsPedido.remove(itemPedido);
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	
	
	

}
