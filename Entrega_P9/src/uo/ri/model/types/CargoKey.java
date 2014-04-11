package uo.ri.model.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CargoKey implements Serializable {

	Long factura;
	Long medioPago;
	
	public CargoKey(){}
	
	
	
	/**
	 * @param factura
	 * @param medioPago
	 */
	public CargoKey(Long factura, Long medioPago) {
		super();
		this.factura = factura;
		this.medioPago = medioPago;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoKey other = (CargoKey) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (medioPago == null) {
			if (other.medioPago != null)
				return false;
		} else if (!medioPago.equals(other.medioPago))
			return false;
		return true;
	}
	
	
	
}
