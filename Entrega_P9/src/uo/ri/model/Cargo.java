package uo.ri.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import uo.ri.model.types.CargoKey;


@SuppressWarnings("serial")
@Entity
@IdClass(CargoKey.class)
@Table(name="TCARGOS")
public class Cargo implements Serializable {
	@NotNull
	private Double importe = 0.0;
	@Id @ManyToOne
	private Factura factura;
	@Id @ManyToOne
	private MedioPago medioPago;
	
	public Cargo(){}
	
	

	public Cargo(Factura factura, MedioPago medioPago, double importe) {
		super();
		this.factura = factura;
		this.medioPago = medioPago;
		this.importe = importe;
	}
	
	public Cargo(double importe, Factura factura,
			MedioPago medioPago) {
		this.importe = importe;
		this.factura = factura;
		this.medioPago = medioPago;
	}



	public Factura getFactura(){
		return factura;
	}
	
	public MedioPago getMedioPago(){
		return medioPago;
	}

	void _setFactura(Factura factura){
		this.factura = factura;
	}
	
	void _setMedioPago(MedioPago medioPago){
		this.medioPago = medioPago;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}



	@Override
	public String toString() {
		return "Cargo [importe=" + importe + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((importe == null) ? 0 : importe.hashCode());
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
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
		Cargo other = (Cargo) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (importe == null) {
			if (other.importe != null)
				return false;
		} else if (!importe.equals(other.importe))
			return false;
		if (medioPago == null) {
			if (other.medioPago != null)
				return false;
		} else if (!medioPago.equals(other.medioPago))
			return false;
		return true;
	}



	



	



	
	
}
