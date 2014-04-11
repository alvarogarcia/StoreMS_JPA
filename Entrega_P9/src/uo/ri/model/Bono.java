package uo.ri.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("TBonos")
public class Bono extends MedioPago implements Serializable {

	private Double disponible = 0.0;

	public Bono() {
	}

	public double getDisponible() {
		return disponible;
	}

	public void setDisponible(double disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Bono [disponible=" + disponible + ", acumulado="
				+ getAcumulado() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((disponible == null) ? 0 : disponible.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bono other = (Bono) obj;
		if (disponible == null) {
			if (other.disponible != null)
				return false;
		} else if (!disponible.equals(other.disponible))
			return false;
		return true;
	}

	
	
	

}
