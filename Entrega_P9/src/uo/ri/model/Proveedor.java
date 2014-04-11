package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TPROVEEDORES")
public class Proveedor implements Serializable {
	
	@Id
	@GeneratedValue
	Long id;
	String nombre;
	@OneToMany(mappedBy="proveedor")
	Set<RepuestosProveedor> repuestosProveedor = new HashSet<RepuestosProveedor>();
	@OneToMany(mappedBy="proveedor")//,  fetch = FetchType.EAGER)
	Set<Pedido> pedidos = new HashSet<Pedido>();
	
	
	
	public Proveedor(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Proveedor(){}
	
	
	public Set<RepuestosProveedor> getRepuestosProveedor() {
		return Collections.unmodifiableSet(repuestosProveedor);
	}



	public void setRepuestosProveedor(Set<RepuestosProveedor> repuestosProveedor) {
		this.repuestosProveedor = repuestosProveedor;
	}



	public Set<Pedido> getPedidos() {
		return Collections.unmodifiableSet(pedidos);
	}



	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}



	public void addPedido(Pedido pedido){
		pedido._setProveedor(this);
		pedidos.add(pedido);
		
	}
	
	public void removePedido(Pedido pedido){
		pedido._setProveedor(null);
		pedidos.remove(pedido);
		
	}
	
	public void addRepuestosProveedor(RepuestosProveedor rP){
		rP._setProveedor(this);
		repuestosProveedor.add(rP);
		
	}
	
	public void removeRepuestosProveedor(RepuestosProveedor rP){
		rP._setProveedor(null);
		repuestosProveedor.remove(rP);
		
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + "]";
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
		Proveedor other = (Proveedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
