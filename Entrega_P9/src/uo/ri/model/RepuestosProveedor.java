package uo.ri.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.model.types.RepuestosProveedorKey;

@SuppressWarnings("serial")
@Entity
@IdClass(RepuestosProveedorKey.class)
@Table(name="TREPUESTOSPROVEEDOR")
public class RepuestosProveedor implements Serializable {
	
	@Id @ManyToOne
	Repuesto repuesto;
	@Id @ManyToOne
	Proveedor proveedor;
	Double precio = 0.0;
	
	public RepuestosProveedor(Repuesto repuesto, Proveedor proveedor,
			Double precio) {
		super();
		this.repuesto = repuesto;
		this.proveedor = proveedor;
		this.precio = precio;
	}
	
	public RepuestosProveedor(){}
	
	void _setRepuesto(Repuesto repuesto){
		this.repuesto = repuesto;
	}
	
	void _setProveedor(Proveedor proveedor){
		this.proveedor = proveedor;
	}
	
	public Repuesto getRepuesto() {
		return repuesto;
	}



	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		return "RepuestosProveedor [repuesto=" + repuesto + ", proveedor="
				+ proveedor + ", precio=" + precio + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
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
		RepuestosProveedor other = (RepuestosProveedor) obj;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}
	
	
	

}
