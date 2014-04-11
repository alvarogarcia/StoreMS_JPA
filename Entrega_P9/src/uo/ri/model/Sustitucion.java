package uo.ri.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import uo.ri.model.types.SustitucionKey;




@SuppressWarnings("serial")
@Entity
@IdClass(SustitucionKey.class)
@Table(name="TSUSTITUCIONES")
public class Sustitucion implements Serializable {

	private Integer cantidad;
	
	@Id @ManyToOne
	private Repuesto repuesto;
	@Id @ManyToOne
	private Intervencion intervencion;
	@Transient
	private Double importe = 0.0;
	
	public Sustitucion(){
		cantidad = 0;
	}
	
	

	public Sustitucion(int cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	public Sustitucion(Repuesto repuesto, Intervencion intervencion){
		this.repuesto = repuesto;
		this.intervencion = intervencion;
		intervencion.addSustitucion(this);
		this.repuesto.addSustitucion(this);
	}
	
	void _setRepuesto(Repuesto repuesto){
		this.repuesto = repuesto;
	}
	
	void _setIntervencion(Intervencion intervencion){
		this.intervencion = intervencion;
	}

	public Repuesto getRepuesto(){
		return repuesto;
	}
	
	public Intervencion getIntervencion(){
		return intervencion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		importe = cantidad * repuesto.getPrecio();

	}
	
	
	public double getImporte(){
		return importe;
	}
	
	public void setImporte(double importe){
		this.importe = importe;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((intervencion == null) ? 0 : intervencion.hashCode());
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
		Sustitucion other = (Sustitucion) obj;
		if (intervencion == null) {
			if (other.intervencion != null)
				return false;
		} else if (!intervencion.equals(other.intervencion))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}



	


	
	
}
