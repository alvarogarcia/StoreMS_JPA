package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="TREPUESTOS")
public class Repuesto implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Double precio = 0.0;
	@OneToMany(mappedBy = "repuesto")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();
	
	
	private Long existencias = 0L;
	@Column(name="CANTIDAD_MINIMA")
	private Long cantidadMinima = 0L;
	@Column(name="CANTIDAD_DESEADA")
	private Long cantidadDeseada = 0L;
	@OneToMany(mappedBy="repuesto")
	private Set<RepuestosProveedor> repuestosProveedor = new HashSet<RepuestosProveedor>();
	@OneToMany(mappedBy="repuesto")//, fetch = FetchType.EAGER)
	private Set<ItemPedido> itemsPedido = new HashSet<ItemPedido>();
	
	public Repuesto(){}
	
	

	public Repuesto(Long id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public void addItemPedido(ItemPedido itemPedido){
		itemsPedido.add(itemPedido);
		itemPedido._setRepuesto(this);
	}
	
	public Set<ItemPedido> _getItemsPedido(){
		return itemsPedido;
	}
	
	public void removeItemPedido(ItemPedido itemPedido){
		itemsPedido.remove(itemPedido);
		itemPedido._setRepuesto(null);
	}
	
	public Repuesto(String nombre, double precio){
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public void addRepuestosProveedor(RepuestosProveedor rP){
		rP._setRepuesto(this);
		repuestosProveedor.add(rP);
	}
	
	public void removeRepuestosProveedor(RepuestosProveedor rP){
		rP._setRepuesto(null);
		repuestosProveedor.remove(rP);
		
	}
	
	public Set<Sustitucion> getSustituciones(){
		return Collections.unmodifiableSet(sustituciones);
	}
	
	public void addSustitucion(Sustitucion s){
		sustituciones.add(s);
		s._setRepuesto(this);
	}
	
	public void removeSustitucion(Sustitucion s){
		sustituciones.remove(s);
		s._setRepuesto(null);
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

	public void setDescripcion(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	public Long getExistencias() {
		return existencias;
	}



	public void setExistencias(Long existencias) {
		this.existencias = existencias;
	}



	public Set<RepuestosProveedor> getRepuestosProveedor() {
		return Collections.unmodifiableSet(repuestosProveedor);
	}



	public void setRepuestosProveedor(Set<RepuestosProveedor> repuestosProveedor) {
		this.repuestosProveedor = repuestosProveedor;
	}



	public Set<ItemPedido> getItemsPedidos() {
		return Collections.unmodifiableSet(itemsPedido);
	}



	public void setItemsPedidos(Set<ItemPedido> itemsPedidos) {
		this.itemsPedido = itemsPedidos;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public void setSustituciones(Set<Sustitucion> sustituciones) {
		this.sustituciones = sustituciones;
	}

	
	


	



	/**
	 * @return the cantidadMinima
	 */
	public Long getCantidadMinima() {
		return cantidadMinima;
	}



	/**
	 * @param cantidadMinima the cantidadMinima to set
	 */
	public void setCantidadMinima(Long cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}



	/**
	 * @return the cantidadDeseada
	 */
	public Long getCantidadDeseada() {
		return cantidadDeseada;
	}



	/**
	 * @param cantidadDeseada the cantidadDeseada to set
	 */
	public void setCantidadDeseada(Long cantidadDeseada) {
		this.cantidadDeseada = cantidadDeseada;
	}



	/**
	 * @return the itemsPedido
	 */
	public Set<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}



	/**
	 * @param itemsPedido the itemsPedido to set
	 */
	public void setItemsPedido(Set<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}



	@Override
	public String toString() {
		return "Repuesto [nombre=" + nombre + ", precio=" + precio
				+ ", existencias=" + existencias + "]";
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
		Repuesto other = (Repuesto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	
	

}
